package com.supersheros.beans;

public class ListIncidents {
    private int id;
    private String name;

    /**
     * @return ID de l'incident
     */
    public int getId() {
        return id;
    }

    /**
     * @param id ID de l'incident
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Le nom de l'incident
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Le nom de l'incident
     * @throws BeanException Exception de modèle
     */
    public void setName(String name) throws BeanException {
        if(name.length() >50){
            throw new BeanException("Le nom est trop grand ! (50 caractères maximum !)");
        } else {
            this.name = name;
        }

    }
}
