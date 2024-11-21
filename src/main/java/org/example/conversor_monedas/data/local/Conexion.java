package org.example.conversor_monedas.data.local;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;

    private static Conexion conexion;

    private Conexion() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:D:/Alan Lopez/Documentos/Instituto Tecnologico de Durango/Cursos de programacion/Curso de Alura/Java/conversor_monedas/src/main/java/org/example/conversor_monedas/data/local/bdd.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Conexion getConexion() {
        if (conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }
}
