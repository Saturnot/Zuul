import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe ItemList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashMap <String, Item> aItems;
    private String aLocation;

    /**
     * Constructeur d'objets de classe ItemList
     */
    public ItemList(final String pLocation)
    {
        this.aItems = new HashMap <String, Item>();
        this.aLocation = pLocation;
    }

    public Item getItem(final String pItem)
    {
        return this.aItems.get(pItem);
    }
    
    public HashMap <String, Item> getItems()
    {
        return this.aItems;
    }
    
    public String getItemsDescription()
    {
        if(this.aItems.isEmpty())
        {
            String[] vS = {
                "Il n'y a pas d'objet dans " + this.aLocation,
                "There is no object in " + this.aLocation,
                ""
            };
            return vS[Player.aLanguage];
        }
        String[] vString = {"Objets dans " + this.aLocation + " :", "Objects in " + this.aLocation + ":", ""};
        Set<String> vKeys = this.aItems.keySet();
        for(String vS : vKeys)
        {
            vString[Player.aLanguage] += "\n - " + vS;
        }
        return vString[Player.aLanguage];
    }
    
    public void addItem(final String pName, final Item pItem){
        this.aItems.put(pName, pItem);
    }
    
    public void supItem (final String pName){
        this.aItems.remove(pName);
    }
    
    public int getItemListWeight()
    {
        if(this.aItems.isEmpty())
        {
            return 0;
        }
        int vWeight = 0;
        Set<String> vKeys = this.aItems.keySet();
        for(String vS : vKeys)
        {
            vWeight += this.getItem(vS).getWeight();
        }
        return vWeight;
    }
    
}
