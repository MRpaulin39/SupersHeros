package com.supersheros.dao;

import com.supersheros.beans.Heros;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.*;
import java.util.Objects;

public class LoginDaoImpl implements LoginDao{
    private DaoFactory daoFactory;

    LoginDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean checkAuthentification(Heros heros) throws DaoException {
        String nameHero = heros.getName();
        String passwordHero = heros.getPassword();

        Connection connexion = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("SELECT NAME, PASSWORD FROM heros WHERE NAME = ? LIMIT 1;");
            preparedstatement.setString(1, nameHero);

            resultat = preparedstatement.executeQuery();
            String passwordUserInBDD = "";

            while (resultat.next()){
                passwordUserInBDD = resultat.getString("PASSWORD");
            }

            //Vérification qu'on a bien récupérer une valeur
            if (Objects.equals(passwordUserInBDD, "")){
                throw new DaoException("Utilisateur inconnu de la base de données");
            }

            return BCrypt.checkpw(passwordHero, passwordUserInBDD);

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
