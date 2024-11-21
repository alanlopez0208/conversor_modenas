package org.example.conversor_monedas.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.conversor_monedas.data.local.HistorialDAO;
import org.example.conversor_monedas.domain.models.Historial;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HistorialController implements Initializable {

    @FXML
    TableView<Historial> tabla;
    @FXML
    TableColumn<Historial,String> columPaisOrigen;
    @FXML
    TableColumn<Historial,String> columnPaisResultado;
    @FXML
    TableColumn<Historial,Double> columnAmonut;
    @FXML
    TableColumn<Historial, LocalDate> columnFecha;
    private HistorialDAO historialDAO;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historialDAO = new HistorialDAO();

        ObservableList<Historial> date = FXCollections.observableArrayList(historialDAO.getHistorial());

        columPaisOrigen.setCellValueFactory(new PropertyValueFactory<Historial,String>("paisOrigen"));
        columnPaisResultado.setCellValueFactory(new PropertyValueFactory<Historial,String>("paisResultado"));
        columnFecha.setCellValueFactory(new PropertyValueFactory<Historial,LocalDate>("date"));
        columnAmonut.setCellValueFactory(new PropertyValueFactory<Historial,Double>("amount"));

        tabla.setItems(date);
    }
}
