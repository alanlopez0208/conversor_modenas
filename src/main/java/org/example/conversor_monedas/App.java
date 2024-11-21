package org.example.conversor_monedas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class App extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        Font.loadFont(App.class.getResource("views/fonts/Montserrat.ttf").toExternalForm().replace("%20"," "),14);
        Font.loadFont(App.class.getResource("views/fonts/Montserrat-Bold.ttf").toExternalForm().replace("%20"," "),14);
   }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/org/example/conversor_monedas/views/scenes/App.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Conversor de Monedas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}