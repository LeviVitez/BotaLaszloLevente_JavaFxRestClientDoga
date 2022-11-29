module com.example.botalaszlolevente_javafxrestclientdoga {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.botalaszlolevente_javafxrestclientdoga to javafx.fxml;
    exports com.example.botalaszlolevente_javafxrestclientdoga;
}