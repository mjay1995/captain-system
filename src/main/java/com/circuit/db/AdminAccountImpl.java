/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import Properties.AdminProperties;
import Properties.BarangayClearanceProperties;
import com.circuit.exception.ServiceException;
import com.circuit.main.MainController;
import com.circuit.obj.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marvin
 */
public class AdminAccountImpl extends DatabaseSource implements AdminAcount {


    @Override
    public Admin addNewAccount(Admin admin) throws ServiceException {
        PreparedStatement preparedStatement;
        
        try
        {
            if(admin.getId() == 0)
            {
                String insertSql = ""
                        + "INSERT_INTO "
                        + "admin_acct "
                        + " ("
                        + "id_no, "
                        + "first_name, "
                        + "last_name, "
                        + "user_name, "
                        + "password, "
                        + "profilepic"
                        + ") "
                        + "VALUES "
                        + "(?,?,?,?,?,?)";
                
                preparedStatement = this.getConnection().prepareStatement(insertSql);
                preparedStatement.setInt(1, admin.getIdNo());
                preparedStatement.setString(2, admin.getFirstName());
                preparedStatement.setString(3, admin.getLastName());
                preparedStatement.setString(4, admin.getUsername());
                preparedStatement.setString(5, admin.getPassword());  
            }
             else
            {
               String updateSql = ""
                       + "UPDATE "
                       + "admin_acct "
                       + "SET "
                       + "id_no = ?,"
                       + "first_name = ?,"
                       + "last_name = ?,"
                       + "user_name = ?,"
                       + "password = ?"
                       + "WHERE "
                       + "id = ?";
               
                preparedStatement = this.getConnection().prepareStatement(updateSql);
                preparedStatement.setInt(1, admin.getIdNo());
                preparedStatement.setString(2, admin.getFirstName());
                preparedStatement.setString(3, admin.getLastName());
                preparedStatement.setString(4, admin.getUsername());
                preparedStatement.setString(5, admin.getPassword());  
            }
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Admin removeAccount(Admin admin) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<AdminProperties> loadTable() throws ServiceException {
       ObservableList<AdminProperties> data = FXCollections.observableArrayList();
           
        try {
         SqlConnect connect = new SqlConnect();
       
        
                    String query = "SELECT * FROM admin_acct" ;
                  PreparedStatement pst= connect.getDataSource().getConnection().prepareStatement(query);
                ResultSet rs =  pst.executeQuery();
           
            
            while(rs.next())
            {
                data.add(new AdminProperties(
                rs.getInt(2),
                rs.getString(3),
                rs.getString(7),
                rs.getString(8),
                rs.getBoolean(9)
            
              
                ));
                        
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean validateLogin(String username, String password) throws ServiceException {
         MainController  mainController = new MainController();
        Admin admin = new Admin();
        PreparedStatement preparedStatement;
         ResultSet resultSet;
        
        String validateQuery = "SELECT * FROM admin_acct WHERE user_name=? AND password=?";
        try
        {
            
            Statement st = this.getConnection().createStatement();
            preparedStatement = this.getConnection().prepareStatement(validateQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
           
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
               
                  
                    System.out.println("Welcome " + username);
                    return true; 
                
               
           }
            else
            {
                System.out.println("Mali tanga");
                return false;
            }
           
           
    }   catch (SQLException ex) {
            Logger.getLogger(AdminAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
          
    
}
}
