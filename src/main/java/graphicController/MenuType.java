package graphicController;

import Classes.Liste;
import Classes.Type;
import application.Main;
import controller.Controller.ListeController;
import controller.Controller.TacheController;
import controller.Controller.TypeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuType implements Initializable {

    @FXML
    private TableColumn<Type, String> code_couleur;

    @FXML
    private TableColumn<Type, Integer> id_type;

    @FXML
    private TableColumn<Type, String> libelle;
    @FXML
    private TableView<Type> table1;
    private static int idTypeSelect;


        public void initialize (URL url, ResourceBundle resourceBundle){
            try {


                PreparedStatement extraireType = null;
                try {
                    extraireType = new Bdd().getBdd().prepareStatement("SELECT * FROM Type");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ResultSet recupType = null;
                try {
                    recupType = extraireType.executeQuery();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                while (true) {
                    try {
                        if (!recupType.next()) break;
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        data1.add(new Type(recupType.getInt(1), recupType.getString(2), recupType.getString(3)));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }
                try {
                    extraireType.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                id_type.setCellValueFactory(new PropertyValueFactory<Type, Integer>("id_type"));
                libelle.setCellValueFactory(new PropertyValueFactory<Type, String>("libelle"));
                code_couleur.setCellValueFactory(new PropertyValueFactory<Type, String>("code_couleur"));
                table1.setItems(data1);

            }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public ObservableList<Type> data1= FXCollections.observableArrayList();
    @FXML
    void AjouterType(ActionEvent event) {
        Main.change("AjouterType");

    }

    @FXML
    void ModifierType(ActionEvent event) {
        Main.change("ModifType");
    }

    @FXML
    void Retour(ActionEvent event) {
        Main.change("MenuTache");

    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {
        TypeController.supprimerType(this.table1.getSelectionModel().getSelectedItem().getId_type());
        this.table1.getSelectionModel().getSelectedItems().remove(this.table1.getSelectionModel().getSelectedItem());
        this.table1.refresh();


    }
}
