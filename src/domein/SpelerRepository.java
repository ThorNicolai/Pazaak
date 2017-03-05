package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {
    
    public SpelerRepository(){
        
    
        
    }
    
    public void voegSpelerToe(String naam, int geboortejaar){
        SpelerMapper spelerMapper = new SpelerMapper();
        controleerNaamUniek(spelerMapper.geefAlleNamen(spelerMapper.spelers()), naam); 
        Speler speler5 = new Speler(naam,geboortejaar,5);
        System.out.println(speler5);
        
    }
    
    
    
    private void controleerNaamUniek(String[] spelernaamarray, String naam){
        
        for(int i=0; i<spelernaamarray.length;i++){                             //kan met enhanced for!!!!!
            if(naam.equals(spelernaamarray[i]))
                throw new IllegalArgumentException("Deze naam bestaat al!");
        }
    }
}
