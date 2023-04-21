package graphicController;


import application.Main;
import controller.utilisateurController.UtilisateurController;
import modele.bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.emailUtil.Email;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Oubli {

    @FXML
    private Label email_envoie;

    @FXML
    private TextField input;

    @FXML
    private Label title;

    @FXML
    private Button verrif;

    private int nb;
    private String email;

    @FXML
    void verrifi_email(ActionEvent event) {
        email_envoie.setVisible(true);
        this.email = input.getText();
        input.setText("");
        title.setText("entrez le code de validation reçu par e-mail !!");
        verrif.setOnAction(actionEvent -> {
            try {
                verrif();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        if (UtilisateurController.countEmail(this.input.getText()) != 0){
            this.nb = new Random().nextInt() % 99999999;
            //xrilmahriuhyrevn
            Email.send(this.email, "Code de validation CrudFX", "le code de validation est : "+nb);
        }
    }
    public void verrif() throws SQLException {
        if (parseInt(input.getText()) == this.nb){
            System.out.println(parseInt(input.getText()));
            Main.change("PasswordReset", new PasswordReset(UtilisateurController.getByEmail(this.email)), "bah reset password ein");
        }
        else {
            Main.change("Oubli", new Oubli(), "ah, C balo | :-( | !!!");
        }
    }

}
