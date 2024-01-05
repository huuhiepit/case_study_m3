package org.example.web_app.dao.impl;

import org.example.web_app.model.Tour;

import java.util.List;

public interface ITourDAO {
    List<Tour> getAll();
    Tour getBy(long idTour);
    boolean add(Tour tour);
    boolean update(Tour tour);
    boolean delete(long idTour);

}
