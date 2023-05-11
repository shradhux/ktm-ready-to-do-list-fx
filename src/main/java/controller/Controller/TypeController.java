package controller.Controller;

import Classes.Type;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TypeController {


    public void ajouterType(Type uneType) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("insert into type (libelle,code_couleur) VALUES (?,?)");
        req.setString(1, uneType.getLibelle());
        req.setString(2, uneType.getCode_couleur());
        req.executeUpdate();
    }

    public void modifierType(Type uneType) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE Type set libelle = ?, code_couleur = ? where id_type = ?");
        req.setString(1, uneType.getLibelle());
        req.setString(2, uneType.getCode_couleur());
        req.setInt(3, uneType.getId_type());
        req.executeUpdate();
    }

    public static void supprimerType(int id_type) throws SQLException {


        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM Type where id_type = ?");
        req.setInt(1,id_type);
        req.executeUpdate();
    }


}
