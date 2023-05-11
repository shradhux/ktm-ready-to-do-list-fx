package graphicController;
import Classes.Utilisateur;
import controller.Controller.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static controller.Controller.UtilisateurController.modifInscrit;

public class ModifInscrit {

    @FXML
    private Button btn_valider;

    @FXML
    private TextField text_nv_nom;

    @FXML
    private TextField text_nv_prenom;

    @FXML
    void enregistrer_modif(ActionEvent event) throws SQLException {

        Utilisateur user = new Utilisateur(text_nv_nom.getText(), text_nv_prenom.getText());
        UtilisateurController controluser = new UtilisateurController();
        controluser.modifInscrit(user);
    }



}
