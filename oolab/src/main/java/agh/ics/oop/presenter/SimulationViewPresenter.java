package agh.ics.oop.presenter;

import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class SimulationViewPresenter implements MapChangeListener{
    private static final double CELL_WIDTH = 35;
    private static final double CELL_HEIGHT = 35;

    @FXML
    private Label infoLabel;
    @FXML
    private GridPane mapGrid;

    private WorldMap<Animal, Vector2d> worldMap;

    public void drawMap(){
        clearGrid();

        Boundary boundary = worldMap.getCurrentBounds();
        int numRows = boundary.upperRight().getY() - boundary.lowerLeft().getY() + 1;
        int numCols = boundary.upperRight().getX() - boundary.lowerLeft().getX() + 1;

        for (int row = 0; row < numRows + 1; row++){
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }

        for (int col = 0; col < numCols + 1; col++){
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }

        drawHeaders(boundary,numRows,numCols);

        for (int i = 1; i < numCols + 1; i++){
            for (int j = 1; j < numRows + 1; j++){
                drawObject(new Vector2d(boundary.lowerLeft().getX() + i - 1, boundary.upperRight().getY() - j + 1),i,j);
            }
        }
    }

    private void drawHeaders(Boundary boundary, int numRows, int numCols) {
        Label label00 = new Label("y\\x");
        GridPane.setHalignment(label00, HPos.CENTER);
        mapGrid.add(label00, 0 ,0);
        for(int i = 0; i < numCols; i++){
            Label label = new Label(String.format("%2d",boundary.lowerLeft().getX()+i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,i+1,0);
        }
        for(int j = 0; j < numRows; j++){
            Label label = new Label(String.format("%2d",boundary.upperRight().getY()-j));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,0,j+1);
        }
    }

    private void drawObject(Vector2d currentPosition, int i, int j) {
        Optional<WorldElement> worldElement = worldMap.objectAt(currentPosition);
        if (worldElement.isPresent()) {
            WorldElementBox elementBox = new WorldElementBox(worldElement.get());
            mapGrid.add(elementBox, i, j);
        } else {
            Label label = new Label(" ");
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label, i, j);
        }
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @Override
    public void mapChanged(WorldMap<Animal, Vector2d> worldMap, String message) {
        Platform.runLater(() -> {
            drawMap();
            infoLabel.setText(message);
        });
    }

    public void setWorldMap(WorldMap<Animal, Vector2d> map) {
        this.worldMap = map;
    }
}
