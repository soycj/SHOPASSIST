/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.normanfernandez.shopassist.shopassist;
import com.normanfernandez.shopassist.views.SalesForm;
import com.normanfernandez.shopassist.DAO.*;
import com.normanfernandez.shopassist.models.Item;
import com.normanfernandez.shopassist.Database.DatabaseConnectionData;
import java.util.List;

public class Main 
{
    public static void main(String [] args)
    {
        DatabaseConnectionData.address = "10.0.0.9";
        DatabaseConnectionData.user = "root";
        DatabaseConnectionData.password = "pony";
        
        SalesForm form = new SalesForm();
        form.setVisible(true);
        form.setDefaultCloseOperation(3);
    }
}
