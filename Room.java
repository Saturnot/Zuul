import java.util.HashMap;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author ROUSTANT Jolan
 */
public class Room
{   
    /// ATRIBUTS ///
    public String aDescription;
    private HashMap<String, Room> exits;
    
    /// CONSTRUCTEUR ///
    /**
    CONSTRUCTEUR DE LA CLASSE Room   
    */
    public Room(final String pDescriptionLieu)
    {
        this.aDescription = pDescriptionLieu;
        exits = new HashMap<String, Room>();
    }
    
    /// ACCESSEUR ///
    public String getDescription(){ return this.aDescription; }
    
    /// MODIFICATEUR ///
    public void setExits(final String pDirection,final Room pNeighbor)
    {
        this.exits.put(pDirection, pNeighbor);
    }
    
    public Room getExit(String pDirection)
    {
        return exits.get(pDirection);
    }
    
    public String getExitString()
    {
        String vExitsList = "Les sorties visibles ici sont : ";
        if(this.getExit("nord")!=null)
        {
            vExitsList +="nord ";
        }
        if(this.getExit("est")!=null)
        {
            vExitsList +="est ";
        }
        if(this.getExit("sud")!=null)
        {
            vExitsList +="sud ";
        }
        if(this.getExit("ouest")!=null)
        {
            vExitsList +="ouest ";
        }
        return vExitsList;
    }
} // Room
