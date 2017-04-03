package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KiesTaalApp {
    
    private final DomeinController dc;
    Taal taal = null;
    
    Scanner scan = new Scanner(System.in);

    public KiesTaalApp(DomeinController dc) {
        this.dc = dc;
    }
    
    public Taal kiesTaal() {
        int keuze = 1;
        boolean keuzeBoolean = false;

        do {
            try {
                do {

                    System.out.printf("1) Nederlands%n2) Français%n3)English%n");
                    keuze = scan.nextInt();
                    scan.nextLine();
                } while (keuze != 1 && keuze != 2 && keuze != 3);
                keuzeBoolean = true;
            } catch (InputMismatchException e) {
                System.out.println(("The selection must be 1,2 or 3"));
                scan.nextLine();
            }
        } while (keuzeBoolean == false);

        Taal taal = new Taal(keuze);
        System.out.println(taal.geefVertaling("taal"));
        return taal;
    }
    
    

}
