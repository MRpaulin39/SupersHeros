package com.supersheros.dao;

import com.supersheros.beans.Incidents;

import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private DaoFactory daoFactory;

    IncidentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<Incidents> lister() throws DaoException {
        return null;
    }

    @Override
    public boolean addIncident(int id_incident, int id_incident_list, String city, float city_lat, float city_long) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteIncident(int id_incident) throws DaoException {
        return false;
    }

}
