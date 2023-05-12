package graphicController;

import Classes.Utilisateur;
import application.Main;
import controller.Controller.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AdminAjouterInscrit {

    @FXML
    private CheckBox est_admin_checkbox;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_mdp;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    void Ajouter(ActionEvent event) {
        Utilisateur user = new Utilisateur(txt_nom.getText(), txt_prenom.getText(), txt_mail.getText(), txt_mdp.getText());

        UtilisateurController.inscription(user);

        Main.change("Accueil_1");

    }

}
