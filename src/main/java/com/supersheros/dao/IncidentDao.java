package com.supersheros.dao;

import com.supersheros.beans.Incidents;

import java.util.List;

public interface IncidentDao {

    List<Incidents> lister() throws DaoException;

    boolean addIncident(int id_incident, int id_incident_list, String city, float city_lat, float city_long) throws DaoException;

    boolean deleteIncident(int id_incident) throws DaoException;

}
