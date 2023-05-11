package graphicController;

import Classes.Utilisateur;
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

public class MenuGestionInscrit implements Initializable {

    private int idUtilisateurChoisi;

    @FXML
    private Button Admin;
    @FXML
    private TableColumn<Utilisateur, Boolean> est_admin;

    @FXML
    private TableColumn<Utilisateur, Integer> id_utilisateur;

    @FXML
    private TableColumn<Utilisateur, String> mail;

    @FXML
    private TableColumn<Utilisateur, String> mdp;

    @FXML
    private TableColumn<Utilisateur, String> nom;

    @FXML
    private TableColumn<Utilisateur, String> prenom;

    @FXML
    private TableView<Utilisateur> table;

    public ObservableList<Utilisateur> data = FXCollections.observableArrayList();

    @FXML
    void AjouterInscrit(ActionEvent event) {

    }

    @FXML
    void ModifierInscrit(ActionEvent event) {

    }

    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void SupprimerInscrit(ActionEvent event) {

    }

    @FXML
    void mouseClicked(MouseEvent event) {

    }

    public int getIdUtilisateurChoisi() {
        return idUtilisateurChoisi;
    }

    public void initialize (URL url, ResourceBundle resourceBundle){



        try {


            PreparedStatement extraireTache = null;
            try {
                extraireTache = new Bdd().getBdd().prepareStatement("SELECT * FROM Utilisateur");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ResultSet recupUser = null;
            try {
                recupUser = extraireTache.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    if (!recupUser.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    data.add(new Utilisateur(recupUser.getInt(1),recupUser.getString(2),recupUser.getString(3),recupUser.getString(4),recupUser.getString(5),recupUser.getBoolean(6)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            try {
                extraireTache.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            id_utilisateur.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id_utilisateur"));
            nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
            mail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
            mdp.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("mdp"));
            est_admin.setCellValueFactory(new PropertyValueFactory<Utilisateur, Boolean>("est_admin"));


            table.setItems(data);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }





}

