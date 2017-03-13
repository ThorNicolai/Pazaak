package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {
    
    public SpelerRepository(){
        
    
        
    }
    
    public void voegSpelerToe(String naam, int geboortejaar){
        
        SpelerMapper sm = new SpelerMapper();
        
        for(int i=0;i<sm.getSpelerlijst().size();i++){ //controleren of naam al bestaat
            if(naam.equals(sm.getSpelerlijst().get(i).getNaam()))
                throw new IllegalArgumentException("naam niet uniek");
        }
        
        Speler speler5 = new Speler(naam,geboortejaar,5);
        sm.voegSpelerToe(speler5);
        System.out.println(speler5);
        
    }
}
