package com.supersheros.beans;

public class Incidents {
    private String nameHero;
    private String city;
    private Float cityDistance;
    private String phone;

    public String getNameHero() {
        return nameHero;
    }

    public void setNameHero(String nameHero) throws BeanException {
        if (nameHero.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (nameHero.length() > 50) {
            throw new BeanException("Champ 'Nom du Héro' invalide ! (50 caractère maximum)");
        } else {
            this.nameHero = nameHero;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws BeanException {
        if (city.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (city.length() > 80) {
            throw new BeanException("Champ 'Ville' invalide ! (80 caractère maximum)");
        } else {
            this.city = city;
        }
    }

    public Float getCityDistance() {
        return cityDistance;
    }

    public void setCityDistance(Float cityDistance) {
        this.cityDistance = cityDistance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
