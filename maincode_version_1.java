/**
 * this code was made to run an advanced version of the prisoner's dilemma.
 *
 * @author Jack ward
 * @version 15/7/24
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import crimes.Crime;
import mainMenu.MenuPanel;

/**
 * The main class for the Prisoner's Dilemma game. Extends JFrame and implements ActionListener and MouseListener.
 */
public class MainCodeVersion1 extends JFrame implements ActionListener, MouseListener
{
    private PartnerSystem Accomplice;
    private ImageIcon background;
    private JPanel currentPanel;
    
    private JMenuBar menuBar;
    private JLabel   sentenceLabel;
    private int      sentence = 0;
    
    /**
     * Constructor for the MainCodeVersion1 class. Sets up the game window and components.
     */
    public MainCodeVersion1(){
        setTitle("The Prisoner's Dilemma");
        this.Accomplice = new PartnerSystem();
        this.getContentPane().setPreferredSize(new Dimension(768,768));//X,Y
        this.pack();
        this.toFront();
        this.setVisible(true);
       
        background = new ImageIcon("mainMenu.jpg");

        // Create a custom panel to handle background color and layout
        this.currentPanel = new MenuPanel(this);
        add(currentPanel);
        setPreferredSize(new Dimension(768,768));
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();

        // Add the "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add "Save" menu item
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setActionCommand("save");
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);

        // Add "Quit" menu item
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setActionCommand("quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);

        // Add the sentence label
        sentenceLabel = new JLabel("Sentence: 0   ");
        menuBar.add(Box.createHorizontalGlue()); // Push the label to the right
        menuBar.add(sentenceLabel);

        // Set the menu bar
        this.setJMenuBar(menuBar);
       
        revalidate();
        //Resize the window so the ImageIcon loads
    }

    /**
     * Handles action events triggered by buttons and menu items.
     *
     * @param e the ActionEvent triggered by a button or menu item
     */
    public  void actionPerformed(ActionEvent e){
       
        String cmd = e.getActionCommand();
        
        switch(cmd){
            case "tutorial": createDialog(cmd);
                break;
            case "quit": System.exit(0) ;
                break;
            case "yes":
                updateSentence(e);
                break;
            case "no":
                updateSentence(e);
                break;
            default : System.out.println("Sorry, this hasn't been implimented yet");
                break;
        }
    }

    /**
     * Updates the sentence based on the action performed (yes or no button clicked).
     *
     * @param e the ActionEvent triggered by a button
     */
    private void updateSentence(ActionEvent e) {
        boolean error = false;
        String cmd = e.getActionCommand();
        if (cmd.equals("yes")) {
            if(Accomplice.getResponce(true)==true){
                sentence += 1;
            }else {
                sentence += 4;
            }    
        } else {
            if(Accomplice.getResponce(false)==true){
                sentence += 1;
                error = true;
            }else {
                sentence -= 2;
            } 
            
        }
        // Update the sentence label
        sentenceLabel.setText("Sentence: " + sentence + "   ");
        // Display a new random crime scenario
        ((MenuPanel) currentPanel).newCrime();
        
        if (error) {
            sentence -= 1;
            sentenceLabel.setText("Sentence: " + sentence + "   ");
        }
        //revalidate();
        //currentPanel.repaint();
    }
    
    /**
     * Paints the background image and repaints the components.
     *
     * @param g the Graphics object used to paint the components
     */
    public void paint (Graphics g){
        super.paint(g);
        Image scaledImage = background.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        scaledImageIcon.paintIcon(this,g,0,0);
        menuBar.repaint();
        //currentPanel.paint(g);
    }
    
    //this code handles the mouse controls
    public void mouseExited(MouseEvent e) {System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {System.out.println("release");}
    public void mousePressed(MouseEvent e) {System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
        System.out.println(mousex + " : " + mousey);
    }
    
    /**
     * Creates a dialog box with information based on the title provided.
     *
     * @param title the title of the dialog box
     */
    void createDialog(String title){
        JDialog box = new JDialog(this);
        String prompt = " ";
        box.setBounds(384,384,600,150);
        switch(title){
            case "tutorial": prompt = 
             "The Prisoner's Dilemma is a thought experment that challenges two players to a dilemma, where \n"
            +"can cooperate with their partner for mutual benefit and only get a sentence of 1 year or they can betray \n"
            +"their partner for their individual benefit with their partner geting punished with a sentence of 4 years \n"
            +"but if both partner deside to betray they're partner then then both players get punished with a sentence \n"
            +"of 2 years. In this program you will be player in this dilemma, your will be given a random number of \n"
            +"questions which you can answer with a yes or no.";
                break;
            default : prompt = " ";
                break;
        }
        TextArea area =new TextArea(prompt);
        area.setEditable(false);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle(title);
    }

    public static void main(String[] args){
        MainCodeVersion1 game = new MainCodeVersion1();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
