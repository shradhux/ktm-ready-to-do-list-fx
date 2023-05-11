package controller.Controller;

import Classes.Liste;
import Classes.Utilisateur;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListeController {

    private int nvIdListe;
    public void ajouterListe(Liste uneListe) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("insert into liste (nom,description) VALUES (?,?)") ;
        req.setString(1, uneListe.getNom());
        req.setString(2, uneListe.getDescription());
        req.executeUpdate();



        PreparedStatement req2 = new Bdd().getBdd().prepareStatement("SELECT id_liste FROM liste WHERE nom = ? AND description = ?") ;
        req2.setString(1, uneListe.getNom());
        req2.setString(2, uneListe.getDescription());
        ResultSet rep = req2.executeQuery();
        while(rep.next()) {
            nvIdListe = rep.getInt(1);
        }

        PreparedStatement req1 = new Bdd().getBdd().prepareStatement("insert into UtilisateurListe (ref_utilisateur,ref_liste) VALUES (?,?)");
        req1.setInt(1, Utilisateur.getId());
        req1.setInt(2, nvIdListe);
        req1.executeUpdate();




    }

    public void modifierListe(Liste uneListe) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE Liste set nom = ?, description = ? where id_liste = ?");
        req.setString(1, uneListe.getNom());
        req.setString(2, uneListe.getDescription());
        req.setInt(3, uneListe.getId_liste());
        req.executeUpdate();
    }

    public void supprimerListe(int id_liste) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM Liste where id_liste = ?");
        req.setInt(1,id_liste);
        req.executeUpdate();
    }
}
