package org.example.web_app.dao;

import org.example.web_app.dao.impl.IDescriptionTourDAO;
import org.example.web_app.model.DescriptionTour;
import org.example.web_app.model.en.EStatusTour;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DescriptionTourDAO extends ConnectionDB implements IDescriptionTourDAO {

    protected String SELECT_ALL_DESCRIPTION_BY_ID_TOUR = "SELECT * FROM db_manager_tour.view_description_tour where tours_id = ?;";
    protected String SELECT_DESCRIPTION_TOUR_BY_ID = "SELECT * FROM db_manager_tour.view_description_tour where id = ?;";
    protected String INSERT_INTO_DESCRIPTION_TOUR = "call db_manager_tour.insertIntoDescriptionTour(?, ?, ?, ?, ?, ?);\n";
    protected String UPDATE_DESCRIPTION_BY_ID = "call db_manager_tour.updateDescriptionTour(?, ?, ?, ?, ?, ?);\n";
    protected String DELETE_DESCRIPTION = "call db_manager_tour.deleteDescriptionTour(?);";
    @Override
    public List<DescriptionTour> getAll(long idTour) {
        List<DescriptionTour> descriptionTours = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_DESCRIPTION_BY_ID_TOUR);
            statement.setLong(1, idTour);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                long id, LocalDate dateStart, LocalDate dateEnd, int seat, long price, EStatus status, String description, long idTour
                LocalDate dateStart = rs.getDate("dateStart").toLocalDate();
                LocalDate dateEnd = rs.getDate("dateEnd").toLocalDate();
                descriptionTours.add(new DescriptionTour(rs.getLong("id"),
                        dateStart,
                        dateEnd,
                        rs.getInt("seat"),
                        rs.getLong("price"),
                        EStatusTour.valueOf(rs.getString("status")),
                        rs.getString("description"),
                        idTour
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return descriptionTours;
    }

    @Override
    public DescriptionTour getBy(long idDescription) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_DESCRIPTION_TOUR_BY_ID);
            statement.setLong(1, idDescription);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                long id, LocalDate dateStart, LocalDate dateEnd, int seat, long price, EStatus status, String description, long idTour
                LocalDate dateStart = rs.getDate("dateStart").toLocalDate();
                LocalDate dateEnd = rs.getDate("dateEnd").toLocalDate();
                return new DescriptionTour(rs.getLong("id"),
                        dateStart,
                        dateEnd,
                        rs.getInt("seat"),
                        rs.getLong("price"),
                        EStatusTour.valueOf(rs.getString("status")),
                        rs.getString("description"),
                        Long.parseLong(rs.getString("tours_id"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean insertInto(DescriptionTour descriptionTour) {
        try {
            //'2024-01-02', '2024-01-03', 10, 100, 'Đi đâu thì không biết', 1
            PreparedStatement statement = getConnection().prepareStatement(INSERT_INTO_DESCRIPTION_TOUR);
            statement.setDate(1, java.sql.Date.valueOf(descriptionTour.getDateStart()));
            statement.setDate(2, java.sql.Date.valueOf(descriptionTour.getDateEnd()));
            statement.setInt(3, descriptionTour.getSeat());
            statement.setLong(4, descriptionTour.getPrice());
            statement.setString(5, descriptionTour.getDescription());
            statement.setLong(6, descriptionTour.getIdTour());
            System.out.println(statement);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override

    public boolean update(DescriptionTour descriptionTour) {
        try {
            //'2024-01-02', '2024-01-03', 10, 100, 'Đi đâu thì không biết', 1
            PreparedStatement statement = getConnection().prepareStatement(UPDATE_DESCRIPTION_BY_ID);
            statement.setDate(1, java.sql.Date.valueOf(descriptionTour.getDateStart()));
            statement.setDate(2, java.sql.Date.valueOf(descriptionTour.getDateEnd()));
            statement.setInt(3, descriptionTour.getSeat());
            statement.setLong(4, descriptionTour.getPrice());
            statement.setString(5, descriptionTour.getDescription());
            statement.setLong(6, descriptionTour.getId());
            System.out.println(statement);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(DELETE_DESCRIPTION);
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
