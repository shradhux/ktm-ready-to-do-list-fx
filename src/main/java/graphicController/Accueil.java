package graphicController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.utilisateur.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import modele.utilisateur.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.utilisateur.Utilisateur;
public class Accueil {



        private final Utilisateur user;

        public  Accueil(Utilisateur user){
            this.user = user;
        }



    @FXML
    private Button ajouter_liste;

    @FXML
    private Button ajouter_tache;

    @FXML
    private Button btn_profil;

    @FXML
    private TableColumn<?, ?> colonne1;

    @FXML
    private TableColumn<?, ?> colonne2;

    @FXML
    private TableColumn<?, ?> colonne3;

    @FXML
    private TableColumn<?, ?> colonne4;

    @FXML
    private TableColumn<?, ?> colonne5;

    @FXML
    private TableColumn<?, ?> colonne6;

    @FXML
    private Button consulter_liste;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Button modifier_liste;

    @FXML
    private Button modifier_tache;

    @FXML
    private Button modifier_type;

    @FXML
    private Button selectionner_liste;

    @FXML
    private Button supprimer_liste;

    @FXML
    private Button supprimer_tache;

    @FXML
    private Button valider_tache;

    @FXML
    void action_ajouter_liste(ActionEvent event) {

    }

    @FXML
    void action_ajouter_tache(ActionEvent event) {

    }

    @FXML
    void action_consulter_liste(ActionEvent event) {

    }

    @FXML
    void action_modifier_liste(ActionEvent event) {

    }

    @FXML
    void action_modifier_tache(ActionEvent event) {

    }

    @FXML
    void action_profil(ActionEvent event) {

    }

    @FXML
    void action_selectionner_liste(ActionEvent event) {

        this.label1.setText("Position : ");
        this.label2.setText("Nom : ");
        this.label3.setText("Description : ");

    }

    @FXML
    void action_supprimer_liste(ActionEvent event) {

    }

    @FXML
    void action_supprimer_tache(ActionEvent event) {

    }

    @FXML
    void action_supprimer_type(ActionEvent event) {

    }

    @FXML
    void action_valider_tache(ActionEvent event) {

    }

}
