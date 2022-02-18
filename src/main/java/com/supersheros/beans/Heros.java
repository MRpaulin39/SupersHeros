package com.supersheros.beans;

import java.util.Objects;

public class Heros {
    private int id;
    private String name;
    private String password;
    private String passwordCheck;
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

    public void setName(String name) throws BeanException{
        if (name.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (name.length() > 50) {
            throw new BeanException("Champ 'Nom du Héro' invalide ! (50 caractère maximum)");
        } else {
            this.name = name;
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws BeanException {
        if (password.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (password.length() > 60) {
            throw new BeanException("Champ 'Mot de passe' invalide ! (60 caractère maximum)");
        } else {
            this.password = password;
        }

    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) throws BeanException {
        if (passwordCheck.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (passwordCheck.length() > 60) {
            throw new BeanException("Champ 'Mot de passe' invalide ! (60 caractère maximum)");
        } else {
            this.passwordCheck = passwordCheck;
        }

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
