package graphicController;

import Classes.Liste;
import Classes.Utilisateur;
import application.Main;
import controller.Controller.ListeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modele.bdd.Bdd;

public class Accueil_1 implements Initializable{

    private Utilisateur user;

    private static int idListeSelect;


    public  Accueil_1(Utilisateur user) throws SQLException {
        this.user = user;
    }
    public  Accueil_1(){
    }


        @FXML
        private Button Afficher;



        @FXML
        void Afficher(ActionEvent event) throws SQLException {
        Main.change("MenuTache");
        }


    public static int getIdListeSelect() {
        return idListeSelect;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.refresh();
        PreparedStatement extraireListes = null;
        try {
            extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet recupListes = null;
        try {
            recupListes = extraireListes.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true){
            try {
                if (!recupListes.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                data.add(new Liste(recupListes.getInt(1), recupListes.getString(2),recupListes.getString(3)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            extraireListes.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        id_liste.setCellValueFactory(new PropertyValueFactory<Liste,  Integer>("id_liste"));
        nom.setCellValueFactory(new PropertyValueFactory<Liste,  String>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<Liste, String>("description"));
        table.refresh();
        table.setItems(data);
        table.refresh();


    }
    @FXML
    void mouseClicked(MouseEvent event) {
        idListeSelect = table.getSelectionModel().getSelectedItem().getId_liste();

    }
   @FXML private TableView<Liste> table;
    @FXML private TableColumn<Liste, Integer> id_liste;
    @FXML private TableColumn<Liste, String> nom;
    @FXML private TableColumn<Liste, String> description;

    public ObservableList<Liste> data= FXCollections.observableArrayList();
    @FXML
    void AjouterListe(ActionEvent event) {
        Main.change("AjouterListe");
    }

    @FXML
    void AjouterTache(ActionEvent event) {
        Main.change("AjouterTache");

    }

    @FXML
    void ModifierListe(ActionEvent event) {
        Main.change("ModificationListe");

    }

    @FXML
    void ModifierTache(ActionEvent event) {
        Main.change("ModifTache");

    }

    @FXML
    void MonProfil(ActionEvent event) {


    }

    @FXML
    void SupprimerListe(ActionEvent event) throws SQLException {
        ListeController listeController = new ListeController();
        listeController.supprimerListe(getIdListeSelect());

    }

    @FXML
    void SupprimerTache(ActionEvent event) {


    }

    @FXML
    void deconnexion(ActionEvent event) {

    }


 }

