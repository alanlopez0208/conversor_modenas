package org.example.conversor_monedas.controllers;

import javafx.collections.ObservableList;
import org.example.conversor_monedas.data.local.HistorialDAO;
import org.example.conversor_monedas.domain.models.Historial;

import java.util.List;

public class HistorialSujeto {
    private ObservableList<Historial> historials;
    private List<HistorialObservador> observadors;
    private HistorialDAO historialDAO;

    public HistorialSujeto(){
        historialDAO = new HistorialDAO();
        historials.addAll(historialDAO.getHistorial());
    }

    private void addObservador(HistorialObservador historialObservador){
        observadors.add(historialObservador);

    }
    
    private void eliminarObservador(HistorialObservador historialObservador){
        observadors.remove(historialObservador);
    }

    public ObservableList<Historial> getHistorials() {
        return historials;
    }

    public void addHistorial(Historial historial){
        historials.add(historial);
        notifyListeners();
    }

    private void notifyListeners(){
        for(HistorialObservador historialObservador : observadors){
            historialObservador.update(historials);
        }
    }
}
