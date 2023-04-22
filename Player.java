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
    private int aNbOfMove; //To do a time limit with no real time
    private int aNbMaxOfMove; //To do a time limit with no real time
    
    /**
    Constructs a Player object with default values.
    */
    public Player()
    {
        this.aPlayerName = "Jolan";
        this.aPreviousRooms = new Stack<Room>();
        this.aInventory = new ItemList("Inventaire");
        this.aMaxWeight = 6000;
        this.aNbOfMove = 0;
        this.aNbMaxOfMove = 30;
    }
    
    public void incrementNbOfMove()
    {
        this.aNbOfMove = this.aNbOfMove + 1;
    }
    
    public boolean isTimeOver()
    {
        return (this.aNbOfMove == this.aNbMaxOfMove);
    }
    
    public int getNbOfMove()
    {
        return this.aNbOfMove;
    }
    
    /**

    Sets the maximum weight the player can carry.
    @param pNewMaxWeight the new maximum weight
    */
    public void setMaxWeight(final int pNewMaxWeight)
    {
        this.aMaxWeight = pNewMaxWeight;
    }
    
    /**

    Returns the current room the player is in.
    @return the current room the player is in
    */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**

    Sets the current room the player is in.
    @param pCurrentRoom the new current room
    */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }
    
    /**
    Adds the current room to the stack of previous rooms.
    */
    public void addNewPreviousRoom()
    {
        this.aPreviousRooms.addElement(this.aCurrentRoom);
    }
    
    /**
    Returns true if the stack of previous rooms is empty, false otherwise.
    @return true if the stack of previous rooms is empty, false otherwise
    */
    public boolean isPreviousRoomsEmpty()
    {
        return this.aPreviousRooms.empty();
    }
    
    /**
    Sets the current room to the previous room on the stack.
    */
    public void setCurrentRoomToPopPreviousRooms()
    {
        this.aCurrentRoom = this.aPreviousRooms.pop();
    }
    
    /**
    Returns the player's inventory.
    @return the player's inventory
    */
    public ItemList getInventory()
    {
        return this.aInventory;
    }
    
    /**
    Takes an item from the current room and adds it to the player's inventory.
    @param pName the name of the item to take
    */
    public void take(final String pName)
    {
        this.aInventory.addItem(pName,this.aCurrentRoom.getItem(pName));
        this.aCurrentRoom.supItem(pName);
    }
    
    /**
    Drops an item from the player's inventory and adds it to the current room.
    @param pName the name of the item to drop
    */
    public void drop(final String pName)
    {
        this.aCurrentRoom.addItem(pName, this.aInventory.getItem(pName));
        this.aInventory.supItem(pName);
    }
    
    /**
    Returns a string describing the player's inventory and the total weight of the items.
    @return a string describing the player's inventory and the total weight
    */
    public String getInventoryDescription()
    {
        return this.aInventory.getItemsDescription()+"\nLe total des objets de votre inventaire est de : " + this.getInventoryWeight();
        
    }
    
    /**
    Returns a int of the inventory weight.
    @returns a int of the inventory weight
    */
    public int getInventoryWeight()
    {
        return this.aInventory.getItemListWeight();
    }
    
    /**
    Returns a int of the max inventory weight.
    @returns a int of the max inventory weight
    */
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }
}
