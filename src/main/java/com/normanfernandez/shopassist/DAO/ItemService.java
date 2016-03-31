package com.normanfernandez.shopassist.DAO;

import com.normanfernandez.shopassist.models.Item;
import java.io.Serializable;
import java.util.List;

public class ItemService
{
    private static ItemDAO itemDAO;
    
    public ItemService()
    {
        itemDAO = new ItemDAO();
    }

    public void persist(Item entity) {
        itemDAO.openCurrentSessionWithTransaction();
        itemDAO.persist(entity);
        itemDAO.closeCurrentSessionWithTransaction();
    }

    public void update(Item entity) {
        itemDAO.openCurrentSessionWithTransaction();
        itemDAO.update(entity);
        itemDAO.closeCurrentSessionWithTransaction();
    }

    public Object findById(String id) {
        itemDAO.openCurrentSession();
        Item item = itemDAO.findById(id);
        itemDAO.closeCurrentSession();
        return item;
    }

    public void delete(Item entity) {
        itemDAO.openCurrentSessionWithTransaction();
        itemDAO.delete(entity);
        itemDAO.closeCurrentSessionWithTransaction();
    }

    public List<Item> findAll() {
        itemDAO.openCurrentSession();
        List<Item> list = itemDAO.findAll();
        itemDAO.closeCurrentSession();
        return list;
    }

    public void deleteAll() {
        itemDAO.openCurrentSessionWithTransaction();
        itemDAO.deleteAll();
        itemDAO.closeCurrentSessionWithTransaction();
    }
   
}
