package org.example.web_app.model;

import org.example.web_app.model.DescriptionTour;
import org.example.web_app.model.Tour;

import java.util.List;

public class TourDescriptionPair {
    private Tour tour;
    private List<DescriptionTour> descriptionTourList;
    public TourDescriptionPair() {};

    public TourDescriptionPair(Tour tour, List<DescriptionTour> descriptionTourList) {
        this.tour = tour;
        this.descriptionTourList = descriptionTourList;
    }

    public Tour getTour() {
        return tour;
    }

    public  List<DescriptionTour> getDescriptionTour() {
        return descriptionTourList;
    }
    public int getTotalDescription() {
        return this.descriptionTourList.size();
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<DescriptionTour> getDescriptionTourList() {
        return descriptionTourList;
    }

    public void setDescriptionTourList(List<DescriptionTour> descriptionTourList) {
        this.descriptionTourList = descriptionTourList;
    }

}
