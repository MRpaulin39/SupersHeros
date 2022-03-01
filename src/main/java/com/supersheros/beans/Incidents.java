package com.supersheros.beans;

public class Incidents {
    private String nameHero;
    private Float cityDistance;
    private String phone;

    /**
     * @return Le nom du héro
     */
    public String getNameHero() {
        return nameHero;
    }

    /**
     * @param nameHero Le nom du héro
     * @throws BeanException Exception de modèle
     */
    public void setNameHero(String nameHero) throws BeanException {
        if (nameHero.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (nameHero.length() > 50) {
            throw new BeanException("Champ 'Nom du Héro' invalide ! (50 caractère maximum)");
        } else {
            this.nameHero = nameHero;
        }
    }

    public Float getCityDistance() {
        return cityDistance;
    }

    /**
     * @param cityDistance La distance calculé entre les coordonnées de l'habitat du hérp et celui de l'incident
     */
    public void setCityDistance(Float cityDistance) {
        this.cityDistance = cityDistance;
    }

    /**
     * @return Le numéro de téléphone du héro
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone Le numéro de téléphone du héro
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
