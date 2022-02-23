package com.supersheros.dao;

import com.supersheros.beans.Heros;
import com.supersheros.beans.Incidents;
import com.supersheros.beans.ListIncidents;

import java.util.List;

public interface ListIncidentDao {

    List<ListIncidents> lister() throws DaoException;

    List<ListIncidents> listerIncidentOfHero(String NameHero) throws DaoException;

    boolean addIncidentToHero(String nameHero, int id_incident) throws DaoException;

    boolean deleteIncidentToHero(String nameHero) throws DaoException;
}
