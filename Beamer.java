
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    private Room aFirstRoom; // where the beamer is used

    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer(String pDescription, int pWeight)
    {
        super(pDescription, pWeight);
    }

    public Room getFirstRoom()
    {
        return this.aFirstRoom;
    }
    
    public void setFirstRoom(Room pFirstRoom)
    {
        this.aFirstRoom = pFirstRoom;
    }
}
