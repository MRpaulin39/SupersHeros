package com.supersheros.beans;

public class Heros {
    private int id;
    private String name;
    private String password;
    private String city;
    private float cityLat;
    private float cityLong;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
