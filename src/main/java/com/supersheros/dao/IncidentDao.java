package com.supersheros.dao;

import com.supersheros.beans.Heros;
import com.supersheros.beans.Incidents;

import java.util.List;

public interface IncidentDao {

    List<Incidents> lister(Float city_Lat, Float city_Long, Integer IdIncident) throws DaoException;

}
