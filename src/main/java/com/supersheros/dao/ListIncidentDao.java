package com.supersheros.dao;

import com.supersheros.beans.Heros;

public interface ListIncidentDao {


    boolean addIncidentToHero(String nameHero, int id_incident) throws DaoException;

    boolean deleteIncidentToHero() throws DaoException;
}
