package com.normanfernandez.shopassist.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>
{
    public void add(T entity) throws SQLException;
    public void update(T entity)throws SQLException;
    public T findByCode(String code)throws SQLException;
    public void delete(T entity)throws SQLException;
    public List<T> findAll() throws SQLException;
    public void deleteAll()throws SQLException;

}
