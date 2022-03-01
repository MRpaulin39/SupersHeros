package com.supersheros.beans;

public class Heros {
    private String name;
    private String password;
    private String passwordCheck;
    private String city;
    private float cityLat;
    private float cityLong;
    private String phone;

    /**
     * @return Le nom du héro
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Le nom du héro
     * @throws BeanException Exception de modèle
     */
    public void setName(String name) throws BeanException{
        if (name.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (name.length() > 50) {
            throw new BeanException("Champ 'Nom du Héro' invalide ! (50 caractère maximum)");
        } else {
            this.name = name;
        }

    }

    /**
     * @return Mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Mot de passe
     * @throws BeanException Exception de modèle
     */
    public void setPassword(String password) throws BeanException {
        if (password.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (password.length() > 60) {
            throw new BeanException("Champ 'Mot de passe' invalide ! (60 caractère maximum)");
        } else {
            this.password = password;
        }

    }

    /**
     * @return Mot de passe confirmé
     */
    public String getPasswordCheck() {
        return passwordCheck;
    }

    /**
     * @param passwordCheck Mot de passe confirmé
     * @throws BeanException Exception de modèle
     */
    public void setPasswordCheck(String passwordCheck) throws BeanException {
        if (passwordCheck.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (passwordCheck.length() > 60) {
            throw new BeanException("Champ 'Mot de passe' invalide ! (60 caractère maximum)");
        } else {
            this.passwordCheck = passwordCheck;
        }
    }

    /**
     * @return Le nom de la ville
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city Le nom de la ville
     * @throws BeanException Exception de modèle
     */
    public void setCity(String city) throws BeanException{

        if (city.length() == 0){
            throw new BeanException("Veuillez remplir tous les champs !");
        } else if (city.length() > 80) {
            throw new BeanException("Champ 'Ville' invalide ! (80 caractère maximum)");
        } else {
            this.city = city;
        }
    }

    /**
     * @return La latitude la de ville
     */
    public float getCityLat() {
        return cityLat;
    }

    /**
     * @param cityLat La latitude de la ville
     */
    public void setCityLat(float cityLat) {
        this.cityLat = cityLat;
    }

    /**
     * @return La longitude de la ville
     */
    public float getCityLong() {
        return cityLong;
    }

    /**
     * @param cityLong La longitude de la ville
     */
    public void setCityLong(float cityLong) {
        this.cityLong = cityLong;
    }

    /**
     * @return Le numéro de téléphone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone Le numéro de téléphone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
