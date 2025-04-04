package agh.ics.oop;

import agh.ics.oop.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class World {
    public static void run(List<MoveDirection> directions){
        for(MoveDirection direction : directions){
            switch (direction){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<MoveDirection> directions = OptionsParser.options(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        List<Simulation> simulations = new LinkedList<>();
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();

//        for(int i=0; i<1; i++){
//            GrassField grassField = new GrassField(10);
//            grassField.addListener((event,message) -> {
//                LocalDateTime currentDateTime = LocalDateTime.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                String formattedDateTime = currentDateTime.format(formatter);
//                System.out.println(formattedDateTime + " " + message);
//            });
//            grassField.addListener(consoleMapDisplay);
//            grassField.addListener(new FileMapDisplay());
//            simulations.add(new Simulation(directions,positions,grassField));
//        }

        GrassField grassField = new GrassField(10);
        grassField.addListener(consoleMapDisplay);
        simulations.add(new Simulation(directions,positions,grassField));

        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsyncInThreadPool();
        simulationEngine.awaitSimulationsEnd();

        System.out.println(grassField.getOrderedAnimals());

        System.out.println("System stopped working");
    }
}
