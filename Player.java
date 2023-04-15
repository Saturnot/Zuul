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
    private ItemList aInventory;
    private int aMaxWeight;

    /**
     * Constructeur d'objets de classe Player
     */
    public Player()
    {
        this.aPlayerName = "Jolan";
        this.aPreviousRooms = new Stack<Room>();
        this.aInventory = new ItemList("Inventaire");
        this.aMaxWeight = 6000;
    }
    
    public void setMaxWeight(final int pNewMaxWeight)
    {
        this.aMaxWeight = pNewMaxWeight;
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
    
    public ItemList getInventory()
    {
        return this.aInventory;
    }
    
    public void take(final String pName)
    {
        this.aInventory.addItem(pName,this.aCurrentRoom.getItem(pName));
        this.aCurrentRoom.supItem(pName);
    }
    
    public void drop(final String pName)
    {
        this.aCurrentRoom.addItem(pName, this.aInventory.getItem(pName));
        this.aInventory.supItem(pName);
    }
    
    public String getInventoryDescription()
    {
        return this.aInventory.getItemsDescription()+"\nLe total des objets de votre inventaire est de : " + this.getInventoryWeight();
        
    }
    
    public int getInventoryWeight()
    {
        return this.aInventory.getItemListWeight();
    }
    
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }
}
