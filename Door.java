
/**
 * Décrivez votre classe Door ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private boolean aOpen;
    private String aKeyName;

    /**
     * Constructeur d'objets de classe Door
     */
    public Door(final String pKey)
    {
        this.aKeyName = pKey;
        this.aOpen = false;
    }
    
    public Door()
    {
        this.aKeyName = null;
        this.aOpen = false;
    }
    
    public String getKey()
    {
        return this.aKeyName;
    }
    
    public boolean isOpen()
    {
        return this.aOpen;
    }
    
    public void setOpen(final boolean pBool)
    {
        this.aOpen = pBool;
    }
}
