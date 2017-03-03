package domein;

public class DomeinController {
    
    private SpelerRepository spelerrepo;
    
    public DomeinController(){
        spelerrepo = new SpelerRepository();
    }
    
    public void voegSpelerToe(String naam, int geboortejaar){
        
        spelerrepo.voegSpelerToe(naam, geboortejaar); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)
        
    }
    

    
 
}
