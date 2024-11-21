module org.example.conversor_monedas {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.jfoenix;
    requires org.xerial.sqlitejdbc;
    requires net.coobird.thumbnailator;


    requires org.controlsfx.controls;
    requires java.net.http;

    opens org.example.conversor_monedas to javafx.fxml;
    opens org.example.conversor_monedas.controllers to javafx.fxml;
    opens org.example.conversor_monedas.views.fonts to javafx.fxml;
    opens org.example.conversor_monedas.domain.models to com.google.gson;
    opens org.example.conversor_monedas.views.componets to javafx.fxml;



    exports org.example.conversor_monedas;
    exports org.example.conversor_monedas.views.componets;
    exports org.example.conversor_monedas.domain.models;
}