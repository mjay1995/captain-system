/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author Marvin
 */
public class DatabaseSource {
    
    public DataSource dataSource = new SqlConnect().getDataSource();

 
    @Autowired
    public void setDataSource(DataSource dataSource) throws SQLException{
        this.dataSource = dataSource;
    }
    
    public Connection getConnection() throws SQLException
    {
        return this.dataSource.getConnection();
    }
    
    
    
    
}
