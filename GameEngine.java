import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GameEngine
{
    /// ATTRIBUTS ///
    private Parser aParser;
    private UserInterface aGui;
    private Player aMainPlayer;
    private boolean aMapAff;
    private HashMap <String, Room> aRoomsList;
    
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aMainPlayer = new Player();
        this.aRoomsList = new HashMap <String, Room> ();
        this.createRooms();
        this.aMapAff = false;
    }
    
    /**
     * Sets the user interface and prints welcome message.
     * 
     * @param pUserInterface user interface to be set
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }
    
    /**
     * Creates rooms and initializes the first room.
     * 
     */
    private void createRooms()
    {
        Room vDodo0 = new Room("C'est ta chambre, c'est un peu petit et tu dois la partager avec 7 autres soldats.", "img/dodo-soldat.png");
        Room vT1 = new Room("Tu vois la lumière du jour, le soleil t'aveugle et la boue te glace les pieds. Tu dois suivre ton compagnon.", "img/debut.png");
        Room vT3 = new Room("Le QG est au sud, c'est pas si loin.\nIl y a un soldat:\nSoldat inconnu: 'Salut, au sud se trouve les quartiers des superieurs, au nord tu trouveras l'infirmerie et les tranchées se poursuivent à l'est.'", "img/T3.png");
        Room vT4 = new Room("Une tranchée vide.", "img/T2.png");
        Room vT5 = new Room("", "img/T5.png");
        Room vT6 = new Room("Il y a eu un éboulement, il faut quelque chose pour débloquer le chemin.", "img/tranche2.png");
        Room vT7 = new Room("", "img/T2.png");
        Room vT9 = new Room("", "img/tranche3.png");
        Room vT10 = new Room("", "img/T10.png");
        Room vT11 = new Room("", "img/T11.png");
        Room vCDS1 = new Room("Tu ne peux pas aller plus loin au risque de déserter.", "img/tranche4.png");
        Room vCDS3 = new Room("C'est l'infirmerie.", "img/infirmerie.png");
        Room vCDS4 = new Room("Tu es dans une tranchée secondaire, en dessous de la surface. Il y a un soldat seul.", "img/dessous.png");
        Room vCDS5 = new Room("", "img/dyna.png");
        Room vCDS6 = new Room("", "img/shovel.png");
        Room vQG = new Room("Tu es dans les quartiers des supérieurs, ton chef t'attend.", "img/reu.png");
        Room vDepartAvion = new Room("", "img/avion-depart.png");
        Room vArriveAvion = new Room("", "img/avion-arrive.png");
        Room vInterrieurAvion = new Room("", "img/avion-vole.png");
        Room vDroite = new Room("", "img/unknow.png");
        Room vEchelle1 = new Room("", "img/echelle.png");
        
        //put rooms to hashmap
        this.aRoomsList.put("Dodo0", vDodo0);
        this.aRoomsList.put("T1", vT1);
        this.aRoomsList.put("T3", vT3);
        this.aRoomsList.put("T4", vT4);
        this.aRoomsList.put("T5", vT5);
        this.aRoomsList.put("T6", vT6);
        this.aRoomsList.put("T7", vT7);
        this.aRoomsList.put("T9", vT9);
        this.aRoomsList.put("T10", vT10);
        this.aRoomsList.put("T11", vT11);
        this.aRoomsList.put("CDS1", vCDS1);
        this.aRoomsList.put("CDS3", vCDS3);
        this.aRoomsList.put("CDS4", vCDS4);
        this.aRoomsList.put("CDS5", vCDS5);
        this.aRoomsList.put("CDS6", vCDS6);
        this.aRoomsList.put("QG", vQG);
        this.aRoomsList.put("DepartAvion", vDepartAvion);
        this.aRoomsList.put("ArriveAvion", vArriveAvion);
        this.aRoomsList.put("InterrieurAvion", vInterrieurAvion);
        this.aRoomsList.put("Droite", vDroite);
        this.aRoomsList.put("Echelle1", vEchelle1);

        //set exits
        vDodo0.setExits("est", vT1);
        vT1.setExits("est", vT3);
        vT1.setExits("sud", vCDS1);
        vT1.setExits("ouest", vDodo0);
        vT3.setExits("nord", vCDS3);
        vT3.setExits("est", vT4);
        vT3.setExits("sud", vQG);
        vT3.setExits("ouest", vT1);
        vT3.setExits("haut", vEchelle1);
        vT3.setExits("bas", vCDS4);
        vT4.setExits("est", vT5);
        vT4.setExits("ouest", vT3);
        vCDS1.setExits("nord", vT1);
        vCDS3.setExits("sud", vT3);
        vCDS4.setExits("haut", vT3);
        vCDS5.setExits("sud", vT5);
        vCDS6.setExits("ouest", vT5);
        vQG.setExits("nord", vT3);
        vT5.setExits("nord", vCDS5);
        vT5.setExits("est", vCDS6);
        vT5.setExits("sud", vT6);
        vT5.setExits("ouest", vT4);
        vT6.setExits("nord", vT5);
        vT6.setExits("ouest", vT7);
        vT7.setExits("sud", vT9);
        vT7.setExits("est", vT6);
        vT9.setExits("nord", vT7);
        vT9.setExits("est", vDepartAvion);
        vT10.setExits("nord", vArriveAvion);
        vT10.setExits("est", vDroite);
        vT10.setExits("ouest", vT11);
        vT11.setExits("est", vT10);
        vDepartAvion.setExits("est", vInterrieurAvion);
        vDepartAvion.setExits("ouest", vT9);
        vArriveAvion.setExits("sud", vT10);
        vArriveAvion.setExits("ouest", vInterrieurAvion);
        vInterrieurAvion.setExits("est", vArriveAvion);
        // vInterrieurAvion.setExits("ouest", vDepartAvion);
        vDroite.setExits("ouest", vT10);
        vEchelle1.setExits("bas", vT3);
        
        Item vPelle = new Item("une pelle qui creuse", 2310);
        vCDS6.addItem("pelle", vPelle);
        Item vDynamite = new Item("un bâton de dynamite", 1000);
        vCDS5.addItem("dynamite", vDynamite);
        
        Item vMoteur = new Item("Une pièce de moteur qui a l'air cassée", 62000);
        vT7.addItem("moteur d'avion", vMoteur);
        
        Item vLettre = new Item("Une lettre importante", 10);
        vQG.addItem("Lettre", vLettre);
        
        Item vFusil = new  Item("votre arme", 3000);
        vDodo0.addItem("fusil", vFusil);
        Item vNourriture = new Item("De la viande en conserve, ça peut vous rendre plus fort", 200);
        vDodo0.addItem("boite de singe", vNourriture);
        //Beamer vBeamer = new  Beamer("Un téléporteur ", 1);
        //vDodo0.addItem("beamer", vBeamer);
        
        Item vCarte = new  Item("Une carte qui affiche une partie des tranchées", 10);
        vCDS4.addItem("carte", vCarte);
        
        Item vBrouette = new Item("Une brouette qui augmente la taille de l'inventaire. ('utiliser brouette' pour activer son effet)", 5000);
        vDepartAvion.addItem("brouette", vBrouette);
        
        this.aMainPlayer.setCurrentRoom(vDodo0);
    }//createRooms
    
    /**
     * Print the first txt the user see and print the info of the first Room
     */
    private void printWelcome()  // doit être privé
    {
        this.aGui.println("Soldat: Soldat !");
        this.aGui.println("Soldat: Soldat ! Réveille toi ! Le superieur veut te parler, suis-moi.");
        this.aGui.println("Ecris 'aide' si tu as besoin d'un coup de main.");
        this.aGui.println(" ");
        this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
    }//printWelcome
    
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( " -- " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() )
        {
            this.aGui.println( "Cette commande n'existe pas." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "aide" ) )
        {
            this.printHelp();
        }
        if ( vCommandWord.equals( "map" ) )
        {
            this.map();
        }
        if ( vCommandWord.equals( "manger" ) )
        {
            if(!vCommand.hasSecondWord())
            {
                this.aGui.println("Tu veux manger quoi ? Tappe 'manger [ce que tu veux manger].");
            }
            else
            {
                this.eat(vCommand);
            }
        }
        else if ( vCommandWord.equals( "aller" ) )
        {
            this.goRoom(vCommand);
        }
        else if ( vCommandWord.equals( "cheat-code" ) )
        {
            this.cheat(vCommand);
        }
        else if (vCommandWord.equals("retour"))
        {
            if(vCommand.hasSecondWord())
            {
                this.aGui.println("Tu peux juste retourner sur tes pas.");
            }
            else
            {
                this.back();
            }
        }
        else if (vCommandWord.equals("prendre"))
        {
            if(vCommand.hasSecondWord())
            {
                this.take(vCommand);
            }
            else
            {
                this.aGui.println("Que veux-tu prendre ?");
            }
        }
        else if (vCommandWord.equals("utiliser"))
        {
            if(vCommand.hasSecondWord())
            {
                this.use(vCommand);
            }
            else
            {
                this.aGui.println("Que veux-tu utiliser ?");
            }
        }
        else if (vCommandWord.equals("lacher"))
        {
            if(vCommand.hasSecondWord())
            {
                this.drop(vCommand);
            }
            else
            {
                this.aGui.println("Que veux-tu lacher ?");
            }
        }
        else if (vCommandWord.equals("test"))
        {
            this.test(vCommand.getSecondWord());
        }
        else if (vCommandWord.equals("inventaire"))
        {
            this.inventory();
        }
        else if (vCommandWord.equals("regarder"))
        {
            this.look();
        }
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
        this.aGui.println("Tu es un soldat, on est en 1915. Tu dois transmettre un message avant qu'il ne soit trop tard");
        this.aGui.println(" ");
        this.aGui.println("Vos commandes sont : "+this.aParser.getCommandString());
    }//printHelp
        
    /**
     * to move to an other room
     * @param the command
     */
    private void goRoom(final Command pCommand) //doit être privé
    {
        if (!pCommand.hasSecondWord())
        {
            this.aGui.println("Aller où ?");
            return;
        }//if
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aMainPlayer.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null)
        {
            this.aGui.println( "Il n'y a rien ici !" );
        }//if
        else
        {
            this.aMainPlayer.addNewPreviousRoom();
            this.aMainPlayer.setCurrentRoom(vNextRoom);
            this.aMapAff = false; // to do the map working
            
            this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
            if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
                this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
                
            this.aMainPlayer.incrementNbOfMove(); // add 1 to the nb of move
            if (this.aMainPlayer.isTimeOver())
            {
                this.gameOver();
            }
        }//else
    }//goRoom
    
    private void cheat(final Command pCommand)
    {
        String cheatCode = pCommand.getSecondWord();
        try
        {
            int vCode = Integer.parseInt(cheatCode);
            switch(vCode)
            {
                case 1:
                    Beamer vBeamer = new  Beamer("Un téléporteur ", 1);
                    this.aMainPlayer.getInventory().addItem("beamer", vBeamer);
                    this.aGui.println("Vous avez utilisez le code de triche numéro 1, vous avez optenu un téléporteur (beamer)!");
                    this.aGui.println(this.aMainPlayer.getInventoryDescription());
                    break;    
                default:
                    this.aGui.println("Ce code de triche n'existe pas");
            }
        }
        catch (NumberFormatException e)
        {
            this.aGui.println("Le code doit être un nombre.");
        }
    }
    
    /**
     * method to look
     * print the LongDescription
     */
    private void look()
    {
        this.aGui.println(this.aMainPlayer.getCurrentRoom().getLongDescription());
    }
    
    /**
     * method to eat
     */
    private void eat(final Command pCommand)
    {
        String vNourriture = pCommand.getSecondWord();
        if(this.aMainPlayer.getInventory().getItem(vNourriture) == null)
        {
            this.aGui.println("Tu n'as pas ça sur toi !");
            return;
        }
        if(!vNourriture.equals("nourriture"))
        {
            this.aGui.println("Tu ne peux pas manger ça !");
            return;
        }
        this.aMainPlayer.getInventory().supItem(vNourriture);
        this.aMainPlayer.setMaxWeight(this.aMainPlayer.getMaxWeight() + 2000);     
        this.aGui.println("Tu as manger un peu de nourriture, tu peux donc porter plus de chose");
    }
    
    private void use(final Command pCommand)
    {
        String vObject = pCommand.getSecondWord();
        if(vObject.equals("beamer"))
        {
            if(this.aMainPlayer.getInventory().getItem(vObject) == null)
            {
                this.aGui.println("Tu n'as pas ça sur toi !");
                return;
            }
            else
            {
                Beamer vBeamer = (Beamer)this.aMainPlayer.getInventory().getItem(vObject);
                if (vBeamer.getFirstRoom() == null)
                {
                    this.aGui.println("Tu charges ton téléporteur...");
                    vBeamer.setFirstRoom(this.aMainPlayer.getCurrentRoom());
                    this.aGui.println("Ton téléporteur est prêt à être utilisé!");
                    return;
                }
                if (vBeamer.getFirstRoom() != null)
                {
                    this.aMainPlayer.addNewPreviousRoom();
                    this.aMainPlayer.setCurrentRoom(vBeamer.getFirstRoom());
                    this.aGui.println("Ton téléporteur vient d'être utilisé!");
                    this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
                    if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
                        this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
                    vBeamer.setFirstRoom(null);
                    return;
                }
            }
        }
        else
        {
            this.aGui.println("Tu ne peux rien faire avec cet objet");
        }
    }
    
    private void map()
    {
        if(this.aMainPlayer.getInventory().getItem("carte") != null)
        {
            if(this.aMapAff == true)
            {
                this.aGui.showImage(this.aMainPlayer.getCurrentRoom().getImageName());
                this.aMapAff = false;
            }
            else
            {
                this.aGui.showImage("img/map.png");
                this.aMapAff = true;
            }
        }
        else
        {
            this.aGui.println("tu n'as pas de carte");
        }
    }
    
    private void back()
    {
        if(this.aMainPlayer.isPreviousRoomsEmpty())
        {
            this.aGui.println("Tu n'as pas avancé, tu ne peux pas retourner sur tes pas");
        }
        else
        {
            if(this.aMainPlayer.getCurrentRoom().isExit(this.aMainPlayer.getPreviousRoom()))
            {
                this.aMainPlayer.setCurrentRoomToPopPreviousRooms();
                this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
                if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
                    this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
                this.aMainPlayer.incrementNbOfMove(); // add 1 to the nb of move
                if (this.aMainPlayer.isTimeOver())
                {
                    this.gameOver();
                }                
            }
            else
            {
                this.aGui.println("il n'y a pas de porte ici");
            }
        }
    }
    
    private void take(final Command pCommand)
    {
        String vItemName = pCommand.getSecondWord();
        if(this.aMainPlayer.getCurrentRoom().getItem(vItemName) == null)
        {
            this.aGui.println("Cet objet n'existe pas !");
            return;
        }
        if((this.aMainPlayer.getInventoryWeight() + this.aMainPlayer.getCurrentRoom().getItem(vItemName).getWeight()) > this.aMainPlayer.getMaxWeight())
        {
            this.aGui.println("Tu ne peux pas porter autant de choses !");
            return;
        }
        this.aMainPlayer.take(vItemName);
        this.aGui.println(this.aMainPlayer.getInventoryDescription());
    }
    
    private void drop(final Command pCommand)
    {
        String vItemName = pCommand.getSecondWord();
        if(this.aMainPlayer.getInventory().getItem(vItemName) == null)
        {
            this.aGui.println("Tu n'as pas ça sur toi !");
            return;
        }
        this.aMainPlayer.drop(vItemName);
        this.aGui.println(this.aMainPlayer.getInventoryDescription());
    }
    
    private void inventory()
    {
        this.aGui.println(this.aMainPlayer.getInventoryDescription());
    }
    
    private void test(final String pFileName)
    {
        Scanner vScan;
        try
        {
            vScan = new Scanner(new File("alltests/" + pFileName +".txt"));
               
            while(vScan.hasNextLine())
            {
                String vLine = vScan.nextLine();
                interpretCommand(vLine);
            }
        }
        catch(final FileNotFoundException pFNFE)
        {
            
        }
    }
    
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
    
    private void gameOver()
    {
        this.aGui.println( "Tu as perdu." );
        this.aGui.enable( false );
    }
    
}
