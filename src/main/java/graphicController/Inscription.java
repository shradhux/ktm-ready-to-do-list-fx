package graphicController;

import application.Main;
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
    @FXML
    private TextField mdp;

    @FXML
    private Button valider;

    @FXML
    void valider(ActionEvent event) {
        if(UtilisateurController.inscription(new Utilisateur(nom.getText(),prenom.getText(),mail.getText(),mdp.getText()))){
            Main.change("Connection", new Connection(), "Hellooooo !!");
        }
        else {

        }
    }

}
