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


public class StartUp  {
    
    public static void main(String[] args) {
        
        DomeinController dc = new DomeinController();
        StartApplicatie sa = new StartApplicatie(dc);
        sa.start();
        
        
        
    }

    
}
