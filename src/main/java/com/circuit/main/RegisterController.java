package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.BarangayClearanceImpl;
import com.circuit.db.DatabaseSource;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.service.ClearanceService;
import com.circuit.service.impl.ClearanceServiceImpl;
import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import net.sf.jasperreports.view.JasperViewer;
import sun.misc.BASE64Encoder;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RegisterController extends DatabaseSource implements Initializable {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private BarangayClearance barangayClearance = new BarangayClearance();
    private BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    
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
    
     @FXML
    private Label currentYear;

    @FXML
    private Label control_no;
    
        @FXML
    private Label date_label;
    
    @FXML
    private JFXButton startCam;

    
    private boolean image;
    
    private File file;
    
    private  ByteArrayOutputStream bos = new ByteArrayOutputStream();
     private ClearanceService clearanceService = new ClearanceServiceImpl();
    

    
    
    @FXML
    void captureButton(ActionEvent event) throws IOException {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
          BufferedImage bufferedImage = webcam.getImage();
         javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageIO.write( bufferedImage, "PNG", new File(firstNameField.getText() + ".png"));
        profilePicId.setImage(imageFx);
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
    void saveRecord(ActionEvent event) throws ServiceException {
          Webcam webcam = Webcam.getDefault();
          String imageString = null;
          
       
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);        
          
       
               
        
       barangayClearance.setId(getId());
       barangayClearance.setSurname(lastNameField.getText());
       barangayClearance.setFirstName(firstNameField.getText());
       barangayClearance.setMiddleName(middleNameField.getText());
       barangayClearance.setFullname(firstNameField.getText() + " " +  middleNameField.getText() + " " +lastNameField.getText());
       barangayClearance.setGender(genderType.getSelectionModel().getSelectedItem().toString());
       barangayClearance.setBirthDate(birthdate.getValue().toString());
       barangayClearance.setCity(cityField.getText());
       barangayClearance.setAddress(addressField.getText());
       barangayClearance.setAge(ageField.getText());
       barangayClearance.setRemarks(remarksField.getText());
       barangayClearance.setBarangay("Baclaran"); 
       barangayClearance.setCurrent_date(dateFormat.format(date));
       barangayClearance.setControl_no(control_no_format);
       webcam.open();
          BufferedImage bufferedImage = webcam.getImage();
         javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
        try {
            ImageIO.write(bufferedImage, "JPG", bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profilePicId.setImage(imageFx);
        webcam.close();
      file = new File(bufferedImage.toString());
      barangayClearance.setProfileImage(imageString.getBytes());
      
         
       
       barangayClearanceImpl.saveClearance(barangayClearance);
       barangayClearanceImpl.showReport(barangayClearance);
            
        System.out.println("Saved!");

    }
    
     
       
    
    @FXML
    void openHome(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          createNew.getChildren().setAll(pane);

    }

    @FXML
    void submitReg(ActionEvent event) throws ServiceException, IOException {
       
       
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

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);
            date_label.setText(dateFormat.format(date));
            control_no.setText(control_no_format);
           
           
            
     
            if(barangayClearance.getId() != 0)
            {
             
            try {
                 String query = "SELECT * FROM bgy_clearance";
                Statement st = this.getConnection().createStatement();
                ResultSet  rs= st.executeQuery(query);
                while(rs.next())
                {
                    int ctrlNo = rs.getInt("control_no");
                    System.out.println(ctrlNo);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
 }
             
    }    
    

