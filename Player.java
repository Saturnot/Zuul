import java.util.Stack;
import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aCurrentRoom;
    private String aPlayerName;
    private Stack<Room> aPreviousRooms;
    private HashMap<String, Item> aInventory;

    /**
     * Constructeur d'objets de classe Player
     */
    public Player()
    {
        this.aPlayerName = "Jolan";
        this.aPreviousRooms = new Stack<Room>();
        this.aInventory = new HashMap<String, Item>();
    }
    
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
        
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }
    
    public void addNewPreviousRoom()
    {
        this.aPreviousRooms.addElement(this.aCurrentRoom);
    }
    
    public boolean isPreviousRoomsEmpty()
    {
        return this.aPreviousRooms.empty();
    }
    
    public void setCurrentRoomToPopPreviousRooms()
    {
        this.aCurrentRoom = this.aPreviousRooms.pop();
    }
    
    public Item getItem (final String pName)
    {
        return this.aInventory.get(pName);
    }
        
    public void take(final String pName)
    {
        this.aInventory.put(pName,this.aCurrentRoom.getItem(pName));
        this.aCurrentRoom.supItem(pName);
    }
    
    public void drop(final String pName)
    {
        this.aInventory.remove(pName);
        this.aCurrentRoom.addItem(pName, this.getItem(pName));
    }
    
    public String getDescriptionInventory()
    {
        String vDs = "Tu as : \n" ;
        Set<String> vKeys = this.aInventory.keySet();
        for ( String vS : vKeys )
        {
            vDs = " - " + vS+ "\n";
        }
        return vDs;
    }
}
