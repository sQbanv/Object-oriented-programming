package agh.ics.oop.model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WorldElementBox extends VBox {
    public WorldElementBox(WorldElement worldElement){
        super();

        Image image = new Image(worldElement.getResource());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        Label positionLabel = new Label(worldElement.getPosition().toString());

        this.getChildren().addAll(imageView, positionLabel);

        this.setAlignment(Pos.CENTER);
    }
}
