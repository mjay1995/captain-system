package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.BarangayClearanceImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.utils.WebcamCapture;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RegisterController implements Initializable {
    
    private BarangayClearance barangayClearance = new BarangayClearance();
    private BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    private final WebcamCapture webcamCapture = new WebcamCapture();
    
      private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @FXML
    private AnchorPane createNew;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXTextField firstNameField;

    @FXML
    private JFXTextField middleNameField;
    
      @FXML
    private JFXComboBox<String> genderType;
      
      @FXML
    private JFXDatePicker birthdate;

    @FXML
    private JFXTextField cityField;

    @FXML
    private JFXTextField remarksField;

    @FXML
    private JFXTextField ageField;

    @FXML
    private JFXTextField citizenshipField;

    @FXML
    private JFXTextField addressField;

    @FXML
    private JFXTextField barangayField;

   
    @FXML
    private JFXButton submitButton;

    @FXML
    private  JFXComboBox<String> registerType;
    
    
    @FXML
    private ImageView profilePicId;
    
      @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton imageCapture;
    
    @FXML
    private Pane webcamPane;

    
    private boolean image;
    
    private byte[] profileImage;
    
    
    
    @FXML
    void captureButton(ActionEvent event) throws IOException {
       Webcam webcam = Webcam.getDefault();
          
         
          webcam.setViewSize(WebcamResolution.VGA.getSize());
          webcam.open();
          
          BufferedImage bufferedImage = webcam.getImage();
          javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
          profilePicId.setImage(imageFx);
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "JPG", baos);
              byte [] res = baos.toByteArray();
            ByteArrayInputStream is=new ByteArrayInputStream(res);
            profilePicId.setImage(new Image(is));
            baos.close();
             Base64.encode(res);
          
          
          webcam.close();
    }
    
    

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          createNew.getChildren().setAll(pane);
        

    }

    @FXML
    void manageDataButton(ActionEvent event) {

    }
    
    @FXML
    void regTypePick(ActionEvent event) throws IOException {
        
        if(registerType.getSelectionModel().getSelectedItem() == "Barangay Clearance")
        {
             AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          createNew.getChildren().setAll(pane);
        }
        
    }
    
    
     @FXML
    void saveRecord(ActionEvent event) {

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          createNew.getChildren().setAll(pane);

    }

    @FXML
    void submitReg(ActionEvent event) throws ServiceException {
        
       barangayClearance.setId(getId());
       barangayClearance.setSurname(lastNameField.getText());
       barangayClearance.setFirstName(firstNameField.getText());
       barangayClearance.setMiddleName(middleNameField.getText());
       barangayClearance.setGender(genderType.getSelectionModel().getSelectedItem().toString());
       barangayClearance.setBirthDate(birthdate.getValue().toString());
       barangayClearance.setCity(cityField.getText());
       barangayClearance.setAddress(addressField.getText());
       barangayClearance.setAge(Integer.valueOf(ageField.getText()));
       barangayClearance.setRemarks(remarksField.getText());
       barangayClearance.setBarangay(barangayField.getText());
       
       barangayClearanceImpl.saveClearance(barangayClearance);
        System.out.println("Saved!");
       
    }

    @FXML
    void viewRecords(ActionEvent event) {

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    registerType.getItems().addAll("Barangay Clearance","Business Clearance","Bail Clearance","Pedicab Clearance");
    registerType.getSelectionModel().select("Barangay Clearance");
    
    genderType.getItems().addAll("Male","Female");
    genderType.getSelectionModel().select("Male");
    }    
    
}
