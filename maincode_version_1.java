/**
 * this code was made to run an advanced version of the prisoner's dilemma.
 *
 * @author (Jack ward)
 * @version (20/6/24)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class maincode_version_1 extends JFrame implements ActionListener,MouseListener
{
    ImageIcon mainMenu;
    
    JButton QuitButton;
    JButton tutorialButton;
    JButton yesButton;
    JButton noButton;
   
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
   
    public maincode_version_1(){
        setTitle("the Prisoner's Dilemma");
        this.getContentPane().setPreferredSize(new Dimension(768,768));//X,Y
        this.pack();
        this.toFront();
        this.setVisible(true);
       
        //menuBar=new JMenuBar();
        //this.setJMenuBar(menuBar);
       
        // Create a custom panel to handle background color and layout
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        mainMenu = new ImageIcon(new ImageIcon("mainMenu.jpg").getImage().getScaledInstance(768,768, Image.SCALE_SMOOTH));
        //panel.setBackground(Color.GRAY);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        add(panel);
        setPreferredSize(new Dimension(768,768));
        setLocationRelativeTo(null);
       
        tutorialButton = new JButton("tutorial");
        tutorialButton.setActionCommand("tutorial");
        tutorialButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(tutorialButton,gbc);
       
        yesButton = new JButton("yes");
        yesButton.setActionCommand("yes");
        yesButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(yesButton,gbc);
        
        noButton = new JButton("no");
        noButton.setActionCommand("no");
        noButton.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(noButton,gbc);
       
        repaint();
    }
    public  void actionPerformed(ActionEvent e){
       
        String cmd = e.getActionCommand();
        switch(cmd){
            case "tutorial": createDialog(cmd);
                break;
            case "Quit": System.exit(0) ;
                break;
            default : System.out.println("Sorry, this hasn't impliment yet");
                break;
        }
    }
    
    public void paint (Graphics g){
        super.paint(g);
        mainMenu.paintIcon(this,g,0,0);
        Graphics2D g2 = (Graphics2D) g;
        tutorialButton.repaint();
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


