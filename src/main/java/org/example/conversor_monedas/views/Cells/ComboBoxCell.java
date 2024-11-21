package org.example.conversor_monedas.views.Cells;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.example.conversor_monedas.domain.models.Countries;

public class ComboBoxCell extends ListCell<Countries> {

    @Override
    protected void updateItem(Countries item, boolean empty) {
        super.updateItem(item, empty);
        if (empty){
            this.setText(null);
            this.setGraphic(null);
        }else{
            ImageView image = new ImageView(item.getImage());
            image.setPreserveRatio(true);
            image.setSmooth(true);
            image.setFitWidth(30);
            Label text = new Label(item.getNombre());

            HBox container = new HBox(image, text);
            container.setAlignment(Pos.CENTER_LEFT);
            container.setSpacing(10);

            this.setGraphic(container);
            this.setText(null);
        }

    }
}
