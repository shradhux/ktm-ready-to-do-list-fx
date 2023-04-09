package application;

import controller.utilisateurController.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.utilisateur.Utilisateur;

public class Inscription {

    @FXML
    private TextField mail;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;
    private TextField mdp;

    @FXML
    private Button valider;

    @FXML
    void valid(ActionEvent event) {
        Utilisateur user = new UtilisateurController().inscription(nom.getText(),prenom.getText(),mail.getText(),mdp.getText());

    }

}
