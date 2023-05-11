package graphicController;

import Classes.Liste;
import Classes.Tache;
import application.Main;
import controller.Controller.ListeController;
import controller.Controller.TacheController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

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
    void valider_new_tache(ActionEvent event)  {



           Tache uneTache = new Tache(MenuTache.getIdTacheSelect(),description_tache_new.getText(),nom_tache_new.getText(),est_realise.isSelected(),Tache.getRef_liste(),Tache.getRef_liste());
           TacheController nvTache = new TacheController();
            nvTache.modifierTache(uneTache);

        Main.change("Accueil_1",new Accueil_1(),"az");


    }


}
