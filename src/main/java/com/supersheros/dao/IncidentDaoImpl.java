package com.supersheros.dao;

import com.supersheros.beans.BeanException;
import com.supersheros.beans.ListIncidents;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private DaoFactory daoFactory;

    IncidentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<ListIncidents> lister() throws DaoException {
        List<ListIncidents> listIncidents = new ArrayList<ListIncidents>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT ID_INCIDENT_LIST, NAME FROM incidents_list;");

            while (resultat.next()) {
                int id = resultat.getInt("ID_INCIDENT_LIST");
                String name = resultat.getString("NAME");

                ListIncidents oneIncident = new ListIncidents();
                oneIncident.setId(id);
                oneIncident.setName(name);

                listIncidents.add(oneIncident);
            }
        } catch (SQLException | BeanException e) {
            e.printStackTrace();
            throw new DaoException("Impossible de communiquer avec la base de données");

        }

        return listIncidents;
    }
}
