package mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import crimes.Crime;

/**
 * The JPanel for the main menu.
 *
 * @author (Jack ward)
 * @version (20/6/24)
 */
public class MenuPanel extends JPanel
{
    private GridBagConstraints gbc;
    private JButton tutorialButton;
    private JPanel textAreaPanel;
    private JButton yesButton;
    private JButton noButton;

    /**
     * Constructor for the MenuPanel class. Sets up the panel layout and components.
     *
     * @param listener the ActionListener to be added to the buttons
     */

    public MenuPanel(ActionListener listener) 
    {
        setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
        tutorialButton = new JButton("Tutorial");
        tutorialButton.setActionCommand("tutorial");
        tutorialButton.addActionListener(listener);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 3;
        gbc.gridy = 0;

        add(tutorialButton, gbc);


        textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        textAreaPanel.add(new Crime());

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 3;
        gbc.gridy = 1;

        add(textAreaPanel, gbc);


        yesButton = new JButton(new ImageIcon("yesButton.png"));
        yesButton.setActionCommand("yes");
        yesButton.addActionListener(listener);

        gbc.gridx = 0;
        gbc.weightx = 0.4;
        gbc.gridwidth = 1;
        gbc.gridy = 2;

        add(yesButton, gbc);


        noButton = new JButton(new ImageIcon("noButton.png"));
        noButton.setActionCommand("no");
        noButton.addActionListener(listener);

        gbc.gridx = 2;
        gbc.gridy = 2;

        add(noButton, gbc);
    }
    
    /**
     * repaints the components.
     *
     * @param g the Graphics object used to paint the components
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        tutorialButton.repaint();
        textAreaPanel.repaint();
        yesButton.repaint();
        noButton.repaint();
    }
    
    /*
     * replaces the crime with a new (random) one.
     */
    public void newCrime() 
    {
        // Display a new random crime scenario
        textAreaPanel.removeAll();
        textAreaPanel.add(new Crime());
    }
}