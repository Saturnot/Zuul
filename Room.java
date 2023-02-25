import java.util.HashMap;
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
     * Constructor of the Room class
     * @param string description of the room
    */
    public Room(final String pDescriptionLieu)
    {
        this.aDescription = pDescriptionLieu;
        aExits = new HashMap<String, Room>();
    }//Room
    
    /// ACCESSEUR ///
    /**
     * getter description
     * @return description of a room
     */
    public String getDescription(){ return this.aDescription; }//getDescription
    
    /// MODIFICATEUR ///
    /**
     * setter
     * @param String of a direction and Room of the neighbor room
     */
    public void setExits(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }//setExits
    
    /**
     * getter exit
     * @param String of a direction
     * @return direction of a exit
     */
    public Room getExit(String pDirection)
    {
        return this.aExits.get(pDirection);
    }//getExit
    
    /**
     * getter exit Sting
     * @return String list exits
     */
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
    
    /**
     * method that 
     * @return a String with the description of the room and the exits
     */
    public String getLongDescription()
    {
        return this.aDescription + "\n" + this.getExitString();
    }//getLongDescription
} // Room
