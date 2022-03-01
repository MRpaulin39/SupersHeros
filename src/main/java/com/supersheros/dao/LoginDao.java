package com.supersheros.dao;

import com.supersheros.beans.Heros;
import org.springframework.security.crypto.bcrypt.BCrypt;

public interface LoginDao {


    /**
     * @return Boolean (True = OK, False = NOK)
     * @throws DaoException Exception de base de données
     */
    boolean checkAuthentification(Heros heros) throws DaoException;
}
