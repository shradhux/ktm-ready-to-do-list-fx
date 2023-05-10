package graphicController;

import Classes.Liste;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuType {
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.refresh();
        PreparedStatement extraireType = null;
        try {
            extraireType = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet recupType = null;
        try {
            recupType = extraireType.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true){
            try {
                if (!recupType.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                data.add(new Liste(recupType.getInt(1), recupType.getString(2),recupType.getString(3)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            extraireType.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        id.setCellValueFactory(new PropertyValueFactory<Liste,  Integer>("id_liste"));
        nom.setCellValueFactory(new PropertyValueFactory<Liste,  String>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<Liste, String>("description"));
        table.refresh();
        table.setItems(data);
        table.refresh();
}
