package graphicController;

import Classes.Liste;
import controller.Controller.ListeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AjouterListe {

    @FXML
    private TextField description;

    @FXML
    private TextField nom;

    @FXML
    void Ajouter(ActionEvent event) {

        ListeController nvListe = new ListeController();
        Liste uneListe = new Liste(nom.getText(), description.getText());
        nvListe.ajouterListe();

    }

}
