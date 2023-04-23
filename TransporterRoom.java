
/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private RoomRandomizer aRoomRandomizer;

    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDescription, final String pImg)
    {
        // initialisation des variables d'instance
        super(pDescription, pImg);
        this.aRoomRandomizer = new RoomRandomizer ();
    }

    @Override public Room getExit (final String pDirection)
    {
        return this.aRoomRandomizer.getRandomRoom();
    }
    
    public RoomRandomizer getRoomRandomizer()
    {
        return this.aRoomRandomizer;
    }
}
