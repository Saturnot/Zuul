import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private List<Room> aRoomsList;
    private Random aRandom;
    
    /**
     * Constructeur d'objets de classe RoomRandomizer
     */
    public RoomRandomizer()
    {
        this.aRoomsList = new ArrayList<Room>();
        this.aRandom = new Random ();
    }

    public void addRoom (final Room pRoom)
    {
        this.aRoomsList.add(pRoom);
    }
    
    public Room getRandomRoom ()
    {
        int vRandom = this.aRandom.nextInt(this.aRoomsList.size());
        return this.aRoomsList.get(vRandom);
    }
}
