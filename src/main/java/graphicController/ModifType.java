package graphicController;

import Classes.Liste;
import Classes.Type;
import application.Main;
import controller.Controller.ListeController;
import controller.Controller.TypeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ModifType {

    @FXML
    private TextField code_couleur;

    @FXML
    private TextField libelle;

    @FXML
    void valider(ActionEvent event) throws SQLException {
       Type unType = new Type(MenuType.getIdTypeSelect(),code_couleur.getText(),libelle.getText());
       TypeController nvType = new TypeController();
       nvType.modifierType(unType);
        Main.change("Accueil_1",new Accueil_1(),"az");


    }


}
