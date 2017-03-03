package gui;

import domein.DomeinController;

public class StartUp {
    
    public static void main(String[] args) {
        
        DomeinController dc = new DomeinController();
        
        dc.voegSpelerToe("Yarne", 2000); //roept methode voegSpelerToe aan uit DC
        
    }
}
