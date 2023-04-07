package graphicController;
import controller.utilisateurController.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.utilisateur.Utilisateur;

public class PasswordReset {
    @FXML
    private TextField confirmation;

    @FXML
    private TextField mdp;

    @FXML
    private Label message;

    private Utilisateur user;

    public PasswordReset(Utilisateur user){
        this.user = user;
        System.out.println(this.user.getId());
        System.out.println(this.user.getEmail());
    }

    @FXML
    void valid(ActionEvent event) {
        System.out.println("valid");
        if (mdp.getText().length() > 5){
            if (mdp.getText().equals(confirmation.getText())){
                user.setMdp(mdp.getText());
                System.out.println("ok");
                UtilisateurController.SetMdp(user);
            }
            else{
                message.setText("pas meme mdp");
            }
        }
        else{
            message.setText("votre mdp doit faire au moins 5 char");
        }
    }
}
