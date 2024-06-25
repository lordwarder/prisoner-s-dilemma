package crimes

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * The Crime class extends JTextArea and displays a random crime scenario
 * from a predefined list of crimes. The text area is immutable.
 * 
 * @version 1.0
 */
public class Crime extends JTextArea {
    // Static list of strings representing different crime scenarios
    private static final String[] CRIMES = {
            "You and John are suspected of shoplifting. The police found stolen goods in your apartment, so will arrest you for possession, but they have agreed to let you go free if you testify that John was the one to steal them. However, if you both claim the other stole the goods, you'll both go to jail. Will you testify?",
            "You participated in a bank robbery. The police have enough evidence to convict you unless you testify against your accomplice. However, if you both remain silent, they won't have enough proof. Will you testify?",
            "You were involved in a hit and run. The victim's family is pressuring the police to charge you, but they have no direct evidence. If you admit to the crime, they'll have enough to arrest you, but if you deny it, they may not pursue further. Will you admit to the hit and run?",
            "You hacked into a government system. The authorities are investigating, but they can't trace it directly back to you unless you confess. However, if they catch you, the consequences will be severe. Will you confess to hacking?",
            "You committed tax fraud. The IRS suspects your financial activities, but they lack concrete evidence. If you cooperate and disclose everything, they may go easy on you, but if you deny everything, they might launch a full investigation. Will you cooperate with the IRS?",
            "You were caught selling illegal substances. The police have enough proof to charge you, but they're willing to reduce your sentence if you provide information on the supplier. However, if you stay silent, they may not have enough to convict. Will you cooperate with the police?",
            "You were involved in an insider trading scandal. The SEC is investigating, but they need your testimony to build a case. If you refuse to cooperate, they may struggle to prove anything. Will you testify against yourself?",
            "You committed arson. The fire department suspects foul play, but they lack direct evidence. If you admit to starting the fire, they'll have enough to arrest you, but if you deny it, they may not pursue further. Will you admit to arson?",
            "You stole a valuable painting from a museum. The museum has security footage of you, but they haven't identified you yet. If you turn yourself in, they'll go easy on you, but if you stay silent, they may never catch you. Will you confess to the theft?",
            "You were caught bribing a public official. The authorities are investigating corruption, and they suspect you're involved. If you provide evidence against others, they may reduce your punishment, but if you deny everything, they'll intensify their scrutiny. Will you cooperate with the investigation?"
    };

    // Random object to generate random numbers
    private static final Random RANDOM = new Random();

    /**
     * Constructor for the Crime class.
     * Initializes the JTextArea with a random crime scenario and makes it immutable.
     */
    public Crime() {
        super(5, 20); // Setting default rows and columns for the JTextArea
        this.setText(getRandomCrime());
        this.setEditable(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    /**
     * Returns a random crime scenario from the predefined list of crimes.
     * 
     * @return A random crime scenario.
     */
    private static String getRandomCrime() {
        int index = RANDOM.nextInt(CRIMES.length);
        return CRIMES[index];
    }

    /**
     * Main method to test the Crime JTextArea.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a frame to test the Crime JTextArea
        JFrame frame = new JFrame("Crime JTextArea Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Create an instance of the Crime JTextArea
        Crime crimeTextArea = new Crime();

        // Add the Crime JTextArea to the frame
        frame.add(new JScrollPane(crimeTextArea), BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}