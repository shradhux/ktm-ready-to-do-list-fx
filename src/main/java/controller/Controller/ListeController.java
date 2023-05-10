package controller.Controller;

import Classes.Liste;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListeController {
    public void ajouterListe(Liste uneListe) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("insert into liste (nom,description) VALUES (?,?)");
        req.setString(1, uneListe.getNom());
        req.setString(2, uneListe.getDescription());
        req.executeUpdate();
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
