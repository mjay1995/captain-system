/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                        + "middlename, "
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
                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                ps = this.getConnection().prepareStatement(insertSql);
                ps.setString(1, barangayClearance.getSurname());
                ps.setString(2, barangayClearance.getFirstName());
                ps.setString(3, barangayClearance.getMiddleName());
                ps.setString(4, barangayClearance.getGender());
                ps.setString(5, String.valueOf(barangayClearance.getBirthDate()));
                ps.setString(6, String.valueOf(barangayClearance.getAge()));
                ps.setString(7, barangayClearance.getCitizenship());
                ps.setString(8, barangayClearance.getAddress());
                ps.setString(9, barangayClearance.getBarangay());
                ps.setString(10, barangayClearance.getCity());
                ps.setString(11, barangayClearance.getRemarks());
                ps.setString(12,  String.valueOf(barangayClearance.getAmountPaid()));
                ps.setString(13,  String.valueOf(barangayClearance.getAmountChange()));
                ps.setString(14, String.valueOf(barangayClearance.getRegCost()));
                ps.setString(15,  String.valueOf(barangayClearance.getRegVat())); 
                ps.setString(16, barangayClearance.getControl_no());
                ps.setString(17, barangayClearance.getCurrent_date());
                ps.setBytes(18, barangayClearance.getProfileImage());
            }
            else
            {
                 String updateSQL = ""
                        + "UPDATE "
                        + "bgy_clearance "
                        + "SET "
                        + "surname = ?, "
                        + "firstname = ?, "
                        + "middlename = ?, "
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
                        + "regva = ? "
                         + "WHERE "
                         + "id = ?";
 
                
                ps = this.getConnection().prepareStatement(updateSQL);
                ps.setString(1, barangayClearance.getSurname());
                ps.setString(2, barangayClearance.getFirstName());
                ps.setString(3, barangayClearance.getMiddleName());
                ps.setString(4, barangayClearance.getGender());
                ps.setString(5, String.valueOf(barangayClearance.getBirthDate()));
                ps.setString(6, String.valueOf(barangayClearance.getAge()));
                ps.setString(7, barangayClearance.getCitizenship());
                ps.setString(8, barangayClearance.getAddress());
                ps.setString(9, barangayClearance.getBarangay());
                ps.setString(10, barangayClearance.getCity());
                ps.setString(11, barangayClearance.getRemarks());
                ps.setString(12,  String.valueOf(barangayClearance.getAmountPaid()));
                ps.setString(13,  String.valueOf(barangayClearance.getAmountChange()));
                ps.setString(14, String.valueOf(barangayClearance.getRegCost()));
                ps.setString(15,  String.valueOf(barangayClearance.getRegVat()));         
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BarangayReport generateAndSaveBarangayClearanceReportReciept(BarangayClearance barangayClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
