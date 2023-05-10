package graphicController;

import Classes.Liste;
import application.Main;
import controller.Controller.ListeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AjouterTache {

    @FXML
    private TextField description;

    @FXML
    private TextField nom;

    @FXML
    void Ajouter(ActionEvent event) {
        ListeController nvListe = new ListeController();
        Liste uneListe = new Liste(nom.getText(), description.getText());
        Main.change("Accueil_1",new Accueil_1(),"Accueil_1");

    }

    @FXML
    void est_realise(ActionEvent event) {


    }

}
