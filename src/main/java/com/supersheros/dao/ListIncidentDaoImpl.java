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
    public boolean deleteIncidentToHero() throws DaoException {
        return false;
    }
}
