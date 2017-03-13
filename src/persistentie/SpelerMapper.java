package persistentie;

import domein.Speler;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {
    
    List<Speler> spelerlijst = new ArrayList<>();

    public SpelerMapper(){
    
    
        Speler speler1 = new Speler("Jan",1999,50);
        Speler speler2 = new Speler("Piet",1989,10);
        Speler speler3 = new Speler("Joris",1987,100);
        Speler speler4 = new Speler("Korneel",1992,15);
        
        spelerlijst.add(speler1);
        spelerlijst.add(speler2);
        spelerlijst.add(speler3);
        spelerlijst.add(speler4);
        
    
    }
    
    public void voegSpelerToe(Speler speler){
        spelerlijst.add(speler);
    }

//    public String[] geefAlleNamen(List<Speler> spelerlijst) {
//
//        String spelernaamarray[] = new String[10]; //voorlopig lengte op 10 ingesteld
//
//        for (int i = 0; i < spelerlijst.size(); i++) { //overloopt de spelerlijst
//            spelernaamarray[i] = spelerlijst.get(i).getNaam(); //steekt de naam van speler i in spelernaamarray[i]
//        }
//
//        return spelernaamarray;
//    }

    public List<Speler> getSpelerlijst() {
        return spelerlijst;
    }

}
