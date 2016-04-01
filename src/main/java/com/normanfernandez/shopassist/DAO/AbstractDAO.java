package com.normanfernandez.shopassist.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.ResultSet;
import com.normanfernandez.shopassist.Database.DatabaseConnectionData;

public abstract class AbstractDAO<T> implements DAO<T>{
	protected final String connectionString = 
			"jdbc:mysql://" + DatabaseConnectionData.address + "/shopassist";
	protected final String user = DatabaseConnectionData.user;
	protected final String password = DatabaseConnectionData.password;
	protected String selectAllQuery;
	
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	
	public AbstractDAO() throws SQLException {
		
		try
		{
		   Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e)
		{
		   System.out.println("jdbc driver not available!");;
		}

		this.connection = (Connection) DriverManager.getConnection(
				this.connectionString,
				this.user,
				this.password
			);
		this.statement = (Statement) this.connection.createStatement();

	}
}