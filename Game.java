 
/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author ROUSTANT Jolan
 */
public class Game
{
    /// ATTRIBUTS ///
    private Room aCurrentRoom;
    private Parser aParser;
    
    /// createRooms
    private void createRooms()
    {
        Room vDodo0 = new Room("vDodo0");
        Room vT1 = new Room("vT1");
        Room vT2 = new Room("vT2");
        Room vT3 = new Room("vT3");
        Room vT4 = new Room("vT4");
        Room vCDS1 = new Room("vCDS1");
        Room vCDS2 = new Room("vCDS2");
        Room vCDS3 = new Room("vCDS3");
        Room vCDS4 = new Room("vCDS4");
        Room vCDS5 = new Room("vCDS5");
        Room vCDS6 = new Room("vCDS6");
        Room vCDS7 = new Room("vCDS7");
        Room vQG = new Room("vQG");
        Room vT5 = new Room("vT5");
        Room vT6 = new Room("vT6");
        Room vT7 = new Room("vT7");
        Room vT8 = new Room("vT8");
        Room vT9 = new Room("vT9");
        Room vT10 = new Room("vT10");
        Room vT11 = new Room("vT11");
        Room vDepartAvion = new Room("vDepartAvion");
        Room vArriveAvion = new Room("vArriveAvion");
        Room vInterrieurAvion = new Room("vInterrieurAvion");
        Room vImpossible1 = new Room("vImpossible1");
        Room vGauche = new Room("vGauche");
        Room vDroite = new Room("vDroite");

        
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
    }
    public Game()
    {
        createRooms();
        this.aParser = new Parser();
    }
    
    private void printLocationInfo()
    {
        System.out.println("Tu es "+this.aCurrentRoom.getDescription());
        System.out.println(this.aCurrentRoom.getExitString());
    }
    
    private void goRoom(final Command pCommand) //doit être privé
    {
        if (!pCommand.hasSecondWord())
        {
            System.out.println("Aller où ?");
            return;
        }
        
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        
        if (vNextRoom == null)
        {
            System.out.println("Il n'y a rien ici !");
        }
        else
        {
            this.aCurrentRoom = vNextRoom;
            printLocationInfo();
        }
    }
    
    private void printWelcome()  // doit être privé
    {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println(" ");
        printLocationInfo();
    }
    
    private void printHelp() // doit être privé
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.");
        System.out.println(" ");
        System.out.println("Tes commandes sont :");
        System.out.println("  aller quitter aide");
    }
    
    private boolean quit(final Command pCommand)
    {
        if(pCommand.hasSecondWord())
        {
            System.out.println("Quitter quoi ?");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean processCommand(final Command pCommand)
    {
        if(pCommand.isUnknown())
        {
            System.out.println("Ce n'est pas une commande...");
            return false;
        }
        else
        {
            if(pCommand.getCommandWord().equals("quitter"))
            {
                return this.quit(pCommand);
            }
            else
            {
                if (pCommand.getCommandWord().equals("aller"))
                {
                    this.goRoom(pCommand);
                }
                else if (pCommand.getCommandWord().equals("aide"))
                {
                    this.printHelp();
                }
                return false;
            }
        }
    }
    public void play()
    {
        this.printWelcome();
        boolean vFinished = false;
        while(!vFinished)
        {
            Command vCommand = aParser.getCommand();
            vFinished = this.processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
} // Game
