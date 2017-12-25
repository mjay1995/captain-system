/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.main;

import com.circuit.db.AdminAccountImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Marvin
 */
public class Main extends Application {
    
    AdminAccountImpl adminAccountImpl = new AdminAccountImpl();
    MainController  mainController = new MainController();
      Admin admin = new Admin();
    
    
    
    
    @FXML
    private AnchorPane loginPane;

    @FXML
    public JFXTextField usernameInput;

    @FXML
    private JFXTextField passwordInput;

    @FXML
    private JFXButton loginBtn;
    
 
    @FXML
    void loginAccount(ActionEvent event) throws IOException, ServiceException {
        
        
        if(adminAccountImpl.validateLogin(usernameInput.getText(),passwordInput.getText())  == true )
        {
                 
               AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
               admin.setCurrentUser(usernameInput.getText());
              loginPane.getChildren().setAll(pane);
        }
        else
        {
            System.out.println("Error");
        }
        
       

    }
    @Override
    public void start(Stage primaryStage) throws  IOException{
         primaryStage.setTitle("Capitan");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene myScene = new Scene(pane);        
            primaryStage.setScene(myScene);
            primaryStage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
