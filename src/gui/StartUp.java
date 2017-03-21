package gui;

import domein.DomeinController;
import ui.PazaakApplicatie;

public class StartUp {

    public static void main(String[] args) {
        
        DomeinController dc = new DomeinController();

        PazaakApplicatie pa = new PazaakApplicatie(dc);
        //pa.kiesTaal();
        pa.registreer();

    }

}
