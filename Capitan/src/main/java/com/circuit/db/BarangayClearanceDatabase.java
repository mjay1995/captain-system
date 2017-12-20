/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import java.util.List;

/**
 *
 * @author Marvin
 */
public interface BarangayClearanceDatabase {
    
    public BarangayClearance getBarangayClearance(int id) throws ServiceException;
    
 
    public List<BarangayClearance> getAllBarangayClearanceInRange(int from, int to) throws ServiceException;
    
    public List<BarangayClearance> getAllBarangayClearance() throws ServiceException;
    
    public BarangayClearance saveClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public boolean removeClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public BarangayClearance generateBarangayReport(BarangayClearance barangayClearance) throws ServiceException;
    
    public BarangayReport generateAndSaveBarangayReport(BarangayClearance  barangayClearance) throws ServiceException;
    
     public BarangayReport generateAndSaveBarangayClearanceReportReciept(BarangayClearance barangayClearance) throws ServiceException;
    
}
