package graphicController;

import Classes.Tache;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ModifTache {



    @FXML
    private TextField description_tache_new;

    @FXML
    private CheckBox est_realise;

    @FXML
    private TextField nom_tache_new;

    @FXML
    private Button valider_new_tache;

    @FXML
    void est_realise(ActionEvent event) {

    }

    @FXML
    void valider_new_tache(ActionEvent event) {

        Tache uneTache = new Tache(nom_tache_new.getText(),nom_tache_new.getText(), est_realise.isSelected(), Accueil_1.getIdListeSelect(), 1); // ID TYPE A REMPLIR


    }

}
