
/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GameEngine
{
    /// ATTRIBUTS ///
    private Room aCurrentRoom;
    private Parser aParser;
    private UserInterface aGui;
    
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
    }
    
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }
    
    /// createRooms
    /**
     * creer les salles et initaliser la première salle.
     * 
     */
    private void createRooms()
    {
        Room vDodo0 = new Room("vDodo0", "img/dodo-soldat.png");
        Room vT1 = new Room("vT1", "img/unknow.png");
        Room vT2 = new Room("vT2", "img/unknow.png");
        Room vT3 = new Room("vT3", "img/unknow.png");
        Room vT4 = new Room("vT4", "img/unknow.png");
        Room vCDS1 = new Room("vCDS1", "img/unknow.png");
        Room vCDS2 = new Room("vCDS2", "img/unknow.png");
        Room vCDS3 = new Room("vCDS3", "img/unknow.png");
        Room vCDS4 = new Room("vCDS4", "img/unknow.png");
        Room vCDS5 = new Room("vCDS5", "img/unknow.png");
        Room vCDS6 = new Room("vCDS6", "img/unknow.png");
        Room vCDS7 = new Room("vCDS7", "img/unknow.png");
        Room vQG = new Room("vQG", "img/unknow.png");
        Room vT5 = new Room("vT5", "img/unknow.png");
        Room vT6 = new Room("vT6", "img/unknow.png");
        Room vT7 = new Room("vT7", "img/unknow.png");
        Room vT8 = new Room("vT8", "img/unknow.png");
        Room vT9 = new Room("vT9", "img/unknow.png");
        Room vT10 = new Room("vT10", "img/unknow.png");
        Room vT11 = new Room("vT11", "img/unknow.png");
        Room vDepartAvion = new Room("vDepartAvion", "img/unknow.png");
        Room vArriveAvion = new Room("vArriveAvion", "img/unknow.png");
        Room vInterrieurAvion = new Room("vInterrieurAvion", "img/unknow.png");
        Room vImpossible1 = new Room("vImpossible1", "img/unknow.png");
        Room vGauche = new Room("vGauche", "img/unknow.png");
        Room vDroite = new Room("vDroite", "img/unknow.png");
        
        // vsalle.setExits(nord, est, sud, ouest);
        vDodo0.setExits("est", vT1);
        vT1.setExits("est", vT2);
        vT1.setExits("sud", vCDS1);
        vT1.setExits("ouest", vDodo0);
        vT2.setExits("est", vT3);
        vT2.setExits("ouest", vT1);
        vT3.setExits("nord", vCDS2);
        vT3.setExits("est", vT4);
        vT3.setExits("sud", vQG);
        vT3.setExits("ouest", vT2);
        vT4.setExits("est", vT5);
        vT4.setExits("ouest", vT3);
        vCDS1.setExits("nord", vT1);
        vCDS2.setExits("nord", vCDS3);
        vCDS2.setExits("est", vCDS4);
        vCDS2.setExits("sud", vT3);
        vCDS3.setExits("est", vCDS2);
        vCDS4.setExits("ouest", vCDS2);
        vCDS5.setExits("sud", vT5);
        vCDS6.setExits("ouest", vT5);
        vCDS7.setExits("ouest", vT6);
        vQG.setExits("nord", vT3);
        vT5.setExits("nord", vCDS5);
        vT5.setExits("est", vCDS6);
        vT5.setExits("sud", vT6);
        vT5.setExits("ouest", vT4);
        vT6.setExits("nord", vT5);
        vT6.setExits("est", vCDS7);
        vT7.setExits("sud", vT6);
        vT7.setExits("est", vT8);
        vT8.setExits("ouest", vT7);
        vT8.setExits("sud", vT9);
        vT9.setExits("nord", vT8);
        vT9.setExits("est", vDepartAvion);
        vT9.setExits("sud", vImpossible1);
        vT10.setExits("nord", vArriveAvion);
        vT10.setExits("est", vDroite);
        vT10.setExits("ouest", vGauche);
        vDepartAvion.setExits("est", vInterrieurAvion);
        vDepartAvion.setExits("ouest", vT9);
        vArriveAvion.setExits("est", vT10);
        vArriveAvion.setExits("ouest", vInterrieurAvion);
        vInterrieurAvion.setExits("est", vArriveAvion);
        vInterrieurAvion.setExits("ouest", vDepartAvion);
        vImpossible1.setExits("nord", vT9);
        vGauche.setExits("est", vT10);
        vDroite.setExits("ouest", vT10);

        this.aCurrentRoom = vDodo0;
    }//createRooms
    
    /**
     * Print the first txt the user see and print the info of the first Room
     */
    private void printWelcome()  // doit être privé
    {
        this.aGui.println("Soldat: Soldat !");
        this.aGui.println("Soldat: Soldat ! Réveille toi ! Le superieur veux te parler, suis-moi.");
        this.aGui.println("Ecris 'aide' si tu as besoin d'un coup de main.");
        this.aGui.println(" ");
        this.aGui.println( this.aCurrentRoom.getLongDescription() );
        if ( this.aCurrentRoom.getImageName() != null )
            this.aGui.showImage( this.aCurrentRoom.getImageName() );
    }//printWelcome
    
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "aide" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "aller" ) )
            this.goRoom( vCommand );
        else if ( vCommandWord.equals( "quitter" ) ) {
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        }
    }
    
    
    //USER COMMANDS
    
    /**
     * print a help msg to the user
     */
    private void printHelp() // doit être privé
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.");
        System.out.println(" ");
        System.out.println("Vos commandes sont : "+this.aParser.getCommandString());
    }//printHelp
        
    /**
     * to move to an other room
     * @param the command
     */
    private void goRoom(final Command pCommand) //doit être privé
    {
        if (!pCommand.hasSecondWord())
        {
            System.out.println("Aller où ?");
            return;
        }//if
        
        String vDirection = pCommand.getSecondWord();
        
        
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        
        if (vNextRoom == null)
        {
            this.aGui.println( "Il n'y a rien ici !" );
        }//if
        else
        {
            this.aCurrentRoom = vNextRoom;
            this.aGui.println( this.aCurrentRoom.getLongDescription() );
            if ( this.aCurrentRoom.getImageName() != null )
                this.aGui.showImage( this.aCurrentRoom.getImageName() );
        }//else
    }//goRoom
    
    /**
     * method to look
     * print the LongDescription
     */
    private void look()
    {
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    /**
     * method to eat
     */
    private void eat()
    {
        System.out.println("Tu viens de manger tu n'as pas faim");
    }
    
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
    
}