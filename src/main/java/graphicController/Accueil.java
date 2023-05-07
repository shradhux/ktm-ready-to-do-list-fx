package graphicController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modele.bdd.Bdd;
import modele.utilisateur.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Accueil {



        private final Utilisateur user;

        public  Accueil(Utilisateur user){
            this.user = user;
        }





        @FXML
        private Label A1;

        @FXML
        private Label A2;

        @FXML
        private Label A3;

        @FXML
        private Label A4;

        @FXML
        private Label A5;

        @FXML
        private Label A6;

        @FXML
        private Label B1;

        @FXML
        private Label B2;

        @FXML
        private Label B3;

        @FXML
        private Label B4;

        @FXML
        private Label B5;

        @FXML
        private Label B6;

        @FXML
        private Label C1;

        @FXML
        private Label C2;

        @FXML
        private Label C3;

        @FXML
        private Label C4;

        @FXML
        private Label C5;

        @FXML
        private Label C6;

        @FXML
        private Label D1;

        @FXML
        private Label D2;

        @FXML
        private Label D3;

        @FXML
        private Label D4;

        @FXML
        private Label D5;

        @FXML
        private Label D6;

        @FXML
        private Label E1;

        @FXML
        private Label E2;

        @FXML
        private Label E3;

        @FXML
        private Label E4;

        @FXML
        private Label E5;

        @FXML
        private Label E6;

        @FXML
        private Label F1;

        @FXML
        private Label F2;

        @FXML
        private Label F3;

        @FXML
        private Label F4;

        @FXML
        private Label F5;

        @FXML
        private Label F6;

        @FXML
        private Label G1;

        @FXML
        private Label G2;

        @FXML
        private Label G3;

        @FXML
        private Label G4;

        @FXML
        private Label G5;

        @FXML
        private Label G6;

        @FXML
        private Label H1;

        @FXML
        private Label H2;

        @FXML
        private Label H3;

        @FXML
        private Label H4;

        @FXML
        private Label H5;

        @FXML
        private Label H6;

        @FXML
        private Label I1;

        @FXML
        private Label I2;

        @FXML
        private Label I3;

        @FXML
        private Label I4;

        @FXML
        private Label I5;

        @FXML
        private Label I6;

        @FXML
        private Button ajouter_liste;

        @FXML
        private Button ajouter_tache;

        @FXML
        private Button btn_profil;

        @FXML
        private Button consulter_liste;

        @FXML
        private Label label1;

        @FXML
        private Label label11111111;

        @FXML
        private Label label11111112;

        @FXML
        private Label label1111112;

        @FXML
        private Label label1111113;

        @FXML
        private Label label1111121;

        @FXML
        private Label label1111122;

        @FXML
        private Label label111113;

        @FXML
        private Label label111114;

        @FXML
        private Label label1111211;

        @FXML
        private Label label1111212;

        @FXML
        private Label label111122;

        @FXML
        private Label label111123;

        @FXML
        private Label label111131;

        @FXML
        private Label label111132;

        @FXML
        private Label label11211111;

        @FXML
        private Label label11211112;

        @FXML
        private Label label1121112;

        @FXML
        private Label label1121113;

        @FXML
        private Label label1121121;

        @FXML
        private Label label1121122;

        @FXML
        private Label label112113;

        @FXML
        private Label label112114;

        @FXML
        private Label label1121211;

        @FXML
        private Label label1121212;

        @FXML
        private Label label112122;

        @FXML
        private Label label112123;

        @FXML
        private Label label112131;

        @FXML
        private Label label112132;

        @FXML
        private Label label11311111;

        @FXML
        private Label label11311112;

        @FXML
        private Label label1131112;

        @FXML
        private Label label1131113;

        @FXML
        private Label label1131121;

        @FXML
        private Label label1131122;

        @FXML
        private Label label113113;

        @FXML
        private Label label113114;

        @FXML
        private Label label1131211;

        @FXML
        private Label label1131212;

        @FXML
        private Label label113122;

        @FXML
        private Label label113123;

        @FXML
        private Label label113131;

        @FXML
        private Label label113132;

        @FXML
        private Label label11411111;

        @FXML
        private Label label11411112;

        @FXML
        private Label label1141112;

        @FXML
        private Label label1141113;

        @FXML
        private Label label1141121;

        @FXML
        private Label label1141122;

        @FXML
        private Label label114113;

        @FXML
        private Label label114114;

        @FXML
        private Label label1141211;

        @FXML
        private Label label1141212;

        @FXML
        private Label label114122;

        @FXML
        private Label label114123;

        @FXML
        private Label label114131;

        @FXML
        private Label label114132;

        @FXML
        private Label label11511111;

        @FXML
        private Label label11511112;

        @FXML
        private Label label1151112;

        @FXML
        private Label label1151113;

        @FXML
        private Label label1151121;

        @FXML
        private Label label1151122;

        @FXML
        private Label label115113;

        @FXML
        private Label label115114;

        @FXML
        private Label label1151211;

        @FXML
        private Label label1151212;

        @FXML
        private Label label115122;

        @FXML
        private Label label115123;

        @FXML
        private Label label115131;

        @FXML
        private Label label115132;

        @FXML
        private Label label1161111;

        @FXML
        private Label label1161112;

        @FXML
        private Label label116112;

        @FXML
        private Label label116113;

        @FXML
        private Label label116121;

        @FXML
        private Label label116122;

        @FXML
        private Label label11613;

        @FXML
        private Label label11614;

        @FXML
        private Label label116211;

        @FXML
        private Label label116212;

        @FXML
        private Label label11622;

        @FXML
        private Label label11623;

        @FXML
        private Label label11631;

        @FXML
        private Label label11632;

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
        Main.change("AjouterListe");


    }

    @FXML
    void action_ajouter_tache(ActionEvent event) {
        Main.change("AjouterTache");

    }

    @FXML
    void action_consulter_liste(ActionEvent event) throws SQLException {

        Bdd bdd = new Bdd();
        PreparedStatement preparerListe = bdd.getBdd().prepareStatement("SELECT * FROM utilisateur");
        ResultSet afficherListe = preparerListe.executeQuery();

        while(afficherListe.next());{

        }


    }

    @FXML
    void action_modifier_liste(ActionEvent event) {
        Main.change("ModificationListe");
    }

    @FXML
    void action_modifier_tache(ActionEvent event) {
        Main.change("ModifTache");

    }

    @FXML
    void action_profil(ActionEvent event) {

    }

    @FXML
    void action_selectionner_liste(ActionEvent event) throws SQLException {

        this.label1.setText("Position : ");
        this.label2.setText("Nom : ");
        this.label3.setText("Description : ");





     this.A2.setText(carnet.getDescriptionListe(0));






    }

    @FXML
    void action_supprimer_liste(ActionEvent event) {
        Main.change("SupprimerListe");

    }

    @FXML
    void action_supprimer_tache(ActionEvent event) {
        Main.change("SupprimerTache");

    }

    @FXML
    void action_supprimer_type(ActionEvent event) {

    }

    @FXML
    void action_valider_tache(ActionEvent event) {

    }

}
