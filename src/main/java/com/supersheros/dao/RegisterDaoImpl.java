package com.supersheros.dao;

import com.supersheros.beans.Heros;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterDaoImpl implements RegisterDao{
    private final DaoFactory daoFactory;

    RegisterDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean AddHeros(Heros heros) throws DaoException {
        String nameHero = heros.getName();
        String phoneHero = heros.getPhone();
        String cityHero = heros.getCity();
        float cityHeroLat = heros.getCityLat();
        float cityHeroLong = heros.getCityLong();
        String passwordHero = heros.getPassword();
        String passwordCheckHero = heros.getPasswordCheck();

        Connection connexion = null;
        PreparedStatement preparedstatement = null;

        try {
            if (!Objects.equals(passwordHero, passwordCheckHero)){
                throw new DaoException("Les mots de passe de correspondent pas !");
            }

            connexion = daoFactory.getConnection();
            preparedstatement = connexion.prepareStatement("INSERT INTO heros (NAME, PASSWORD, CITY, CITY_LAT, CITY_LONG, PHONE) VALUES (?,?,?,?,?,?)");
            preparedstatement.setString(1, nameHero);
            preparedstatement.setString(2, BCrypt.hashpw(passwordHero, BCrypt.gensalt(10)));
            preparedstatement.setString(3, cityHero);
            preparedstatement.setFloat(4, cityHeroLat);
            preparedstatement.setFloat(5, cityHeroLong);
            preparedstatement.setString(6, phoneHero);


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
