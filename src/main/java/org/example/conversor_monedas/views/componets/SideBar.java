package org.example.conversor_monedas.views.componets;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

public class SideBar extends VBox {

    @FXML
    Circle circle;
    @FXML
    JFXButton btnConvertidor;
    @FXML
    JFXButton btnList;
    Consumer<Integer> consumer;

    public SideBar() {
        try {
            URL url = getClass().getResource("/org/example/conversor_monedas/views/componets/Sidebar.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setRoot(this);
            loader.setController(SideBar.this);
            loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        initElements();
    }


    private void initElements(){
        Image image = new Image(getClass().getResource("/org/example/conversor_monedas/views/img/alura.png").toExternalForm(),100,100,true,true);
        ImagePattern imagePattern = new ImagePattern(image);
        circle.setFill(imagePattern);
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource().equals(btnConvertidor)){
                    consumer.accept(0);
                }else if (event.getSource().equals(btnList)){
                    consumer.accept(1);
                }
            }
        };



        btnConvertidor.setOnAction(eventHandler);
        btnList.setOnAction(eventHandler);
    }

    public Consumer<Integer> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<Integer> consumer) {
        this.consumer = consumer;
    }
}