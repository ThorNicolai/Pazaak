package main;

import domein.DomeinController;
import gui.TaalScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.KiesTaalApp;
import ui.OptieMenu;

import ui.RegistreerApp;
import ui.StartApplicatie;
import ui.ToonSpelerLijstApp;

public class StartUp extends Application {

    public void start(Stage primaryStage) {

        TaalScherm ts = new TaalScherm(new DomeinController());
        Scene sc = new Scene(ts, 550, 500);
        primaryStage.setTitle("Pazaak");
        primaryStage.setScene(sc);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
