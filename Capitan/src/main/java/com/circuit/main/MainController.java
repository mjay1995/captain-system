package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class MainController implements Initializable {

    
    @FXML
    private Button helloButton;
    
      @FXML
    private Label actionLabel;

    @FXML
    void helloButtonAction(ActionEvent event) {
        
        System.out.println("Its Working!");
        actionLabel.setText("ITS WORKING FAM");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
