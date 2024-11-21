package org.example.conversor_monedas.controllers;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.example.conversor_monedas.data.local.HistorialDAO;
import org.example.conversor_monedas.data.repostory_imp.ConversasionRepositoyImp;
import org.example.conversor_monedas.domain.models.Conversion;
import org.example.conversor_monedas.domain.models.Countries;
import org.example.conversor_monedas.domain.models.Historial;
import org.example.conversor_monedas.domain.repository.ConversasionRepository;
import org.example.conversor_monedas.views.Cells.ComboBoxCell;
import org.example.conversor_monedas.views.utils.FadeAnimation;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ConversorController implements Initializable {

    @FXML
    ComboBox<Countries> comboAmount;
    @FXML
    ComboBox<Countries> comboResult;
    @FXML
    TextField txtAmount;
    @FXML
    TextField txtResult;
    @FXML
    Label txtLoading;
    @FXML
    Label txtConversionRate;
    private ConversasionRepository conversasionRepository;
    private FadeTransition fadeTransition;
    private HistorialDAO historialDAO;

    private ObservableList<Historial> historials;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conversasionRepository = new ConversasionRepositoyImp();
        historialDAO = new HistorialDAO();
        fadeTransition = new FadeTransition( Duration.millis(400), txtLoading);

        ObservableList<Countries> countries = FXCollections.observableArrayList();
        countries.addAll(
                new Countries("MXN", "Peso Mexicano", "mexico"),
                new Countries("USD", "Dollar Estaunidense ","eua") ,
                new Countries("EUR", "Euro Español","españa"),
                new Countries("ARS", "Peso Argentino","argentina"),
                new Countries("BRL", "Real Brasileño","brasil")
        );
        updateComboBox(comboAmount, countries);
        updateComboBox(comboResult, countries);

        txtAmount.setTextFormatter(new TextFormatter<>(new UnaryOperator<>(){
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                if (change.getControlNewText().matches("\\d*")){
                    return change;
                }
                return null;
            }
        }));
    }

    @FXML
    private void calcularConversion(ActionEvent event){
        Countries countryOrigin = comboAmount.getSelectionModel().getSelectedItem();
        Countries countryResult = comboResult.getSelectionModel().getSelectedItem();
        String textMonto = txtAmount.getText();
        if(countryOrigin == null || countryResult == null || textMonto.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Debes seleccionar el pais de origen, el pais a convertir y el monto deseado");
            alert.showAndWait();
            return;
        }
        Integer monto = Integer.parseInt(textMonto);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        txtConversionRate.setText("");
        conversasionRepository.getConversion(countryOrigin.getCode(),countryResult.getCode(),monto).thenAcceptAsync(new Consumer<Conversion>() {
            @Override
            public void accept(Conversion conversion) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0);
                        fadeTransition.play();
                        txtResult.setText(Double.toString(conversion.conversion_result()));
                        txtConversionRate.setText(STR."1 \{countryOrigin.getCode()} = \{conversion.conversion_rate()} \{countryResult.getCode()}");
                        LocalDate date = LocalDate.now();
                        Historial historial = new Historial(countryOrigin.getNombre(), countryResult.getNombre(), date, monto);
                        historialDAO.insertHistoria(historial);
                    }
                });
            }
        });

    }


    private void updateComboBox(ComboBox<Countries> comboBox, ObservableList<Countries> countries){
        comboBox.getItems().addAll(countries);
        comboBox.setCellFactory(new Callback<ListView<Countries>, ListCell<Countries>>() {
            @Override
            public ListCell<Countries> call(ListView<Countries> countriesListView) {
                return new ComboBoxCell();
            }
        });
        comboBox.setButtonCell(new ComboBoxCell());
    }
}
