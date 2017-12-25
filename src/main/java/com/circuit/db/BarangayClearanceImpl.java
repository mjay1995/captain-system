/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import Properties.BarangayClearanceProperties;
import com.circuit.exception.ServiceException;
import com.circuit.main.MainController;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import com.circuit.utils.ReportUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.util.Log;


/**
 *
 * @author Marvin
 */
public class BarangayClearanceImpl extends DatabaseSource implements BarangayClearanceDatabase {
    
 

    @Override
    public BarangayClearance getBarangayClearance(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BarangayClearance> getAllBarangayClearanceInRange(int from, int to) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BarangayClearance> getAllBarangayClearance() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BarangayClearance saveClearance(BarangayClearance barangayClearance) throws ServiceException {
        PreparedStatement ps;
      
        
        try
        {
            if(barangayClearance.getId() == 0)
            {
                String insertSql = ""
                        + "INSERT INTO "
                        + "bgy_clearance "
                        + " ("
                        + "surname, "
                        + "firstname, "
                        + "middlename,"
                        + "fullname, "
                        + "gender, "
                        + "birthdate, "
                        + "age, "
                        + "citizenship, "
                        + "address, "
                        + "barangay, "
                        + "city, "
                        + "remarks, "
                        + "paidamount, "
                        + "changeamount, "
                        + "regcost, "
                        + "regvat, "
                        + "control_no, "
                        + "current_date, "
                        + "profile_pic"
                        + ")"
                        + "VALUES "
                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                ps = this.getConnection().prepareStatement(insertSql);
                ps.setString(1, barangayClearance.getSurname());
                ps.setString(2, barangayClearance.getFirstName());
                ps.setString(3, barangayClearance.getMiddleName());
                ps.setString(4, barangayClearance.getFullname());
                ps.setString(5, barangayClearance.getGender());
                ps.setString(6, String.valueOf(barangayClearance.getBirthDate()));
                ps.setString(7, String.valueOf(barangayClearance.getAge()));
                ps.setString(8, barangayClearance.getCitizenship());
                ps.setString(9, barangayClearance.getAddress());
                ps.setString(10, barangayClearance.getBarangay());
                ps.setString(11, barangayClearance.getCity());
                ps.setString(12, barangayClearance.getRemarks());
                ps.setString(13,  String.valueOf(barangayClearance.getAmountPaid()));
                ps.setString(14,  String.valueOf(barangayClearance.getAmountChange()));
                ps.setString(15, String.valueOf(barangayClearance.getRegCost()));
                ps.setString(16,  String.valueOf(barangayClearance.getRegVat())); 
                ps.setString(17, String.valueOf(barangayClearance.getControl_no()));
                ps.setString(18, barangayClearance.getCurrent_date());
                ps.setBytes(19, barangayClearance.getProfileImage());
            }
            else
            {
                 String updateSQL = ""
                        + "UPDATE "
                        + "bgy_clearance "
                        + "SET "
                        + "surname = ?, "
                        + "firstname = ?, "
                        + "middlename = ?,"
                         + "fullname = ?, "
                        + "gender = ?, "
                        + "birthdate = ?, "
                        + "age = ?, "
                        + "citizenship = ?, "
                        + "address = ?, "
                        + "barangay = ?, "
                        + "city = ?, "
                        + "remarks = ?, "
                        + "paidamount = ?, "
                        + "changeamount = ?, "
                        + "regcost = ?, "
                        + "regvat = ?,"
                         + "control_no = ?,"
                         + "current_date = ?,"
                         + "profile_pic = ? "
                         + "WHERE "
                         + "id = ?";
 
                
                ps = this.getConnection().prepareStatement(updateSQL);
                ps.setString(1, barangayClearance.getSurname());
                ps.setString(2, barangayClearance.getFirstName());
                ps.setString(3, barangayClearance.getMiddleName());
                ps.setString(4, barangayClearance.getFullname());
                ps.setString(5, barangayClearance.getGender());
                ps.setString(6, String.valueOf(barangayClearance.getBirthDate()));
                ps.setString(7, String.valueOf(barangayClearance.getAge()));
                ps.setString(8, barangayClearance.getCitizenship());
                ps.setString(9, barangayClearance.getAddress());
                ps.setString(10, barangayClearance.getBarangay());
                ps.setString(11, barangayClearance.getCity());
                ps.setString(12, barangayClearance.getRemarks());
                ps.setString(13,  String.valueOf(barangayClearance.getAmountPaid()));
                ps.setString(14,  String.valueOf(barangayClearance.getAmountChange()));
                ps.setString(15, String.valueOf(barangayClearance.getRegCost()));
                ps.setString(16,  String.valueOf(barangayClearance.getRegVat())); 
                ps.setString(17, String.valueOf(barangayClearance.getControl_no()));
                ps.setString(18, barangayClearance.getCurrent_date());
                ps.setBytes(19, barangayClearance.getProfileImage());
            }
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BarangayClearanceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  barangayClearance;
    }

    @Override
    public boolean removeClearance(BarangayClearance barangayClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BarangayClearance generateBarangayReport(BarangayClearance barangayClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BarangayReport generateAndSaveBarangayReport(BarangayClearance barangayClearance) throws ServiceException {
       BarangayReport barangayClearanceReport = new BarangayReport();
        
       
        barangayClearanceReport.setBarangayClearance(barangayClearance);
        barangayClearanceReport.setBarangayClearancePrint(ReportUtility.generateJasperPrintReport(barangayClearance));
      
        return barangayClearanceReport;
    }

    @Override
    public BarangayReport generateAndSaveBarangayClearanceReportReciept(BarangayClearance barangayClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<BarangayClearanceProperties> loadTable() throws ServiceException {
        ObservableList<BarangayClearanceProperties> data = FXCollections.observableArrayList();
           
        try {
         SqlConnect connect = new SqlConnect();
       
        
                    String query = "SELECT * FROM bgy_clearance" ;
                  PreparedStatement pst= connect.getDataSource().getConnection().prepareStatement(query);
                ResultSet rs =  pst.executeQuery();
           
            
            while(rs.next())
            {
                data.add(new BarangayClearanceProperties(
                rs.getInt(1),
                rs.getString(5),
                rs.getString(10)
            
              
                ));
                        
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public JasperReport showReport(BarangayClearance barangayClearance) throws ServiceException {
        JasperViewer jv;
        jv = new JasperViewer(generateAndSaveBarangayReport(barangayClearance).getBarangayClearancePrint(),true);
                  jv.setExtendedState(JasperViewer.NORMAL);
                  jv.setDefaultCloseOperation(HIDE_ON_CLOSE);
                  jv.setVisible(true);
        return null;
    }

 
    
}
