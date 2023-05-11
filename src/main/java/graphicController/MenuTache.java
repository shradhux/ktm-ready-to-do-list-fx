package graphicController;

import Classes.Tache;
import Classes.Type;
import application.Main;
import controller.Controller.TacheController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modele.bdd.Bdd;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MenuTache implements Initializable {


    @FXML
    private Button btn_gerer_type;


    @FXML
    private TableColumn<Tache, String> description;

    @FXML
    private TableColumn<Tache, Boolean> est_realise;

    @FXML
    private TableColumn<Tache, Integer> id_tache;

    @FXML
    private TableColumn<Tache, String> nom;

    @FXML
    private TableColumn<Tache, Integer> ref_liste;

    @FXML
    private TableColumn<Tache, Integer> ref_type;

    @FXML
    private TableView<Tache> table;
    public ObservableList<Tache> data= FXCollections.observableArrayList();




    public void initialize (URL url, ResourceBundle resourceBundle){
        try {


            PreparedStatement extraireTache = null;
            try {
                extraireTache = new Bdd().getBdd().prepareStatement("SELECT * FROM Tache");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ResultSet recupTache = null;
            try {
                recupTache = extraireTache.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    if (!recupTache.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    data.add(new Tache(recupTache.getInt(1),recupTache.getString(2),recupTache.getString(3),recupTache.getBoolean(4),recupTache.getInt(5),recupTache.getInt(6)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            try {
                extraireTache.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            id_tache.setCellValueFactory(new PropertyValueFactory<Tache, Integer>("id_tache"));
            description.setCellValueFactory(new PropertyValueFactory<Tache, String>("description"));
            nom.setCellValueFactory(new PropertyValueFactory<Tache, String>("nom"));
            est_realise.setCellValueFactory(new PropertyValueFactory<Tache, Boolean>("est_realise"));
            ref_type.setCellValueFactory(new PropertyValueFactory<Tache, Integer>("ref_type"));
            ref_liste.setCellValueFactory(new PropertyValueFactory<Tache, Integer>("ref_liste"));


            table.setItems(data);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    @FXML void AjouterTache(ActionEvent event) {
        Main.change("AjouterTache");
    }
    @FXML void ModifierTache(ActionEvent event) {
        Main.change("ModifierTache");
    }
    @FXML void Retour(ActionEvent event) {
    Main.change("Accueil_1");
    }
    @FXML void SupprimerTache(ActionEvent event) {
        TacheController.supprimerTache(this.table.getSelectionModel().getSelectedItem().getId_tache());
        this.table.getSelectionModel().getSelectedItems().remove(this.table.getSelectionModel().getSelectedItem());
        this.table.refresh();
    }
    @FXML void mouseClicked(MouseEvent event) {

    }
    @FXML void action_btn_gerer_type(ActionEvent event) {
        Main.change("MenuType");
    }
    public static int getIdTacheSelect() {return getIdTacheSelect();}


}
