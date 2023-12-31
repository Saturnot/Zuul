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
        this.aMainPlayer = new Player();
        this.aParser = new Parser();
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
        
        //language
        String[] vDescriptionDodo0 = {
        "C'est ta chambre, c'est un peu petit et tu dois la partager avec 7 autres soldats.",
        "This is your room, it's a bit small and you have to share it with 7 other soldiers.",
        "あなたの部屋だ。部屋は広くなく、8人の兵士が生活している。"};
        
        String[] vDescriptionT1 = {
        "Tu vois la lumière du jour, le soleil t'aveugle et la boue te glace les pieds. Tu dois suivre ton compagnon.",
        "You see daylight, the sun blinds you and the mud freezes your feet. You must follow your mate.",
        ""};
        
        String[] vDescriptionT3 = {
        "Le QG est au sud, ce n'est pas si loin. Il y a un soldat.",
        "The HQ is to the south, it's not that far. There is a soldier.",
        ""};
        
        String[] vDescriptionT4 = {
        "Une tranchée vide.",
        "An empty trench.",
        ""};
        
        String[] vDescriptionT5 = {
        "",
        "",
        ""};
        
        String[] vDescriptionT6 = {
        "Il y a eu un éboulement, il faut quelque chose pour débloquer le chemin.",
        "There was a landslide, we need something to unblock the path.",
        ""};
        
        String[] vDescriptionT7 = {
        "On entend des coups de feu qui proviennent du champ de bataille.",
        "Shots are heard coming from the battlefield.",
        ""};
        
        String[] vDescriptionT9 = {
        "La promiscuité dans les tranchés est très importante, l’odeur de putréfaction te brule les narines. ",
        "The promiscuity in the trenches is very important, the smell of putrefaction burns your nostrils",
        ""};
        
        String[] vDescriptionT10 = {
        "Tu es plus au calme, les combats ont cessé ici.",
        "You are more calm, the fighting has stopped here.",
        ""};
        
        String[] vDescriptionT11 = {
        "On entend que le gazouillement des oiseaux.",
        "You can only hear the chirping of the birds.",
        ""};
        
        String[] vDescriptionCDS1 = {
        "Tu ne peux pas aller plus loin au risque de déserter.",
        "You can't go any further and risk deserting.",
        ""};
        
        String[] vDescriptionCDS3 = {
        "C'est l'infirmerie.",
        "This is the infirmary.",
        ""};
        
        String[] vDescriptionCDS4 = {
        "Tu es dans une tranchée secondaire, en dessous de la surface. Je crois qu'on est perdu.",
        "You're in a secondary trench, below the surface. I think we're lost.",
        ""};
        
        String[] vDescriptionCDS5 = {
        "C’est une ancienne tranchée souterraine, elle sert aujourd’hui de stockage de munitions.",
        "It is an old underground trench, it is now used for ammunition storage.",
        ""};
        
        String[] vDescriptionCDS6 = {
        "Il n’y a rien ici a part de vieux outils, surement pour creuser les tranchées. ",
        "There is nothing here but old tools, probably for digging trenches.",
        ""};
        
        String[] vDescriptionQG = {
        "Tu es dans les quartiers des supérieurs, ton chef t'attend. ",
        "You are in the superior's quarters, your boss is waiting for you.",
        ""};
        
        String[] vDescriptionDA = {
        " Oh, un avion ! Qu’est ce qu’il peut bien faire là ?",
        "Oh, a plane! What is it doing there?",
        ""};
        
        String[] vDescriptionAA = {
        " Nous revoilà sur la terre ferme.",
        "We are back on dry land.",
        ""};
        
        String[] vDescriptionIA = {
        " On sent le vent à travers l’avion, le champ de bataille s’étend à perte de vue... ",
        "You can feel the wind through the plane, the battlefield stretches as far as the eye can see...",
        ""};
        
        String[] vDescriptionDroite = {
        " ",
        "",
        ""};
        
        String[] vDescriptionEchelle1 = {
        "Oh non, les combats sont très violents ici, un obus vient de tomber, son souffle t'a plaqué au sol. ",
        "Oh no, the fighting is very violent here, a shell has just fallen, its blast has knocked you to the ground.",
        ""};
        
        Room vDodo0 = new Room(vDescriptionDodo0[Player.aLanguage], "img/dodo-soldat.png");
        Room vT1 = new Room(vDescriptionT1[Player.aLanguage], "img/debut.png");
        Room vT3 = new Room(vDescriptionT3[Player.aLanguage], "img/T3.png");
        Room vT4 = new Room(vDescriptionT4[Player.aLanguage], "img/T2.png");
        Room vT5 = new Room(vDescriptionT5[Player.aLanguage], "img/T5.png");
        Room vT6 = new Room(vDescriptionT6[Player.aLanguage], "img/tranche2.png");
        Room vT7 = new Room(vDescriptionT7[Player.aLanguage], "img/T2.png");
        Room vT9 = new Room(vDescriptionT9[Player.aLanguage], "img/tranche3.png");
        Room vT10 = new Room(vDescriptionT10[Player.aLanguage], "img/T10.png");
        Room vT11 = new Room(vDescriptionT11[Player.aLanguage], "img/T11.png");
        Room vCDS1 = new Room(vDescriptionCDS1[Player.aLanguage], "img/tranche4.png");
        Room vCDS3 = new Room(vDescriptionCDS3[Player.aLanguage], "img/infirmerie.png");
        Room vCDS4 = new Room(vDescriptionCDS4[Player.aLanguage], "img/dessous.png");
        Room vCDS5 = new Room(vDescriptionCDS5[Player.aLanguage], "img/dyna.png");
        Room vCDS6 = new Room(vDescriptionCDS6[Player.aLanguage], "img/shovel.png");
        Room vQG = new Room(vDescriptionQG[Player.aLanguage], "img/reu.png");
        Room vDepartAvion = new Room(vDescriptionDA[Player.aLanguage], "img/avion-depart.png");
        Room vArriveAvion = new Room(vDescriptionAA[Player.aLanguage], "img/avion-arrive.png");
        Room vInterrieurAvion = new Room(vDescriptionIA[Player.aLanguage], "img/avion-vole.png");
        Room vDroite = new Room(vDescriptionDroite[Player.aLanguage], "img/unknow.png");
        Room vEchelle1 = new Room(vDescriptionEchelle1[Player.aLanguage], "img/echelle.png");
        TransporterRoom vTeleporter = new TransporterRoom("teleporter", "img/unknow.png");
        
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
        this.aRoomsList.put("Teleporter", vTeleporter);

        //set exits
        //language
        String[] vEst = {"est", "east", ""};
        String[] vOuest = {"ouest", "west", ""};
        String[] vSud = {"sud", "south", ""};
        String[] vNord = {"nord", "north", ""};
        String[] vHaut = {"haut", "up", ""};
        String[] vBas = {"bas", "down", ""};
        
        vDodo0.setExits(vEst[Player.aLanguage], vT1);
        vT1.setExits(vEst[Player.aLanguage], vT3);
        vT1.setExits(vSud[Player.aLanguage], vCDS1);
        vT1.setExits(vOuest[Player.aLanguage], vDodo0);
        vT3.setExits(vNord[Player.aLanguage], vCDS3);
        vT3.setExits(vEst[Player.aLanguage], vT4);
        vT3.setExits(vSud[Player.aLanguage], vQG);
        vT3.setExits(vOuest[Player.aLanguage], vT1);
        vT3.setExits(vHaut[Player.aLanguage], vEchelle1);
        vT3.setExits(vBas[Player.aLanguage], vCDS4);
        vT4.setExits(vEst[Player.aLanguage], vT5);
        vT4.setExits(vOuest[Player.aLanguage], vT3);
        vCDS1.setExits(vNord[Player.aLanguage], vT1);
        vCDS3.setExits(vSud[Player.aLanguage], vT3);
        vCDS4.setExits(vHaut[Player.aLanguage], vT3);
        vCDS5.setExits(vSud[Player.aLanguage], vT5);
        vCDS5.setExits(vNord[Player.aLanguage], vTeleporter);
        vCDS6.setExits(vOuest[Player.aLanguage], vT5);
        vQG.setExits(vNord[Player.aLanguage], vT3);
        vT5.setExits(vNord[Player.aLanguage], vCDS5);
        vT5.setExits(vEst[Player.aLanguage], vCDS6);
        vT5.setExits(vSud[Player.aLanguage], vT6);
        vT5.setExits(vOuest[Player.aLanguage], vT4);
        vT6.setExits(vNord[Player.aLanguage], vT5);
        vT6.setExits(vOuest[Player.aLanguage], vT7);
        vT7.setExits(vSud[Player.aLanguage], vT9);
        vT7.setExits(vEst[Player.aLanguage], vT6);
        vT9.setExits(vNord[Player.aLanguage], vT7);
        vT9.setExits(vEst[Player.aLanguage], vDepartAvion);
        vT10.setExits(vNord[Player.aLanguage], vArriveAvion);
        vT10.setExits(vEst[Player.aLanguage], vDroite);
        vT10.setExits(vOuest[Player.aLanguage], vT11);
        vT11.setExits(vEst[Player.aLanguage], vT10);
        vDepartAvion.setExits(vEst[Player.aLanguage], vInterrieurAvion);
        vDepartAvion.setExits(vOuest[Player.aLanguage], vT9);
        vArriveAvion.setExits(vSud[Player.aLanguage], vT10);
        vArriveAvion.setExits(vOuest[Player.aLanguage], vInterrieurAvion);
        vInterrieurAvion.setExits(vEst[Player.aLanguage], vArriveAvion);
        // vInterrieurAvion.setExits(vOuest[Player.aLanguage], vDepartAvion);
        vDroite.setExits(vOuest[Player.aLanguage], vT10);
        vEchelle1.setExits(vBas[Player.aLanguage], vT3);
          
        
        // set rooms where we can go from the teleporter room
        vTeleporter.getRoomRandomizer().addRoom(vDodo0);
        vTeleporter.getRoomRandomizer().addRoom(vT1);
        vTeleporter.getRoomRandomizer().addRoom(vT3);
        
        String[] vPelleName = {"pelle", "shovel", ""};
        String[] vPelleDes = {"Une vieille pelle, j'espère qu’elle ne va pas se casser. ", "An old shovel, I hope it won't break.", ""};
        Item vPelle = new Item(vPelleDes[Player.aLanguage], 2310);
        vCDS6.addItem(vPelleName[Player.aLanguage], vPelle);
        
        String[] vDynaName = {"dynamite", "dynamite", ""};
        String[] vDynaDes = {"Un bâton de dynamite. ", "A stick of dynamite.", ""};
        Item vDynamite = new Item(vDynaDes[Player.aLanguage], 1000);
        vCDS5.addItem(vDynaName[Player.aLanguage], vDynamite);
        
        String[] vMotName = {"moteur-d'avion", "aircraft-engine", ""};
        String[] vMotDes = {"Une pièce de moteur qui a l'air cassée.", "An engine part that looks broken.", ""};
        Item vMoteur = new Item(vMotDes[Player.aLanguage], 62000);
        vT7.addItem(vMotName[Player.aLanguage], vMoteur);
        
        String[] vFuName = {"fusil", "rifle", ""};
        String[] vFuDes = {"Votre arme.", "Your weapon.", ""};
        Item vFusil = new  Item(vFuDes[Player.aLanguage], 3000);
        vDodo0.addItem(vFuName[Player.aLanguage], vFusil);
        
        String[] vNouName = {"boite-de-singe", "food-ration", ""};
        String[] vNouDes = {"De la viande en conserve, ça peut vous rendre plus fort.", "Canned meat, it can make you stronger.", ""};
        Item vNourriture = new Item(vNouDes[Player.aLanguage], 200);
        vDodo0.addItem(vNouName[Player.aLanguage], vNourriture);
        //Beamer vBeamer = new  Beamer("Un téléporteur ", 1);
        //vDodo0.addItem("beamer", vBeamer);
        
        String[] vCarteName = {"carte", "map", ""};
        String[] vCarteDes = {"Une carte qui affiche une partie des tranchées.", "A map showing part of the trenches.", ""};
        Item vCarte = new  Item(vCarteDes[Player.aLanguage], 10);
        vCDS4.addItem(vCarteName[Player.aLanguage], vCarte);
        
        String[] vBrouName = {"brouette", "wheelbarrow", ""};
        String[] vBrouDes = {"Une brouette qui augmente la taille de l'inventaire. ('utiliser brouette' pour activer son effet).", "A wheelbarrow that increases the size of the inventory. ('use wheelbarrow' to activate its effect)", ""};
        Item vBrouette = new Item(vBrouDes[Player.aLanguage], 5000);
        vDepartAvion.addItem(vBrouName[Player.aLanguage], vBrouette);
        
        
        //set NPC
        String[] vCN = {"compagnon", "mate", ""};
        String[] vCD = {"C'est ton compagnon.", "It's your mate.", ""};
        String[] vCS1 = {"Reveille-toi soldat, le supérieur veut te parler.", "Wake up soldier, the superior wants to talk to you.", ""};
        String[] vCS2 = {"Allez dépêche-toi, on a pas le temps de trainer au lit!", "Come on, hurry up, we have no time to hang out in bed!", ""};
        Character vCompagnon = new Character(vCN[Player.aLanguage], vCD[Player.aLanguage], new String[]{vCS1[Player.aLanguage], vCS2[Player.aLanguage]});
        vDodo0.addNPC("compagnon", vCompagnon);
        
        String[] vSAN = {"soldat-assis", "sitting-soldier", ""};
        String[] vSAD = {"Ce soldat a l’air de s’ennuyer ferme. ", "This soldier looks very bored.", ""};
        String[] vSAS1 = {"Oh un nouveau ! Salut, au sud se trouvent les quartiers des supérieurs, au nord tu trouveras l'infirmerie et les tranchées se poursuivent à l'est.  ", "Oh a new one! Hi, to the south are the superior quarters, to the north you will find the infirmary and the trenches continue to the east.", ""};
        Character vSoldatAssis = new Character(vSAN[Player.aLanguage], vSAD[Player.aLanguage], new String[]{vSAS1[Player.aLanguage]});
        vT3.addNPC(vSAN[Player.aLanguage], vSoldatAssis);
        
        
        String[] vSPN = {
            "soldat-pensif",
            "thoughtful-soldier",
            ""};
        String[] vSPD = {
            "Ce soldat me semble un peu triste et mélancolique...",
            "This soldier seems to me a little sad and melancholic...",
            ""};
        String[] vSPS1 = {
            "Hey... Fait attention à toi, ne monte jamais au front, c'est dangereux là-haut",
            "Hey... Be careful, never go up to the front, it's dangerous up there",
            ""};
        String[] vSPS2 = {
            "Tu te souviens, ne monte jamais !",
            "Remember, never go up!",
            ""};
        Character vSoldatPensif = new Character(vSPN[Player.aLanguage],vSPD[Player.aLanguage], new String[]{vSPS2[Player.aLanguage],vSPS2[Player.aLanguage]});
        vCDS1.addNPC(vSPN[Player.aLanguage], vSoldatPensif);
        
        String[] vComN = {
            "commandant",
            "commander",
            ""};
        String[] vComD = {
            "C'est ton supérieur, il a l'air de vouloir te dire quelque chose d'important.",
            "It's your superior, he seems to want to tell you something important.",
            ""};
        String[] vComS1 = {
            "Soldat ! J'ai une mission de la plus haute importance pour toi, un bataillon va se faire attaquer vers le sud-est. C'est loin d'ici, ta mission est de porter ce message avant qu'il ne soit trop tard. La France compte sur toi, soldat !",
            "Soldier! I have a mission of the utmost importance for you, a battalion is about to be attacked to the southeast. It is far from here, your mission is to bring this message before it is too late. France is counting on you, soldier!",
            ""};
        Character vCommandant = new Character(vComN[Player.aLanguage],vComD[Player.aLanguage], new String[]{vComS1[Player.aLanguage]});
        vQG.addNPC(vComN[Player.aLanguage], vCommandant);
        
        // set Door (locked doors)
        String[] vLettreName = {"lettre", "letter", ""};
        Door vDoorTuto = new Door(vLettreName[Player.aLanguage]);
        vT3.setDoors(vEst[Player.aLanguage], vDoorTuto);
        
        
        
        this.aMainPlayer.setCurrentRoom(vDodo0);
    }//createRooms
    
    /**
     * Print the first txt the user see and print the info of the first Room
     */
    private void printWelcome()  // doit être privé
    {
        String[] vM1 = {
            "Tu viens de te réveiller.",
            "You just woke up.",
            ""};
        String[] vM2 = {
            "Ecris 'aide' si tu as besoin d'un coup de main.",
            "Type 'help' if you need a hand.",
            ""};
        this.aGui.println(vM1[Player.aLanguage]);
        this.aGui.println(vM2[Player.aLanguage]);
        this.aGui.println(" ");
        this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
    }//printWelcome
    
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( " -- " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );
        String[] vAide = {"aide","help",""};
        String[] vCarte = {"carte","map",""};
        String[] vManger = {"manger","eat",""};
        String[] vAller = {"aller","go",""};
        String[] vRetour = {"retour","back",""};
        String[] vPrendre = {"prendre","take",""};
        String[] vUtiliser = {"utiliser","use",""};
        String[] vLacher = {"lacher","drop",""};
        String[] vInventaire = {"inventaire","inventory",""};
        String[] vParler = {"parler","talk",""};
        String[] vRegarder = {"regarder","look",""};
        String[] vQuitter = {"quitter","quit",""};
        if ( vCommand.isUnknown() )
        {
            String[] vM1 = {
                "Cette commande n'existe pas.",
                "This command does not exist.",
                ""};
            this.aGui.println(vM1[Player.aLanguage]);
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals(vAide[Player.aLanguage]) )
        {
            this.printHelp();
        }
        else if ( vCommandWord.equals(vCarte[Player.aLanguage]) )
        {
            this.map();
        }
        else if ( vCommandWord.equals(vManger[Player.aLanguage]) )
        {
            this.eat(vCommand);
        }
        else if ( vCommandWord.equals(vAller[Player.aLanguage]) )
        {
            this.goRoom(vCommand);
        }
        else if ( vCommandWord.equals( "cheat-code" ) )
        {
            this.cheat(vCommand);
        }
        else if (vCommandWord.equals(vRetour[Player.aLanguage]))
        {
            this.back(vCommand);
        }
        else if (vCommandWord.equals(vPrendre[Player.aLanguage]))
        {
            this.take(vCommand);
        }
        else if (vCommandWord.equals(vUtiliser[Player.aLanguage]))
        {
            this.use(vCommand);
        }
        else if (vCommandWord.equals(vLacher[Player.aLanguage]))
        {
            this.drop(vCommand);
        }
        else if (vCommandWord.equals("test"))
        {
            this.test(vCommand.getSecondWord());
        }
        else if (vCommandWord.equals(vInventaire[Player.aLanguage]))
        {
            this.inventory();
        }
        else if (vCommandWord.equals(vParler[Player.aLanguage]))
        {
            this.talk(vCommand);
        }
        else if (vCommandWord.equals(vRegarder[Player.aLanguage]))
        {
            this.look(vCommand);
        }
        else if ( vCommandWord.equals(vQuitter[Player.aLanguage]) ) {
            String[] vQuit = {"Que veux-tu quitter ?", "Quit what?", ""};
            if ( vCommand.hasSecondWord() )
                this.aGui.println(vQuit[Player.aLanguage]);
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
        String[] vS1 = {
            "Tu es un soldat, on est en 1915. Tu dois transmettre un message avant qu'il ne soit trop tard.",
            "You are a soldier, it is 1915. You have to deliver a message before it's too late.",
            ""
        };
        String[] vCom = {
            "Vos commandes sont : ",
            "Your commands are : ",
            ""
        };
        this.aGui.println(vS1[Player.aLanguage]);
        this.aGui.println(" ");
        this.aGui.println(vCom[Player.aLanguage]+this.aParser.getCommandString());
    }//printHelp
        
    /**
     * to move to an other room
     * @param the command
     */
    private void goRoom(final Command pCommand) //doit être privé
    {
        String[] vWhere = {
            "Aller où ?",
            "Go where ?",
            ""
        };
        String[] vNothing = {
            "Il n'y a rien ici !",
            "There is nothing here!",
            ""
        };
        String[] vUHave = {
            "Tu as bien '",
            "You do have '",
            ""
        };
        String[] vPass = {
            "'. Tu peux passer.",
            "'. You can pass.",
            ""
        };
        String[] vNotPass = {
            "Vous ne pouvez pas passer.",
            "You can't pass.",
            ""
        };
        
        
        if (!pCommand.hasSecondWord())
        {
            this.aGui.println(vWhere[Player.aLanguage]);
            return;
        }//if
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aMainPlayer.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null)
        {
            this.aGui.println(vNothing[Player.aLanguage]);
        }//if
        else
        {
            Door vNextDoor = this.aMainPlayer.getCurrentRoom().getDoor(vDirection);
            if(vNextDoor == null)
            {
                this.move(vNextRoom);
            }
            else
            {
                Item vKey = this.aMainPlayer.getInventory().getItem(vNextDoor.getKey());
                if(vNextDoor.getKey() != null && vKey != null)
                {
                    this.aGui.println(vUHave[Player.aLanguage] + vNextDoor.getKey() + vPass[Player.aLanguage]);
                    vNextDoor.setOpen(true);
                }
                if(vNextDoor.isOpen())
                {
                    this.move(vNextRoom);
                }
                else
                {
                    this.aGui.println(vNotPass[Player.aLanguage]);
                }
            }
        }//else
    }//goRoom
    
    /**
     * méthode pour alléger la méthode goroom, elle actualise la currentroom,
     * mets le bouléen aMapAff a false, affiche la déscription de la pièce,
     * affiche l'image de la pièce, incrémente le nombre de dépacement et
     * regarde si le joueur a atteint le nombre de déplacement max.
     */
    private void move(final Room pNextRoom)
    {
        this.aMainPlayer.addNewPreviousRoom();
        this.aMainPlayer.setCurrentRoom(pNextRoom);
        this.aMapAff = false; // to do the map working
        
        this.aGui.println( this.aMainPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aMainPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aMainPlayer.getCurrentRoom().getImageName() );
            
        this.aMainPlayer.incrementNbOfMove(); // add 1 to the nb of move
        if (this.aMainPlayer.isTimeOver())
        {
            this.gameOver();
        }
    }
    
    private void talk(final Command pCommand)
    {
        String vNPC = pCommand.getSecondWord();
        if(this.aMainPlayer.getCurrentRoom().getNPC(vNPC) == null)
        {
            this.aGui.printTab(new String[]{"Il n'est pas ici.", "It is not here.", ""});
        }
        else
        {
            this.aGui.println(this.aMainPlayer.getCurrentRoom().getNPC(vNPC).getSentence(0));
            String[] vComN = {
            "commandant",
            "commander",
            ""};
            if(vNPC.equals(vComN[Player.aLanguage]))
            {
                String[] vLettreD = {
                "Une lettre importante.",
                "An important letter.",
                ""};
                String[] vLettreN = {
                "lettre",
                "letter",
                ""};
                Item vLettre = new Item(vLettreD[Player.aLanguage], 10);
                this.aMainPlayer.getCurrentRoom().addItem(vLettreN[Player.aLanguage], vLettre);
                this.aGui.println(this.aMainPlayer.getCurrentRoom().getItemDescription());
            }
        }
    }
    
    private void cheat(final Command pCommand)
    {
        String cheatCode = pCommand.getSecondWord();
        try
        {
            int vCode = Integer.parseInt(cheatCode);
            switch(vCode)
            {
                case 1:
                    Beamer vBeamer = new  Beamer("A teleporter", 1);
                    this.aMainPlayer.getInventory().addItem("beamer", vBeamer);
                    this.aGui.println("You used the cheat code number 1, you got a teleporter (beamer)!");
                    this.aGui.println(this.aMainPlayer.getInventoryDescription());
                    break;    
                default:
                    this.aGui.println("This cheat code does not exist");
            }
        }
        catch (NumberFormatException e)
        {
            this.aGui.println("The code must be a number.");
        }
    }
    
    /**
     * method to look
     * print the LongDescription
     */
    private void look(final Command pCommand)
    {
         this.aGui.println(this.aMainPlayer.getCurrentRoom().getLongDescription());
    }
    
    /**
     * method to eat
     */
    private void eat(final Command pCommand)
    {
        if(!pCommand.hasSecondWord())
        {
            String[] vEatWhat = {
                "Tu veux manger quoi ? Tappe 'manger [ce que tu veux manger]'.",
                "What do you want to eat? Type 'eat [what you want to eat]'.",
                ""};
            this.aGui.println(vEatWhat[Player.aLanguage]);
        }
        else
        {
            String vNourriture = pCommand.getSecondWord();
            if(this.aMainPlayer.getInventory().getItem(vNourriture) == null)
            {
                String[] vNotOnU = {
                    "Tu n'as pas ça sur toi !",
                    "You don't have that on you!",
                    ""};
                this.aGui.println(vNotOnU[Player.aLanguage]);
                return;
            }
            String[] vNouName = {"boite-de-singe", "food-ration", ""};
            if(vNourriture.equals(vNouName[Player.aLanguage]))
            {
                this.aMainPlayer.getInventory().supItem(vNourriture);
                this.aMainPlayer.setMaxWeight(this.aMainPlayer.getMaxWeight() + 2000);     
                String[] vEat = {
                    "Tu as manger un peu de nourriture, tu peux donc porter plus de chose.",
                    "You have eaten some food, so you can carry more.",
                    ""};
                this.aGui.println(vEat[Player.aLanguage]);
            }
            String[] vNotEat = {
                "Tu ne peux pas manger ça !",
                "You can't eat that!",
                ""};
            this.aGui.println(vNotEat[Player.aLanguage]);
            return;
        }
    }
    
    private void use(final Command pCommand)
    {
        if(!pCommand.hasSecondWord())
        {
            this.aGui.printTab(new String[]{"Que veux-tu utiliser ?", "What do you want to use?", ""});
        }
        else
        {
            String vObject = pCommand.getSecondWord();
            if(vObject.equals("beamer"))
            {
                if(this.aMainPlayer.getInventory().getItem(vObject) == null)
                {
                    this.aGui.println("You don't have that on you!");
                    return;
                }
                else
                {
                    Beamer vBeamer = (Beamer)this.aMainPlayer.getInventory().getItem(vObject);
                    if (vBeamer.getFirstRoom() == null)
                    {
                        this.aGui.println("You load your teleporter...");
                        vBeamer.setFirstRoom(this.aMainPlayer.getCurrentRoom());
                        this.aGui.println("Your teleporter is ready to be used!");
                        return;
                    }
                    if (vBeamer.getFirstRoom() != null)
                    {
                        this.aMainPlayer.addNewPreviousRoom();
                        this.aMainPlayer.setCurrentRoom(vBeamer.getFirstRoom());
                        this.aGui.println("Your teleporter has just been used!");
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
                this.aGui.printTab(new String[]{"Tu ne peux rien faire avec cet objet.", "You can't do anything with this object.", ""});
            }
        }
    }
    
    private void map()
    {
        String[] vMapN = {"carte", "map", ""};
        if(this.aMainPlayer.getInventory().getItem(vMapN[Player.aLanguage]) != null)
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
            this.aGui.printTab(new String[]{"Tu n'as pas de carte.", "You don't have a map.", ""});
        }
    }
    
    private void back(final Command pCommand)
    {
        if(pCommand.hasSecondWord())
        {
            this.aGui.printTab(new String[]{"Tu peux juste retourner sur tes pas.","You can just go back.", ""});
        }
        else
        {
            if(this.aMainPlayer.isPreviousRoomsEmpty())
            {
                this.aGui.printTab(new String[]{"Tu n'as pas avancé, tu ne peux pas retourner sur tes pas.", "You haven't moved on, you can't go back.", ""});
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
                    this.aGui.printTab(new String[]{"Il n'y a pas de porte ici","There's no door here.", ""});
                }
            }
        }
        
    }
    
    private void take(final Command pCommand)
    {
        if(!pCommand.hasSecondWord())
        {
            this.aGui.printTab(new String[]{"Que veux-tu prendre ?", "What do you want to take?", ""});
        }
        else
        {
            String vItemName = pCommand.getSecondWord();
            if(this.aMainPlayer.getCurrentRoom().getItem(vItemName) == null)
            {
                this.aGui.printTab(new String[]{"Cet objet n'existe pas !", "This object does not exist!", ""});
                return;
            }
            if((this.aMainPlayer.getInventoryWeight() + this.aMainPlayer.getCurrentRoom().getItem(vItemName).getWeight()) > this.aMainPlayer.getMaxWeight())
            {
                this.aGui.printTab(new String[]{"Tu ne peux pas porter autant de choses !","You can't carry that much stuff!",""});
                return;
            }
            this.aMainPlayer.take(vItemName);
            this.aGui.println(this.aMainPlayer.getInventoryDescription());
        }
    }
    
    private void drop(final Command pCommand)
    {
        
        if(!pCommand.hasSecondWord())
        {
            this.aGui.printTab(new String[]{"Que veux-tu lâcher ?", "What do you want to drop?", ""});
        }
        else
        {
            String vItemName = pCommand.getSecondWord();
            if(this.aMainPlayer.getInventory().getItem(vItemName) == null)
            {
                this.aGui.printTab(new String[]{"Tu n'as pas ça sur toi !","You don't have that on you!",""});
                return;
            }
            this.aMainPlayer.drop(vItemName);
            this.aGui.println(this.aMainPlayer.getInventoryDescription());
        }
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
        this.aGui.println( "GAME OVER" );
        this.aGui.enable( false );
    }
    
}
