module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.mail;


    opens application to javafx.fxml;
    exports application;
    opens graphicController to javafx.fxml;
    exports graphicController;
}