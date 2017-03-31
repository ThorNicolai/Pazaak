package ui;

import domein.DomeinController;

public class StartApplicatie {

    public void start() {

        DomeinController dc = new DomeinController();
        int keuze = 0;

        KiesTaalApp ktapp = new KiesTaalApp(dc);
        OptieMenu optiem = new OptieMenu(dc);
        RegistreerApp rapp = new RegistreerApp(dc);
        ToonSpelerLijstApp tslapp = new ToonSpelerLijstApp(dc);

        System.out.println("Welkom / Welcome / Bienvenue");
        ktapp.kiesTaal();

        keuze = optiem.kiesOptie();

        switch (keuze) {

            case 1:
                rapp.registreer();
                break;

            case 2:
                System.out.printf("%s%n", tslapp.toonSpelersLijst());
                break;

        }

    }
}
