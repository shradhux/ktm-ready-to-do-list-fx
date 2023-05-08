package controller.Controller;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;
import Classes.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurController {

    public Utilisateur Connect(String email, String mdp) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("select id_utilisateur, nom, prenom, mail, mdp, est_admin from utilisateur where mail = ? and mdp = ? ;");
        req.setString(1, email);
        req.setString(2, mdp);
        ResultSet rep = req.executeQuery();
        if (rep.next()) {
            return new Utilisateur(rep.getInt(1), rep.getString(2), rep.getString(3), rep.getString(4), rep.getString(5), rep.getBoolean(6));
        } else {
            return null;
        }
    }

    public static void SetMdp(Utilisateur user) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("Update utilisateur set mdp=? where id_utilisateur=?");
            req.setString(1, user.getMdp());
            req.setInt(2, user.getId());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Utilisateur getByEmail(String email) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("select id_utilisateur, nom, prenom, mail, mdp, est_admin from utilisateur where mail = ?;");
        req.setString(1, email);
        ResultSet rep = req.executeQuery();
        rep.next();
        return new Utilisateur(rep.getInt(1), rep.getString(2), rep.getString(3), rep.getString(4), rep.getString(5), rep.getBoolean(6));

    }

    public static void inscription(Utilisateur user) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("INSERT INTO utilisateur (nom, prenom, mail, mdp, est_admin) VALUES (?,?,?,?,0) ");
            req.setString(1, user.getNom());
            req.setString(2, user.getPrenom());
            req.setString(3, user.getMdp());
            req.setString(4, user.getEmail());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}