package com.supersheros.dao;

import com.supersheros.beans.ListIncidents;

import java.util.List;

public interface IncidentDao {

    /**
     * @return Retourne la liste des incidents possible (ID + Nom)
     * @throws DaoException Capture les erreurs de base de données
     */
    List<ListIncidents> lister() throws DaoException;
}
