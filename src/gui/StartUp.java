package gui;

import domein.DomeinController;
import ui.PazaakApplicatie;

public class StartUp {

    public static void main(String[] args) {
        
        DomeinController dc = new DomeinController();
        int keuze;
        
        
        PazaakApplicatie pa = new PazaakApplicatie(dc);
        System.out.println("Welkom / Welcome / Bienvenue");
        //pa.kiesTaal();        
        
        keuze = pa.kiesOptie();
        
        
        switch(keuze){
            
            case 1: pa.registreer();break;
            case 2: ;
            case 3: ;
            
        }
        
        
        
        

    }

}
