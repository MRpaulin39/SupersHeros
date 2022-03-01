package com.supersheros.dao;

import com.supersheros.beans.Heros;

public interface RegisterDao {

    /**
     * @param heros Modèle rempli du héro (Nom, Ville, téléphone)
     * @return Un booléan (True = OK, False = NOK)
     * @throws DaoException Exception de base de données
     */
    boolean AddHeros(Heros heros) throws DaoException;
}
