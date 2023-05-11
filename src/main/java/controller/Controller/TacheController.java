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
        req.setBoolean(3, uneTache.getEst_realise());
        req.setInt(4, uneTache.getRef_liste());
        req.setInt(5, uneTache.getRef_type());
        req.executeUpdate();
    }
    public void modifierTache(Tache uneTache) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE Tache set nom = ?, description = ? where id_tache = ?");
        req.setString(1, uneTache.getNom());
        req.setString(2, uneTache.getDescription());
        req.setInt(3, uneTache.getId_tache());
        req.executeUpdate();
    }

    public static void supprimerTache(int id_tache) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM Tache where id_tache = ?");
            req.setInt(1,id_tache);
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
