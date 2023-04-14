import java.util.Stack;

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

    /**
     * Constructeur d'objets de classe Player
     */
    public Player()
    {
        this.aPlayerName = "Jolan";
        this.aPreviousRooms = new Stack<Room>();
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
}
