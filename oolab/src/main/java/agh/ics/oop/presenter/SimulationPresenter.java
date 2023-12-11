package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;


public class SimulationPresenter implements MapChangeListener{
    private static final double CELL_WIDTH = 25;
    private static final double CELL_HEIGHT = 25;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField directionInput;
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
                Label label = new Label(drawObject(new Vector2d(boundary.lowerLeft().getX() + i - 1, boundary.upperRight().getY() - j + 1)));
                GridPane.setHalignment(label, HPos.CENTER);
                mapGrid.add(label, i, j);
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

    private String drawObject(Vector2d currentPosition) {
        Object object = this.worldMap.objectAt(currentPosition);
        if (object != null) {
            return object.toString();
        }
        return " ";
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

    public void onSimulationStartClicked(){
        List<MoveDirection> directions = OptionsParser.options(directionInput.getText().split(" "));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        SimulationEngine simulationEngine = new SimulationEngine(List.of(new Simulation(directions, positions, worldMap)));
        simulationEngine.runAsync();
    }

    public void setWorldMap(WorldMap<Animal, Vector2d> map) {
        this.worldMap = map;
    }
}
