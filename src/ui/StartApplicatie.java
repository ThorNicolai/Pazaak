package ui;

import domein.DomeinController;

public class StartApplicatie {
    
    private final DomeinController dc;
    
    public StartApplicatie(DomeinController dc){
        this.dc = dc;
    }

    public void start() {

        DomeinController dc = new DomeinController();
        int keuze = 0;

        KiesTaalApp ktapp = new KiesTaalApp(dc);
        OptieMenu optiem = new OptieMenu(dc);
        RegistreerApp rapp = new RegistreerApp(dc);
        ToonSpelerLijstApp tslapp = new ToonSpelerLijstApp(dc);
        Kies2SpelersApp k2sa = new Kies2SpelersApp(dc);

        System.out.println("Welkom / Welcome / Bienvenue");
        ktapp.kiesTaal();

        keuze = optiem.kiesOptie();

        switch (keuze) {

            case 1:
                rapp.registreer();
                break;

            case 2:
                System.out.printf("%s%n", tslapp.toonSpelersLijst());
                k2sa.kies2Spelers();
                break;

        }

    }
}
