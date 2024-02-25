package main.entities;

import jakarta.persistence.*;

/**
 * Locations entity for the locations table in the database.
 */
@Entity
@Table(name="locations")
public class Locations {
    @Id
    @Column(name = "bay")
    private String bay;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lng")
    private Double lng;

    public Locations() {}
    public Locations(String bay, Double lat, Double lng) {
        super();
        this.bay = bay;
        this.lat = lat;
        this.lng = lng;
    }

    public String getBay() {
        return bay;
    }
    public void setBay(String bay) {
        this.bay = bay;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }
}
