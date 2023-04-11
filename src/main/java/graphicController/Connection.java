package graphicController;

import application.Main;
import controller.utilisateurController.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;
import modele.utilisateur.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

    @FXML
    private Button connectbutton;

    @FXML
    private TextField login;

    @FXML
    private TextField mdp;

    @FXML
    private Button oubli;

    @FXML
    private Label welcomeText;

    @FXML
    void connection(ActionEvent event) {
        try {
            Utilisateur user = new UtilisateurController().Connect(login.getText(), mdp.getText());
            if (user == null){
                this.oubli.setVisible(true);
            }
            else {
                Main.change("Accueil", new Accueil(user), "vous etes connecté, bravooooo!!!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void inscription(ActionEvent event) { Main.change("Inscription", new Inscription(), "Inscrit toi ;) "); }

    @FXML
    void oubli(ActionEvent event) {
        Main.change("Oubli", new Oubli(), "ah, C balo  :(  !!!");
    }

}