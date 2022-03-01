package com.supersheros.dao;

import com.supersheros.beans.Incidents;

import java.util.List;

public interface IncidentDao {

    /**
     * @param city_Lat Latitude de la ville
     * @param city_Long Longitude de la ville
     * @param IdIncident ID de l'incident
     * @return La liste des héros qui sont à moins de 50km de l'incident signalé en fonction des coordonnées de l'habitat du héro
     * @throws DaoException Exception de la base de données
     */
    List<Incidents> lister(Float city_Lat, Float city_Long, Integer IdIncident) throws DaoException;

}
