package org.example.conversor_monedas.controllers;

import javafx.collections.ObservableList;
import org.example.conversor_monedas.domain.models.Historial;

public interface HistorialObservador {
    public void update(ObservableList<Historial> historialList);
}
