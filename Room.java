import java.util.HashMap;
import java.util.Set;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author
 */
public class Room
{   
    /// ATRIBUTS ///
    private String aDescription;
    private HashMap<String, Room> aExits;
    private HashMap<String, Door> aDoors;
    private HashMap<String,Item> aItemList;
    private HashMap<String,Character> aNPCList;
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
        this.aDoors = new HashMap<String, Door>();
        this.aItemList = new HashMap<String, Item>();
        this.aNPCList = new HashMap<String, Character>();
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
    
    public void setDoors(final String pDirection,final Door pNeighbor)
    {
        this.aDoors.put(pDirection, pNeighbor);
    }
    
    public Door getDoor(String pDirection)
    {
        return this.aDoors.get(pDirection);
    }
    
    
    //   ITEM   //
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
    
    // NPC   ///
    
    public void addNPC(final String pName, final Character pCharacter)
    {
        this.aNPCList.put(pName, pCharacter);
    }
    
    public Character getNPC(final String pCharacterName)
    {
        return this.aNPCList.get(pCharacterName);
    }
    
    public void supNPC(final String pCharacterName)
    {
        this.aNPCList.remove(pCharacterName);
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
    
    public boolean isExit(final Room pRoom)
    {
        if(this.aExits.containsValue(pRoom))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * getter exit Sting
     * @return String list exits
     */
    public String getExitString()
    {
        String[] vExitsList = {"Les sorties visibles ici sont : \n","The exits visible here are : \n",""};
        Set<String> vKeys = this.aExits.keySet();
        for(String exit : vKeys)
        {
            vExitsList[Player.aLanguage] += "-" + exit + "\n"; 
        }//for
        return vExitsList[Player.aLanguage];
    }//getExitString
    
    public String getItemDescription()
    {
        if(this.aItemList.isEmpty())
        {
            return "";
        }
        String[] vItemDescription = {"Les objets présents sont : \n","The objects present are : \n",""};
        Set<String> vKeys = this.aItemList.keySet();
        for(String vItem : vKeys)
        {
            vItemDescription[Player.aLanguage] += "-" + vItem + "\n"; 
        }//for
        return vItemDescription[Player.aLanguage];
    }
    
    public String getNPCDescription()
    {
        if(this.aNPCList.isEmpty())
        {
            return "";
        }
        String[] vNPCDescription = {"Les personages présents sont : \n", "The persons present are : \n",""};
        Set<String> vKeys = this.aNPCList.keySet();
        for(String vNPC : vKeys)
        {
            vNPCDescription[Player.aLanguage] += "-" + vNPC + "\n"; 
        }//for
        return vNPCDescription[Player.aLanguage];
    }
    
    /**
     * method that 
     * @return a String with the description of the room and the exits
     */
    public String getLongDescription()
    {
        return this.aDescription + "\n" + this.getExitString() + "\n" + this.getItemDescription() + this.getNPCDescription() + "\n";
    }//getLongDescription
    
    /**
     * 
     */
    public String getImageName()
    {
        return this.aImageName;
    }
} // Room
