package graphicController;

import Classes.Liste;
import Classes.Utilisateur;
import application.Main;
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
import modele.bdd.Bdd;

public class Accueil_1 implements Initializable{

    private final Utilisateur user;

    public  Accueil_1(Utilisateur user) throws SQLException {
        this.user = user;
    }


        @FXML
        private Button Afficher;



        @FXML
        void Afficher(ActionEvent event) throws SQLException {

            PreparedStatement extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");
            ResultSet recupListes = extraireListes.executeQuery();
            while (recupListes.next()){
               data.add(new Liste(recupListes.getInt(1), recupListes.getString(2),recupListes.getString(3)));

            }
            extraireListes.close();

            id_liste.setCellValueFactory(new PropertyValueFactory<Liste,  Integer>("id_liste"));
            nom.setCellValueFactory(new PropertyValueFactory<Liste,  String>("nom"));
            description.setCellValueFactory(new PropertyValueFactory<Liste, String>("description"));
            table.setItems(data);







        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    void SupprimerListe(ActionEvent event) {
        Main.change("SupprimerListe");

    }

    @FXML
    void SupprimerTache(ActionEvent event) {
        Main.change("SupprimerTache");

    }

    @FXML
    void deconnexion(ActionEvent event) {

    }


 }

