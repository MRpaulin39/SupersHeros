package com.supersheros.dao;

import com.supersheros.beans.Heros;
import org.springframework.security.crypto.bcrypt.BCrypt;

public interface LoginDao {


    /**
     * @return Retourne TRUE si authentification réussit
     * @throws DaoException
     */
    boolean checkAuthentification(Heros heros) throws DaoException;
}
