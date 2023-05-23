module com.example.jattempt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.model to javafx.fxml;
    exports com.example.model;
    exports com.example;
    opens com.example to javafx.fxml;
}