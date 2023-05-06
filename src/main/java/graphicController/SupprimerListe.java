package graphicController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SupprimerListe {

    @FXML
    private TextField nom;

    @FXML
    void supprimer(ActionEvent event) {

        CarnetDeListe carnetDeListe = new CarnetDeListe();
        carnetDeListe.supprimerListe(nom.getText());

    }

}
