package com.supersheros.dao;

import com.supersheros.beans.BeanException;
import com.supersheros.beans.Incidents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private DaoFactory daoFactory;

    IncidentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<Incidents> lister(Float city_Lat, Float city_Long, Integer IdIncident) throws DaoException {
        List<Incidents> listHerosIncidents = new ArrayList<Incidents>();
        Connection connexion = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("SELECT NAME,PHONE,ROUND((ACOS(SIN(RADIANS(CITY_LAT))*SIN(RADIANS(?))+COS(RADIANS(CITY_LAT))*COS(RADIANS(?))*COS(RADIANS(CITY_LONG-?)))*6371),2) AS DISTANCE " +
                    "FROM HEROS " +
                    "INNER JOIN ASSOCIATION_HERO_INCIDENT_LIST ON HEROS.ID_HERO = ASSOCIATION_HERO_INCIDENT_LIST.ID_HERO " +
                    "WHERE (ACOS(SIN(RADIANS(CITY_LAT))*SIN(RADIANS(?))+COS(RADIANS(CITY_LAT))*COS(RADIANS(?))*COS(RADIANS(CITY_LONG-?)))*6371) < 50 AND ASSOCIATION_HERO_INCIDENT_LIST.ID_INCIDENT_LIST = ? " +
                    "ORDER BY DISTANCE;");
            preparedstatement.setFloat(1, city_Lat);
            preparedstatement.setFloat(2, city_Lat);
            preparedstatement.setFloat(3, city_Long);
            preparedstatement.setFloat(4, city_Lat);
            preparedstatement.setFloat(5, city_Lat);
            preparedstatement.setFloat(6, city_Long);
            preparedstatement.setInt(7, IdIncident);

            resultat = preparedstatement.executeQuery();

            while (resultat.next()) {
                String name = resultat.getString("NAME");
                String distance = resultat.getString("DISTANCE");
                String phone = resultat.getString("PHONE");

                Incidents oneHeroIncident = new Incidents();
                oneHeroIncident.setNameHero(name);
                oneHeroIncident.setCityDistance(Float.valueOf(distance));
                oneHeroIncident.setPhone(phone);

                listHerosIncidents.add(oneHeroIncident);

            }
        } catch (SQLException | BeanException e) {
            e.printStackTrace();
            throw new DaoException("Impossible de communiquer avec la base de données");

        }

        return listHerosIncidents;
    }

}
