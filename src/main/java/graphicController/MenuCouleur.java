package graphicController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuCouleur {

    private String code_couleur;

    @FXML
    private Button IDJAUNE;

    @FXML
    private Button IDORANGE;

    @FXML
    private Button IDROUGE;

    @FXML
    private Button IDVERT;

    @FXML
    String JAUNE(ActionEvent event) {
        code_couleur = "JAUNE";
        Main.change("MenuType");
    }

    @FXML
    void ORANGE(ActionEvent event) {
        code_couleur = "ORANGE";
        Main.change("MenuType");
    }

    @FXML
    void ROUGE(ActionEvent event) {
        code_couleur = "ROUGE";
        Main.change("MenuType");
    }

    @FXML
    void VERT(ActionEvent event) {
        code_couleur = "VERT";
        Main.change("MenuType");
    }

}
