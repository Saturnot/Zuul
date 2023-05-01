import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.OverlayLayout;
import java.awt.GridLayout;
import java.awt.GraphicsDevice;

import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import java.net.URL;
import java.awt.Color;
import javax.swing.JOptionPane;



/**
 * This class implements a simple graphical user interface with a 
 * text entry area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003) DB edited (2023)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton aButtonMap;
    private JButton aButtonHelp;
    private JButton aButtonO;
    private JButton aButtonE;
    private JButton aButtonS;
    private JButton aButtonN;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println( final String pText )
    {
        this.print(pText + "\n" );
    } // println(.)
    
    public void printTab(final String[] pS)
    {
        this.print(pS[Player.aLanguage] + "\n" );
    }
    
    /**
     * Show an image file in the interface.
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            
            //this.setFullScreen();
            this.aMyFrame.pack();
        }
    } // showImage(.)
    
    public String whatIsYourName()
    {
        return JOptionPane.showInputDialog("What is your name?");
    }
    
    /**
     * Enable or disable input in the entry field.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( pOnOff ) { // enable
            this.aEntryField.getCaret().setBlinkRate( 500 ); // cursor blink
            this.aEntryField.addActionListener( this ); // reacts to entry
        }
        else { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
            this.aButtonMap.removeActionListener( this );
            this.aButtonHelp.removeActionListener( this );
            this.aButtonO.removeActionListener( this );
            this.aButtonE.removeActionListener( this );
            this.aButtonS.removeActionListener( this );
            this.aButtonN.removeActionListener( this );
            
        }
    } // enable(.)
    
    private void setFullScreen()
    {
        GraphicsDevice vGD = this.aMyFrame.getGraphicsConfiguration().getDevice();
        if(vGD.isFullScreenSupported())
        {
            vGD.setFullScreenWindow(this.aMyFrame);
        }
    }
    
    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "WWW" );
        this.aEntryField = new JTextField( 34 ); //34
        
        String[] vM = {"carte","map",""};
        String[] vH = {"aide","help",""};
        String[] vO = {"ouest","west",""};
        String[] vE = {"est","east",""};
        String[] vS = {"sud","south",""};
        String[] vN = {"nord","north",""};
        
        this.aButtonMap = new JButton(vM[Player.aLanguage]);
        this.aButtonHelp = new JButton(vH[Player.aLanguage]);
        this.aButtonO = new JButton(vO[Player.aLanguage]);
        this.aButtonE = new JButton(vE[Player.aLanguage]);
        this.aButtonS = new JButton(vS[Player.aLanguage]);
        this.aButtonN = new JButton(vN[Player.aLanguage]);
        
        this.aLog = new JTextArea();     
        this.aLog.setEditable( false );
        this.aLog.setBackground(Color.WHITE);
        this.aLog.setLineWrap(true);
        this.aLog.setWrapStyleWord(true);
        
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );
        this.aImage = new JLabel();

        GridLayout grid = new GridLayout(3, 3);
        JPanel vPanelButton = new JPanel();//panel on the right for the buttons
        vPanelButton.setLayout(grid);       
        vPanelButton.add(new JButton("1"));
        vPanelButton.add(this.aButtonN);
        vPanelButton.add(this.aButtonHelp);
        vPanelButton.add(this.aButtonO);
        vPanelButton.add(new JButton("2"));
        vPanelButton.add(this.aButtonE);
        vPanelButton.add(new JButton("3"));
        vPanelButton.add(this.aButtonS);
        vPanelButton.add(this.aButtonMap);
        
        JPanel vPanel = new JPanel();
        
        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(vPanelButton, BorderLayout.EAST);

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );
        this.aButtonMap.addActionListener(this);
        this.aButtonHelp.addActionListener(this);
        this.aButtonE.addActionListener(this);
        this.aButtonO.addActionListener(this);
        this.aButtonS.addActionListener(this);
        this.aButtonN.addActionListener(this);


        // to end program when window is closed
        this.aMyFrame.addWindowListener(
            new WindowAdapter() { // anonymous class
                @Override public void windowClosing(final WindowEvent pE)
                {
                    System.exit(0);
                }
        } );
                    
        //this.setFullScreen();
        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()
        
    /**
     * Actionlistener interface for entry textfield.
     */
    
    String[] vM = {"carte","map",""};
    String[] vH = {"aide","help",""};
    String[] vO = {"ouest","west",""};
    String[] vE = {"est","east",""};
    String[] vS = {"sud","south",""};
    String[] vN = {"nord","north",""};
    String[] vGO = {"aller ouest","go west",""};
    String[] vGE = {"aller est","go east",""};
    String[] vGS = {"aller sud","go south",""};
    String[] vGN = {"aller nord","go north",""};
    @Override public void actionPerformed( final ActionEvent pE ) 
    {    
        if(pE.getActionCommand().equals(vM[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(pE.getActionCommand());
        }
        else if(pE.getActionCommand().equals(vH[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(pE.getActionCommand());
        }
        else if(pE.getActionCommand().equals(vN[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(vGN[Player.aLanguage]);
        }
        else if(pE.getActionCommand().equals(vO[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(vGO[Player.aLanguage]);
        }
        else if(pE.getActionCommand().equals(vS[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(vGS[Player.aLanguage]);
        }
        else if(pE.getActionCommand().equals(vE[Player.aLanguage]))
        {
            this.aEngine.interpretCommand(vGE[Player.aLanguage]);
        }
        else
        {
            this.processCommand(); // never suppress this line
        }
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) :
    } // actionPerformed(.)

    /**
     * A command has been entered in the entry field.  
     * Read the command and do whatever is necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
