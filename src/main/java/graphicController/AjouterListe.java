package graphicController;

import Classes.Liste;
import application.Main;
import controller.Controller.ListeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AjouterListe {

    @FXML
    private TextField description;

    @FXML
    private TextField nom;

    @FXML
    void Ajouter(ActionEvent event) throws SQLException {

        ListeController nvListe = new ListeController();
        Liste uneListe = new Liste(nom.getText(), description.getText());
        nvListe.ajouterListe(uneListe);
        Main.change("Accueil_1",new Accueil_1(),"accueil");

    }

}
