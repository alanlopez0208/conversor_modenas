package org.example.conversor_monedas.views.utils;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeAnimation {

    final FadeTransition animation;

    public FadeAnimation(Node node, double from, double to, Duration duration){
        this.animation = new FadeTransition();
        animation.setFromValue(from);
        animation.setToValue(to);
        animation.setNode(node);
    }
    public void play(){

        System.out.println(animation.getToValue());
        animation.play();
    }
}
