package graphicController;

import application.Main;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import modele.utilisateur.Utilisateur;

public class Accueil {

    @FXML
    private Label nom;

    private final Utilisateur user;

    public  Accueil(Utilisateur user){
        this.user = user;
    }

    public void initialize(){
        nom.setText(this.user.getPrenom());
    }

    @FXML
    void deconnect(ActionEvent event) {
        Main.change("Connection", new Connection(), "Hellooooo !!");
    }

}
