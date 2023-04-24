/**
 * Décrivez votre classe Character ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Character
{
    private String aName;
    private String aDescription;
    private String[] aSentences;

    /**
     * Constructeur d'objets de classe Character
     */
    public Character(final String pName, final String pDescription, final String[] pSentences)
    {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aSentences = pSentences;
    }
    
    public String getSentence(final int pNumber)
    {
        if(pNumber >= 0 && pNumber <= this.aSentences.length - 1)
        {
            return this.aSentences[pNumber];
        }
        else
        {
            return null;
        }
    }
}
