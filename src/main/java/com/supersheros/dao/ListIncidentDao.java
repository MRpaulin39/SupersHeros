package com.supersheros.dao;

import com.supersheros.beans.ListIncidents;

import java.util.List;

public interface ListIncidentDao {

    /**
     * @return Retourne la liste des incidents possible (ID + Nom)
     */
    List<ListIncidents> lister() throws DaoException;
}
