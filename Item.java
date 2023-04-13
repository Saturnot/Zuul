/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    
    private int aWeight;
    private String aDescription;

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(final String pDescription, final int pWeight)
    {
        this.aDescription = pDescription;
        this.aWeight = pWeight;
    }
    
    public String getDescription(){return this.aDescription;}
    
    public int getWeight(){return this.aWeight;}
}
