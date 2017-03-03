package persistentie;

import domein.Speler;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {
    
    public List<Speler> spelers(){
        List<Speler> spelerlijst = new ArrayList<>();
        
        Speler speler1 = new Speler("Jan",1999,50);
        Speler speler2 = new Speler("Piet",1989,10);
        Speler speler3 = new Speler("Joris",1987,100);
        Speler speler4 = new Speler("Korneel",1992,15);
        
        spelerlijst.add(speler1);
        spelerlijst.add(speler2);
        spelerlijst.add(speler3);
        spelerlijst.add(speler4);
        
        return spelerlijst;
    }
    
    public String[] geefAlleNamen(List<Speler> spelerlijst){
        
        String spelernaamarray[] = new String[10]; //voorlopig lengte op 10 ingesteld
        
        for(int i = 0; i<spelerlijst.size();i++){ //overloopt de spelerlijst
            spelernaamarray[i]=spelerlijst.get(i).getNaam(); //steekt de naam van speler i in spelernaamarray[i]
        }
        
//        Speler speler1 = new Speler("Jan",1999,50);
//        Speler speler2 = new Speler("Piet",1989,10);
//        Speler speler3 = new Speler("Joris",1987,100);
//        Speler speler4 = new Speler("Korneel",1992,15);
        
//        spelernaamarray[0]=speler1.getNaam();
//        spelernaamarray[1]=speler2.getNaam();
//        spelernaamarray[2]=speler3.getNaam();
//        spelernaamarray[3]=speler4.getNaam();
        
        
        
        return spelernaamarray;
    }
    
}
