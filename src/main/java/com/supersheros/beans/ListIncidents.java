package com.supersheros.beans;

public class ListIncidents {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BeanException {
        if(name.length() >50){
            throw new BeanException("Le nom est trop grand ! (50 caractères maximum !)");
        } else {
            this.name = name;
        }

    }
}
