package org.example.conversor_monedas.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.example.conversor_monedas.data.local.HistorialDAO;
import org.example.conversor_monedas.domain.models.Historial;
import org.example.conversor_monedas.views.componets.SideBar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class AppController implements Initializable, HistorialObservador {

    @FXML
    private BorderPane index;
    @FXML
    private SideBar sidebar;
    private final String URL = "/org/example/conversor_monedas/views/scenes";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            VBox panelConversor = FXMLLoader.load(AppController.class.getResource(STR."\{URL}/Conversor.fxml"));
            index.setCenter(panelConversor);
            sidebar.setConsumer(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    if (integer.equals(0)){
                        index.setCenter(panelConversor);
                    }else if(integer.equals(1)){
                        try {
                            VBox panelHistorial = null;
                            panelHistorial = FXMLLoader.load(AppController.class.getResource(STR."\{URL}/Historial.fxml"));
                            index.setCenter(panelHistorial);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ObservableList<Historial> historialList) {

    }
}