package graphicController;

import Classes.Liste;
import Classes.Tache;
import application.Main;
import controller.Controller.ListeController;
import controller.Controller.TacheController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AjouterTache {

    @FXML
    private TextField description;

    @FXML
    private TextField nom;

    @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        TacheController nvTache = new TacheController();
        Tache uneTache = new Tache(description.getText(),nom.getText(), false, Accueil_1.getIdListeSelect(), 1); // ID TYPE A REMPLIR
        nvTache.ajouterTache(uneTache);

        Main.change("Accueil_1",new Accueil_1(),"Accueil_1");

    }



    @FXML
    void est_realise(ActionEvent event) {


    }

}
