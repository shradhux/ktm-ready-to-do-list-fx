package graphicController;

import Classes.Liste;
import application.Main;
import controller.Controller.ListeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificationListe {



    @FXML
    private TextField modif_description;

    @FXML
    private TextField modif_nom;

    @FXML
    private Button valider;


    @FXML
    void valider_modif(ActionEvent event) throws SQLException {

        Liste uneListe = new Liste(Accueil_1.getIdListeSelect(),modif_nom.getText(),modif_description.getText());
        ListeController nvListe = new ListeController();
        nvListe.modifierListe(uneListe);
        Main.change("Accueil_1",new Accueil_1(),"az");






    }

}