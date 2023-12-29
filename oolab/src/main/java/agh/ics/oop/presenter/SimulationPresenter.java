package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


public class SimulationPresenter{
    @FXML
    private TextField directionInput;

    public void onSimulationStartClicked() throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulationView.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationViewPresenter presenter = loader.getController();

        List<MoveDirection> directions = OptionsParser.options(directionInput.getText().split(" "));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        GrassField grassField = new GrassField(10);
        grassField.addListener(presenter);

        presenter.setWorldMap(grassField);

        SimulationEngine simulationEngine = new SimulationEngine(List.of(new Simulation(directions, positions, grassField)));
        simulationEngine.runAsync();

        configureStage(primaryStage, viewRoot, grassField.getID());
        primaryStage.show();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot, UUID worldMapUUID){
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app " + worldMapUUID);
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
