package org.example.web_app.dao.impl;

import org.example.web_app.model.DescriptionTour;

import java.util.List;

public interface IDescriptionTourDAO {
    List<DescriptionTour> getAll();
    boolean insertInto(DescriptionTour descriptionTour);
    boolean update(DescriptionTour descriptionTour);
    boolean delete(DescriptionTour descriptionTour);
}
