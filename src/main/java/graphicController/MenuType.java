package graphicController;

import Classes.Liste;
import Classes.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuType {

    @FXML
    private TableColumn<Type, String> code_couleur;

    @FXML
    private TableColumn<Type, Integer> idType;

    @FXML
    private TableColumn<Type, String> libelle;
    @FXML private TableView<Type> table;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.refresh();
        PreparedStatement extraireType = null;
        try {
            extraireType = new Bdd().getBdd().prepareStatement("SELECT * FROM Type");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet recupType= null;
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
                data.add(new Type(recupType.getInt(1), recupType.getString(2),recupType.getString(3)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            extraireType.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        idType.setCellValueFactory(new PropertyValueFactory<Type,  Integer>("idType"));
        libelle.setCellValueFactory(new PropertyValueFactory<Type,  String>("libelle"));
        code_couleur.setCellValueFactory(new PropertyValueFactory<Type,  String>("code_couleur"));
        table.refresh();
        table.setItems(data);
        table.refresh();


    }
    public ObservableList<Type> data= FXCollections.observableArrayList();
}
