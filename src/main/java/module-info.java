module org.example.conversor_monedas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.conversor_monedas to javafx.fxml;
    exports org.example.conversor_monedas;
}