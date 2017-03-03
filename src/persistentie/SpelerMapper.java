package persistentie;

import domein.Speler;

public class SpelerMapper {
    
    public String[] geefAlleNamen(){
        
        String spelernaamarray[] = new String[500];
        
        Speler speler1 = new Speler("Jan",1999,50);
        Speler speler2 = new Speler("Piet",1989,10);
        Speler speler3 = new Speler("Joris",1987,100);
        Speler speler4 = new Speler("Korneel",1992,15);
        
        spelernaamarray[0]=speler1.getNaam();
        spelernaamarray[1]=speler2.getNaam();
        spelernaamarray[2]=speler3.getNaam();
        spelernaamarray[3]=speler4.getNaam();
        
        
        
        return spelernaamarray;
    }
    
}
