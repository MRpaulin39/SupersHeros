package com.supersheros.dao;

import com.supersheros.beans.Heros;

public interface RegisterDao {

    boolean AddHeros(Heros heros) throws DaoException;
}
