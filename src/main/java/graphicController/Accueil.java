package graphicController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.utilisateur.Utilisateur;

public class Accueil {

    @FXML
    private Label nom;

    private final Utilisateur user;

    public  Accueil(Utilisateur user){
        this.user = user;
    }

    public void inisilize(){
        nom.setText(this.user.getPrenom());
    }
}
