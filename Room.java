import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author ROUSTANT Jolan
 */
public class Room
{   
    /// ATRIBUTS ///
    public String aDescription;
    private HashMap<String, Room> aExits;
    
    /// CONSTRUCTEUR ///
    /**
    CONSTRUCTEUR DE LA CLASSE Room   
    */
    public Room(final String pDescriptionLieu)
    {
        this.aDescription = pDescriptionLieu;
        aExits = new HashMap<String, Room>();
    }//Room
    
    /// ACCESSEUR ///
    public String getDescription(){ return this.aDescription; }//getDescription
    
    /// MODIFICATEUR ///
    public void setExits(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }//setExits
    
    public Room getExit(String pDirection)
    {
        return this.aExits.get(pDirection);
    }//getExit
    
    public String getExitString()
    {
        String vExitsList = "Les sorties visibles ici sont : ";
        Set<String> vKeys = this.aExits.keySet();
        for(String exit : vKeys)
        {
            vExitsList += " " + exit; 
        }//for
        return vExitsList;
    }//getExitString
} // Room
