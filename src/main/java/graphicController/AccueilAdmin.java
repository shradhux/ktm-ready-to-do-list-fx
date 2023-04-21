package graphicController;
import application.Main;
import controller.utilisateurController.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modele.utilisateur.Utilisateur;
import javafx.collections.FXCollections;

public class AccueilAdmin {

    @FXML
    private TableColumn<Utilisateur, String> admin;

    @FXML
    private TableColumn<Utilisateur, Integer> id;

    @FXML
    private TableColumn<Utilisateur, String> mail;

    @FXML
    private TableColumn<Utilisateur, String> nom;

    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private Label usr;
    @FXML
    private TableView<Utilisateur> table;


    public void initialize(){
        this.id.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id"));
        this.nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        this.prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        this.mail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        this.admin.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("admin"));
        table.setItems(FXCollections.observableList(UtilisateurController.getUtilisateurList()));
    }
    @FXML
    void deco(ActionEvent event) {
        Main.change("Connection", new Connection(), "Hellooooo !!");
    }

    @FXML
    void inscription(ActionEvent event) {

    }

    @FXML
    void modif(MouseEvent event) {
        if (event.getClickCount()==2){
            Main.change("EditAccount", new EditAccount(table.getSelectionModel().getSelectedItem()), "go tout modifier ;) ");
        }
    }

}
