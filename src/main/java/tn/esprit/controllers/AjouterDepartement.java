package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import tn.esprit.models.Departement;
import tn.esprit.services.ServiceDepartement;

import java.io.IOException;

public class AjouterDepartement {
    ServiceDepartement sd  = new ServiceDepartement();

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfheadmaster_id;
    @FXML
    void affichierDepartement(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AffichierDepartement.fxml"));

        try {
            Parent root = loader.load();
            AffichierDepartement ad = loader.getController();

            ad.setLbDepartements(sd.getAll().toString());
            tfName.getScene().setRoot(root);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
    @FXML
    void ajouterDepartement(ActionEvent event) {

        Departement p = new Departement();

        p.setName(tfName.getText());
        p.setDescription(tfDescription.getText());
        p.setHeadmaster_id(Integer.parseInt(tfheadmaster_id.getText()));

        sd.add(p);

    }


}


