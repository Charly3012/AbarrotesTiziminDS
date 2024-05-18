module com.abarrotestizimin.abarrotestizimin {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.kordamp.bootstrapfx.core;

    opens com to javafx.fxml;
    exports com;
    exports com.controlador;
    opens com.controlador to javafx.fxml;

    opens com.modelo to javafx.fxml;
    exports com.modelo;

}