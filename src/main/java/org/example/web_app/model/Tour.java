package org.example.web_app.model;

import org.example.web_app.model.en.EStatusTour;
import org.example.web_app.model.en.EType;

public class Tour {
    private long id;
    private String name;
    private String urlImage;
    private EType type;

    public Tour(long id, String name, String urlImage, EType type) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", type=" + type +
                '}';
    }
}
