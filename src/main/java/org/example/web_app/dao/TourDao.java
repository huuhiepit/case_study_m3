package org.example.web_app.dao;

import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.ERole;
import org.example.web_app.model.en.EType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDao extends ConnectionDB implements ITourDAO {
    protected String SELECT_ALL_TOUR = "SELECT * FROM db_manager_tour.view_tour;";
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

}
