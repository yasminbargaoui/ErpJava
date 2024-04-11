package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AffichierDepartement implements Initializable {
    @FXML
    private Label lbDepartements;

    public void setLbDepartements(String lbDepartements) {
        this.lbDepartements.setText(lbDepartements);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

