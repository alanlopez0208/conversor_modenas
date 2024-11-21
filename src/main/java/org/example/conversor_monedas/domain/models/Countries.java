package org.example.conversor_monedas.domain.models;

import javafx.scene.image.Image;

public class Countries {
    private String code;
    private String nombre;
    private Image image;

    public Countries(){
    }

    public Countries(String code, String nombre, String image) {
        this.code = code;
        this.nombre = nombre;
        this.image = new Image(getClass().getResource("/org/example/conversor_monedas/views/img/"+image+".png").toString());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", image=" + image +
                '}';
    }
}
