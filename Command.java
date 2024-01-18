 
/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author 
 */
public class Command
{
    /// ATTRIBUTS ///
    private String aCommandWord;
    private String aSecondWord;
    
    /// CONSTRUCTEUR ///
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /// ACCESSEURS ///
    public String getCommandWord(){return this.aCommandWord;}
    public String getSecondWord(){return this.aSecondWord;}
    
    /// FCT hasSecondWord ///
    public boolean hasSecondWord()
    {
        return(this.getSecondWord() != null);
    }
    
    /// FCT isUnknown ///
    public boolean isUnknown()
    {
        return(this.getCommandWord() == null);
    }
} // Command
