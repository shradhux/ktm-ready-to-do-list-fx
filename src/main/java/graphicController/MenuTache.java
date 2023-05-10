package graphicController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MenuTache {

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableColumn<?, ?> est_realise;

    @FXML
    private TableColumn<?, ?> id_tache;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> ref_liste;

    @FXML
    private TableColumn<?, ?> ref_type;

    @FXML
    private TableView<?> table;

    @FXML
    void AjouterTache(ActionEvent event) {
        Main.change("AjouterTache");
    }

    @FXML
    void ModifierTache(ActionEvent event) {
        Main.change("ModifierTache");
    }

    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void Selectionner(ActionEvent event) {

    }

    @FXML
    void SupprimerTache(ActionEvent event) {

    }

    @FXML
    void mouseClicked(MouseEvent event) {

    }

}
