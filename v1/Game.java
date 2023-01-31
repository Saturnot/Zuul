package v1;

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Game
{
    /// ATTRIBUTS ///
    private Room aCurrentRoom;
    private Parser aParser;
    
    /// createRooms
    private void createRooms()
    {
        Room vPub = new Room("in a campus pub");
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vLab = new Room("in a computing lab");
        Room vOffice = new Room("int the computing admin office");
        
        vPub.setExits(null, vOutside, null, null);
        vOutside.setExits(null, vTheatre, vLab, vPub);
        vTheatre.setExits(null, null, null, vOutside);
        vLab.setExits(vOutside, vOffice, null, null);
        vOffice.setExits(null, null, null, vLab);
        
        this.aCurrentRoom = vOutside;
    }
    public Game()
    {
        createRooms();
        this.aParser = new Parser();
    }
    
    private void goRoom(final Command pCommand) //doit être privé
    {
        if (!pCommand.hasSecondWord())
        {
            System.out.println("Go where  ?");
            return;
        }
        Room vNextRoom = null;
        String vDirection = pCommand.getSecondWord();
        if(vDirection.equals("north"))
        {
            vNextRoom = this.aCurrentRoom.aNorthExit;
        }
        else if(vDirection.equals("east"))
        {
            vNextRoom = this.aCurrentRoom.aEastExit;
        }
        else if(vDirection.equals("south"))
        {
            vNextRoom = this.aCurrentRoom.aSouthExit;
        }
        else if(vDirection.equals("west"))
        {
            vNextRoom = this.aCurrentRoom.aWestExit;
        }
        
        if (vNextRoom == null)
        {
            System.out.println("There is no door !");
        }
        else
        {
            this.aCurrentRoom = vNextRoom;
            System.out.println("You are "+this.aCurrentRoom.getDescription());
            System.out.print("Exits: ");
            if(this.aCurrentRoom.aNorthExit!=null)
            {
                System.out.print("North ");
            }if(this.aCurrentRoom.aEastExit!=null)
            {
                System.out.print("East ");
            }if(this.aCurrentRoom.aSouthExit!=null)
            {
                System.out.print("South ");
            }if(this.aCurrentRoom.aWestExit!=null)
            {
                System.out.print("West ");
            }
            System.out.println(" ");
        }
        
        
    }
    
    private void printWelcome()  // doit être privé
    {
        System.out.println("Welcume to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println(" ");
        System.out.println("You are " + this.aCurrentRoom.getDescription());
        System.out.print("Exits: ");
            if(this.aCurrentRoom.aNorthExit!=null)
            {
                System.out.print("North ");
            }if(this.aCurrentRoom.aEastExit!=null)
            {
                System.out.print("East ");
            }if(this.aCurrentRoom.aEastExit!=null)
            {
                System.out.print("South ");
            }if(this.aCurrentRoom.aWestExit!=null)
            {
                System.out.print("West ");
            }
            System.out.println(" ");
    }
    
    private void printHelp() // doit être privé
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.");
        System.out.println(" ");
        System.out.println("Your command words are:");
        System.out.println("  go quit help");
        
    }
    private boolean quit(final Command pCommand)
    {
        if(pCommand.hasSecondWord())
        {
            System.out.println("Quit what ?");
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
            System.out.println("I don't know what you mean...");
            return false;
        }
        else
        {
            if(pCommand.getCommandWord().equals("quit"))
            {
                return quit(pCommand);
            }
            else
            {
                if (pCommand.getCommandWord().equals("go"))
                {
                    this.goRoom(pCommand);
                }
                else if (pCommand.getCommandWord().equals("help"))
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
