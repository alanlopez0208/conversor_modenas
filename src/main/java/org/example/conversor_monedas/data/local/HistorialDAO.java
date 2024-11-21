package org.example.conversor_monedas.data.local;


import org.example.conversor_monedas.domain.models.Conversion;
import org.example.conversor_monedas.domain.models.Historial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialDAO {

    private Connection connection;

    public HistorialDAO(){
        connection = Conexion.getConexion().getConnection();
    }

    public List<Historial> getHistorial(){
        List<Historial> historials = new ArrayList<>();
        String sql = "SELECT * FROM Historial";

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                historials.add(conversion(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return historials;
    }


    public boolean insertHistoria(Historial historial){
        String setencia = "INSERT INTO Historial(pais_origen, pais_destino,amount, fecha) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(setencia);
            preparedStatement.setString(1, historial.getPaisOrigen());
            preparedStatement.setString(2, historial.getPaisResultado());
            preparedStatement.setDouble(3, historial.getAmount());
            preparedStatement.setString(4,historial.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private Historial conversion(ResultSet rs){
        Historial historial = new Historial();


        try {
            historial.setPaisOrigen(rs.getString("pais_origen"));
            historial.setPaisResultado(rs.getString("pais_destino"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(rs.getString("fecha"), formatter);
            historial.setAmount(rs.getDouble("amount"));
            historial.setDate(localDate);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return historial;
    }
}
