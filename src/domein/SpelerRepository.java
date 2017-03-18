package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {
    
    public SpelerRepository(){
        
    
        
    }
    
    public void voegSpelerToe(String naam, int geboortejaar){
        
        SpelerMapper sm = new SpelerMapper();
        
        for(int i=0;i<sm.geefSpelers().size();i++){ //controleren of naam al bestaat
            if(naam.equals(sm.geefSpelers().get(i).getNaam()))
                throw new IllegalArgumentException("naam niet uniek");
        }
        
        Speler speler5 = new Speler(naam,geboortejaar,0);
        sm.voegToe(speler5);
        System.out.println(speler5);
        
    }
}
