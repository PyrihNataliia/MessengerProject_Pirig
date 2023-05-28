module com.example.messenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jdom2;


    opens com.example.messenger to javafx.fxml;
    exports com.example.messenger;
}