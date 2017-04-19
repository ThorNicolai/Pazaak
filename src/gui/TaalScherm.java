package gui;

import domein.DomeinController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaalScherm extends VBox {

    private DomeinController dc;

    public TaalScherm(DomeinController dc) {
        this.dc = dc;
        buildGui();
    }

    private void buildGui() {
        
        Label lblWelkom = new Label("Welkom ! Welcome ! Bienvenue !");
        Button btnNederlands = new Button("Nederlands");
        Button btnEngels = new Button("English");
        Button btnFrans = new Button("Français");
        
        this.getChildren().addAll(lblWelkom,btnNederlands,btnEngels,btnFrans);

    }

}
