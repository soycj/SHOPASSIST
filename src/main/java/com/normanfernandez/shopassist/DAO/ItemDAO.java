package com.normanfernandez.shopassist.DAO;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.normanfernandez.shopassist.models.Item;
import java.util.List;

public class ItemDAO implements DAO<Item, String>
{

    private Session currentSession;
    private Transaction currentTransaction;
    
    public ItemDAO() {
    }

    private static SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = 
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        return factory;
    }
    
    public Session openCurrentSession()
    {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction()
    {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    public void closeCurrentSession()
    {
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction()
    {
        currentTransaction.commit();
        currentSession.close();
    }
    
    @Override
    public void persist(Item entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Item entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Item findById(String id) {
        Item i = (Item)getCurrentSession().get(Item.class, id);
        return i;
    }

    @Override
    public void delete(Item entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = (List<Item>) getCurrentSession()
                .createQuery("from items").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<Item> list = findAll();
        for(Item i : list)
            delete(i);
    }
    
}
