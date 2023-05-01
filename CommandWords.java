 /**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    String[] vInventaire = {"inventaire","inventory",""};
    String[] vAller = {"aller","go",""};
    String[] vQuitter = {"quitter","quit",""};
    String[] vAide = {"aide","help",""};
    String[] vRegarder = {"regarder","look",""};
    String[] vManger = {"manger","eat",""};
    String[] vRetour = {"retour","back",""};
    String[] vPrendre = {"prendre","take",""};
    String[] vLacher = {"lacher","drop",""};
    String[] vCarte = {"carte","map",""};
    String[] vUtiliser = {"utiliser","use",""};
    String[] vParler = {"parler","talk",""};
    
    
    private final String[] aValidCommands = {
        vInventaire[Player.aLanguage], vAller[Player.aLanguage], vQuitter[Player.aLanguage], vAide[Player.aLanguage], vRegarder[Player.aLanguage], vManger[Player.aLanguage], vRetour[Player.aLanguage], "test", vPrendre[Player.aLanguage], vLacher[Player.aLanguage], vCarte[Player.aLanguage], vUtiliser[Player.aLanguage], "cheat-code", vParler[Player.aLanguage]};

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<this.aValidCommands.length; vI++ ) {
            if ( this.aValidCommands[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()
    
    public String getCommandList()
    {
        String vList = "";
        for(String command : this.aValidCommands)
        {
            vList += command + " ";
        }
        return vList;
    }
} // CommandWords