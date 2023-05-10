package controller.Controller;

import Classes.Liste;
import Classes.Tache;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TacheController {

    public void ajouterTache(Tache uneTache) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO tache (nom,description, est_realise, ref_type, ref_liste) VALUES (?,?,?,?,?)");
        req.setString(1, uneTache.getNom());
        req.setString(2, uneTache.getDescription());
        req.setBoolean(3, uneTache.getRealise());
        req.setInt(4, uneTache.getRef_liste());
        req.setInt(5, uneTache.getRef_type());
        req.executeUpdate();
    }
}
