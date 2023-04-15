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
    private String aDescription;
    private HashMap<String, Room> aExits;
    private HashMap<String,Item> aItemList;
    private String aImageName;
    
    /// CONSTRUCTEUR ///
    /**
     * Constructor of the Room class
     * @param string description of the room
    */
    public Room(final String pDescriptionLieu, final String pImage)
    {
        this.aDescription = pDescriptionLieu;
        this.aExits = new HashMap<String, Room>();
        this.aItemList = new HashMap<String, Item>();
        this.aImageName = pImage;
    }//Room
    
    /// ACCESSEUR ///
    /**
     * getter description
     * @return description of a room
     */
    public String getDescription(){ return this.aDescription; }//getDescription
    
    /// MODIFICATEUR ///
    /**
     * seter
     * @param String of a direction and Room of the neighbor room
     */
    public void setExits(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }//setExits
    
    public void addItem(final String pName, final Item pItem)
    {
        this.aItemList.put(pName, pItem);
    }
    
    public Item getItem(final String pItemName)
    {
        return this.aItemList.get(pItemName);
    }
    
    public void supItem(final String pItemName)
    {
        this.aItemList.remove(pItemName);
    }
    
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
    
    public String getItemDescription()
    {
        String vItemDescription = "Les objets sont : \n";
        Set<String> vKeys = this.aItemList.keySet();
        for(String vItem : vKeys)
        {
            vItemDescription += " " + vItem + "\n"; 
        }//for
        return vItemDescription;
    }
    
    /**
     * method that 
     * @return a String with the description of the room and the exits
     */
    public String getLongDescription()
    {
        return this.aDescription + "\n" + this.getExitString() + "\n" + this.getItemDescription();
    }//getLongDescription
    
    /**
     * 
     */
    public String getImageName()
    {
        return this.aImageName;
    }
} // Room
