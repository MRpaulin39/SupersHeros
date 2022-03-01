package com.supersheros.dao;

import com.supersheros.beans.Heros;
import com.supersheros.beans.Incidents;
import com.supersheros.beans.ListIncidents;

import java.util.List;

public interface ListIncidentDao {

    /**
     * @return La liste de tous les incidents possibles
     * @throws DaoException Exception de base de données
     */
    List<ListIncidents> lister() throws DaoException;

    /**
     * @param NameHero Nom du héro
     * @return La liste des incidents que peux gérer un héro
     * @throws DaoException Exception de base de données
     */
    List<ListIncidents> listerIncidentOfHero(String NameHero) throws DaoException;

    /**
     * @param nameHero Nom du héro
     * @param id_incident ID de l'incident à ajouter
     * @return Un booléan (True = OK, False =NOK)
     * @throws DaoException Exception de base de données
     */
    boolean addIncidentToHero(String nameHero, int id_incident) throws DaoException;

    /**
     * @param nameHero Nom du héro
     * @return Un booléan (True = OK, False = NOK)
     * @throws DaoException Exception de base de données
     */
    boolean deleteIncidentToHero(String nameHero) throws DaoException;
}
