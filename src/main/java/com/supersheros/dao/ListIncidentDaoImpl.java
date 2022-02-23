package com.supersheros.dao;

import com.supersheros.beans.BeanException;
import com.supersheros.beans.Heros;
import com.supersheros.beans.ListIncidents;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListIncidentDaoImpl implements ListIncidentDao{
    private DaoFactory daoFactory;

    ListIncidentDaoImpl(DaoFactory daoFactory) {
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

    @Override
    public List<ListIncidents> listerIncidentOfHero(String NameHero) throws DaoException {
        List<ListIncidents> listIncidents = new ArrayList<ListIncidents>();
        Connection connexion = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("SELECT ASSOCIATION_HERO_INCIDENT_LIST.ID_INCIDENT_LIST AS ID_INCIDENT,INCIDENTS_LIST.NAME AS NAME_INCIDENT " +
                    "FROM ASSOCIATION_HERO_INCIDENT_LIST " +
                    "INNER JOIN INCIDENTS_LIST ON ASSOCIATION_HERO_INCIDENT_LIST.ID_INCIDENT_LIST = INCIDENTS_LIST.ID_INCIDENT_LIST " +
                    "WHERE ID_HERO IN (SELECT ID_HERO FROM HEROS WHERE NAME = ?);");

            preparedstatement.setString(1, NameHero);

            resultat = preparedstatement.executeQuery();

            while (resultat.next()) {
                int id = resultat.getInt("ID_INCIDENT");
                String name = resultat.getString("NAME_INCIDENT");

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


    @Override
    public boolean addIncidentToHero(String nameHero, int id_incident) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("SELECT ID_HERO FROM HEROS WHERE NAME = ? LIMIT 1");
            preparedstatement.setString(1, nameHero);

            resultat = preparedstatement.executeQuery();

            int id_hero = 0;

            while (resultat.next()) {
                id_hero = resultat.getInt("ID_HERO");

            }

            preparedstatement = connexion.prepareStatement("INSERT INTO association_hero_incident_list (ID_HERO, ID_INCIDENT_LIST) VALUES (?,?)");
            preparedstatement.setInt(1, id_hero);
            preparedstatement.setInt(2, id_incident);

            preparedstatement.executeUpdate();

            return true;


        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données 1 : " + e.getMessage());
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données 2 : " + e.getMessage());
            }
        }
    }

    @Override
    public boolean deleteIncidentToHero(String nameHero) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("DELETE FROM ASSOCIATION_HERO_INCIDENT_LIST WHERE ID_HERO IN (SELECT ID_HERO FROM HEROS WHERE NAME = ?)");
            preparedstatement.setString(1, nameHero);

            preparedstatement.executeUpdate();

            return true;


        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données 1 : " + e.getMessage());
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données 2 : " + e.getMessage());
            }
        }
    }
}