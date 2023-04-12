package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    /**
     * l'objet stage représente la fenètre actuellement affiché
     * et permet d'interragir avec pour changer de scène,
     * de titre ou de controller
     */
    public static Stage stage;

    /**
     * permet d'afficher la page principale
     * @param mystage
     * @throws IOException
     */
    @Override
    public void start(Stage mystage) throws IOException {
        this.stage = mystage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Connection.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * permet de changer la scène présente sur notre stage
     * @param fxml
     * @param controller
     * @param title
     */
    public static void change(String fxml, Object controller, String title){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controller);
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}