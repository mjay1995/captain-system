package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Properties.BarangayClearanceProperties;
import com.circuit.db.BarangayClearanceImpl;
import com.circuit.db.DatabaseSource;
import com.circuit.db.SqlConnect;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import com.circuit.obj.BarangayClearance;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class MainController implements Initializable {
    
    BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    Admin admin = new Admin();
   
    
    
    
    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

  @FXML
    private TableView<BarangayClearanceProperties> brgyDataTable;

    @FXML
    private TableColumn<BarangayClearanceProperties, Integer> idCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> fullNameCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> dateRegCol;
   


    private ObservableList<BarangayClearanceProperties> data;

    
    @FXML
    public Label timeLabel;
    
      @FXML
    public Label currentAdmin;
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          rootPane.getChildren().setAll(pane);

    }

   

    @FXML
    void manageDataButton(ActionEvent event) {

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          rootPane.getChildren().setAll(pane);
           
    }

    @FXML
    void viewRecords(ActionEvent event)throws IOException {

          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          rootPane.getChildren().setAll(pane);

    }

    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

       
        currentAdmin.setText(admin.getCurrentUser());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        dateRegCol.setCellValueFactory(new PropertyValueFactory<>("current_date"));
             
        try {
            brgyDataTable.setItems(barangayClearanceImpl.loadTable());
        } catch (ServiceException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
            
            
    
    }    
    
}
