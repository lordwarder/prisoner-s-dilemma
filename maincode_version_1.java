/**
 * this code was made to run an advanced version of the prisoner's dilemma.
 *
 * @author Jack ward
 * @version 20/6/24
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import crimes.Crime;
import mainMenu.MenuPanel;

/**
 * The main class for the Prisoner's Dilemma game. Extends JFrame and implements ActionListener and MouseListener.
 */
public class maincode_version_1 extends JFrame implements ActionListener,MouseListener
{
    ImageIcon mainMenu;
    
    JButton tutorialButton;
    JPanel textAreaPanel;
    JButton yesButton;
    JButton noButton;
    
    
    JMenuBar menuBar;
    private int sentence = 0;
    private JLabel sentenceLabel;
   
    public maincode_version_1(){
        setTitle("the Prisoner's Dilemma");
        this.getContentPane().setPreferredSize(new Dimension(768,768));//X,Y
        this.pack();
        this.toFront();
        this.setVisible(true);
       
        // Create a custom panel to handle background color and layout
        JPanel panel = new JPanel();
        add(panel);
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
        sentenceLabel = new JLabel("Sentence: 0");
        menuBar.add(Box.createHorizontalGlue()); // Push the label to the right
        menuBar.add(sentenceLabel);

        // Set the menu bar
        this.setJMenuBar(menuBar);
       
        repaint();
    }

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

    private void updateSentence(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd = "yes") {
            sentence += RANDOM.nextInt(10);
        } else {
            sentence += 2;
        }
        // Update the sentence label
        sentenceLabel.setText("Sentence: " + sentence);
        // Display a new random crime scenario
        crimeTextArea.setText(Crime.getRandomCrime());
    }
    
    public void paint (Graphics g){
        super.paint(g);
        Image scaledImage = mainMenu.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        scaledImageIcon.paintIcon(this,g,0,0);
        Graphics2D g2 = (Graphics2D) g;
        tutorialButton.repaint();
        textAreaPanel.repaint();
        yesButton.repaint();
        noButton.repaint();
    }
    //this code handles the mouse controls
    public void mouseExited(MouseEvent e) {System.out.println("exit");}
    public void mouseEntered(MouseEvent e) {System.out.println("enter");}
    public void mouseReleased(MouseEvent e) {System.out.println("release");}
    public void mousePressed(MouseEvent e) {System.out.println("press");}
    public void mouseClicked(MouseEvent e) {
        int mousex=e.getX();
        int mousey=e.getY();
       
    }
   
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
}


