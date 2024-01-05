package org.example.web_app.dao;

import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.EType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDAO extends ConnectionDB implements ITourDAO {
    protected String SELECT_ALL_TOUR = "SELECT * FROM db_manager_tour.view_tour;";
    protected String SELECT_TOUR_ID = "SELECT * FROM db_manager_tour.view_tour where id = ?";
    protected String INSERT_INTO_TOUR = "call db_manager_tour.insertIntoTour(?, ?, ?);";
    protected String UPDATE_TOUR = "call db_manager_tour.updateTour(?, ?, ?, ?);";
    protected String DELETE_TOUR = "call db_manager_tour.deleteTour(?);";
    @Override
    public List<Tour> getAll() {
        List<Tour> tours = new ArrayList<>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_TOUR);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //long id, String name, String urlImage, EType type, int total
                tours.add(new Tour(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("urlImage"),
                        EType.valueOf(rs.getString("type")),
                        rs.getInt("totalTrips")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tours;
    }

    @Override
    public Tour getBy(long idTour) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_TOUR_ID);
            statement.setLong(1, idTour);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Tour(idTour, rs.getString("name"),
                        rs.getString("urlImage"),
                        EType.valueOf(rs.getString("type")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean add(Tour tour) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(INSERT_INTO_TOUR);
            statement.setString(1, tour.getName());
            statement.setString(2, tour.getUrlImage());
            statement.setString(3, tour.getType() + "");

            System.out.println(statement);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Tour tourNew) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(UPDATE_TOUR);
            statement.setString(1, tourNew.getName());
            statement.setString(2, tourNew.getUrlImage());
            statement.setString(3, tourNew.getType() + "");
            statement.setLong(4, tourNew.getId());

            System.out.println(statement);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(long idTour) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(DELETE_TOUR);
            statement.setLong(1, idTour);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
