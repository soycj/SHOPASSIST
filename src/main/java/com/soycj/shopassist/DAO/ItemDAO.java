package com.soycj.shopassist.DAO;

import javax.persistence.Persistence;
import com.soycj.shopassist.models.Items;


public class ItemDAO extends ItemsJpaController
{
        public ItemDAO()
        {
            super(Persistence.createEntityManagerFactory("com.soycj.shopassist_Persistence"));
        }

        public Items findByCode(String code)
        {
           return (Items)this.getEntityManager()
                   .createQuery("SELECT i FROM Items i WHERE i.code = :code")
                   .setParameter("code", code).getSingleResult();
        }
}

