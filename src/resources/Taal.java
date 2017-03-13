package resources;

import java.util.Locale;
import java.util.ResourceBundle;


public class Taal 
{
    private static Locale current = new Locale("nl","NL");
    private static ResourceBundle messages = ResourceBundle.getBundle("resources.vertaling", current);
    
    public Taal(int taal)
    {
        
        switch(taal)
        {
            case 1 : current = new Locale("nl","NL");
            messages = ResourceBundle.getBundle("resources.vertaling", current);
            break;
            case 2 : current = new Locale("fr", "FR");
            messages = ResourceBundle.getBundle("resources.vertaling", current);
            break;
            case 3 : current = new Locale("en", "EN");
            messages = ResourceBundle.getBundle("resources.vertaling", current);
            break;
            default: current = new Locale("nl","NL");
            messages = ResourceBundle.getBundle("resources.vertaling", current);
        }
   }
    
    public static String geefVertaling(String key) 
    {
        return messages.getString(key);
    }
}
