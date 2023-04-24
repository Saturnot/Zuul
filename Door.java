
/**
 * Décrivez votre classe Door ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aKeyName;

    /**
     * Constructeur d'objets de classe Door
     */
    public Door(final String pKey)
    {
        this.aKeyName = pKey;
    }
    
    public String getKey()
    {
        return this.aKeyName;
    }
}
