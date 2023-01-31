package v1;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Room
{   
    /// ATRIBUTS ///
    private String aDescription;
    public Room aNorthExit;
    public Room aEastExit;
    public Room aSouthExit;
    public Room aWestExit;
    /// CONSTRUCTEUR ///
    /**
    CONSTRUCTEUR DE LA CLASSE Room   
    */
    public Room(final String pDescriptionLieu)
    {
        this.aDescription = pDescriptionLieu;
    }
    
    /// ACCESSEUR ///
    public String getDescription(){ return this.aDescription; }
    
    /// MODIFICATEUR ///
    public void setExits(final Room pNorth, final Room pEast, final Room pSouth, final Room pWest)
    {
        this.aNorthExit = pNorth;
        this.aEastExit = pEast;
        this.aSouthExit = pSouth;
        this.aWestExit = pWest;
    }
} // Room
