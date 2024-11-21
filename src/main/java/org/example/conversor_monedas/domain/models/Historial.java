package org.example.conversor_monedas.domain.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Historial {

    private SimpleStringProperty paisOrigen;
    private SimpleStringProperty paisResultado;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleDoubleProperty amount;

    public Historial(){
        this.paisOrigen = new SimpleStringProperty();
        this.paisResultado = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.date = new SimpleObjectProperty<>();
    }

    public Historial(String paisOrigen, String paisResultado, LocalDate date, double amount) {
        this.paisOrigen = new SimpleStringProperty(paisOrigen);
        this.paisResultado = new SimpleStringProperty(paisResultado);
        this.amount = new SimpleDoubleProperty(amount);
        this.date = new SimpleObjectProperty<>(date);
    }

    public String getPaisOrigen() {
        return paisOrigen.get();
    }

    public SimpleStringProperty paisOrigenProperty() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen.set(paisOrigen);
    }

    public String getPaisResultado() {
        return paisResultado.get();
    }

    public SimpleStringProperty paisResultadoProperty() {
        return paisResultado;
    }

    public void setPaisResultado(String paisResultado) {
        this.paisResultado.set(paisResultado);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }
}
