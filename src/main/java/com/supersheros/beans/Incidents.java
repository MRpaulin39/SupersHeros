package com.supersheros.beans;

public class Incidents {
    private int id_incident;
    private int id_incident_list;
    private String city;
    private float cityLat;
    private float cityLong;
    private float cityDistance;

    public int getId_incident() {
        return id_incident;
    }

    public void setId_incident(int id_incident) {
        this.id_incident = id_incident;
    }

    public int getId_incident_list() {
        return id_incident_list;
    }

    public void setId_incident_list(int id_incident_list) {
        this.id_incident_list = id_incident_list;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getCityLat() {
        return cityLat;
    }

    public void setCityLat(float cityLat) {
        this.cityLat = cityLat;
    }

    public float getCityLong() {
        return cityLong;
    }

    public void setCityLong(float cityLong) {
        this.cityLong = cityLong;
    }

    public float getCityDistance() {
        return cityDistance;
    }

    public void setCityDistance(float cityDistance) {
        this.cityDistance = cityDistance;
    }
}
