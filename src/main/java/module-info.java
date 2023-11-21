module com.systeminventory {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires com.google.gson;

    opens com.systeminventory.controller to javafx.fxml;
    exports com.systeminventory.controller;
    exports com.systeminventory;
}