package com.normanfernandez.shopassist.DAO;

import com.mysql.jdbc.ResultSet;
import com.normanfernandez.shopassist.models.Item;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO extends AbstractDAO<Item>
{
        protected final String selectAllQuery = 
			"SELECT * FROM `items`;"
			;
	
	protected final String selectByCode=
			"SELECT * FROM shopassist.items WHERE `code` = '%s';"
			;
	
	protected final String insertQuery = 
			"INSERT INTO `items`("
			+ "`name`,"
			+ "`code`,"
			+ "`description`,"
			+ "`position`,"
			+ "`unit_price`,"
                        + "`tax_rate`)"
			+ "VALUES('%s', '%s', '%s', '%s', '%f', '%f');"
			;
	
	protected final String selectWhere = 
			"SELECT * FROM `taxis`"
			+ "WHERE `idtaxis` = %d;"
			;
        
        public ItemDAO() throws SQLException {
		super();
	}
        
    @Override
    public void add(Item entity) throws SQLException{
        this.statement.executeUpdate(
				String.format(insertQuery,
					entity.getName(),
					entity.getCode(),
					entity.getDescription(),
					entity.getPosition(),
                                        entity.getUnitPrice(),
                                        entity.getTaxRate()));
    }

    @Override
    public void update(Item entity) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item findByCode(String code) throws SQLException{
        this.resultSet = (ResultSet) statement.executeQuery(
				String.format(selectByCode, code));
        Item i = null;
        if(this.resultSet.next()){
            i = new Item(this.resultSet.getString("code"), this.resultSet.getString("name"));			i.setDescription(this.resultSet.getString("description"));
            i.setPosition(this.resultSet.getString("position"));
            i.setId(this.resultSet.getInt("id"));
            i.setTaxRate(this.resultSet.getDouble("tax_rate"));
            i.setUnitPrice(this.resultSet.getDouble("unit_price"));
        }
        return i;
    }

    @Override
    public void delete(Item entity) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> findAll()  throws SQLException {
        List<Item> result = new ArrayList<Item>();
		this.resultSet = (ResultSet) statement.executeQuery(selectAllQuery);
		while(this.resultSet.next()){
			Item i = new Item(this.resultSet.getString("code"), this.resultSet.getString("name"));
			i.setDescription(this.resultSet.getString("description"));
			i.setPosition(this.resultSet.getString("position"));
			i.setId(this.resultSet.getInt("id"));
			i.setTaxRate(this.resultSet.getDouble("tax_rate"));
			i.setUnitPrice(this.resultSet.getDouble("unit_price"));
			result.add(i);
		}
		
		return result;
    }

    @Override
    public void deleteAll() throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

