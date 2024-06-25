package crimes;

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
    private static final String[] NAMES = {
        "Jesse", "James", "Charlie", "Chelsie", "Daniel", "Delila",
        "Gregory", "Georgia", "Karen", "Karl", "Jane", "Joe"
    };

    private static final String[] CRIMES = {
        "You and %s are suspected of shoplifting. The police found stolen goods in your apartment, so will arrest both of you for possession, but they have agreed to let you go free if you testify that %s was the one to steal them. However, if you both blame the other, you'll both go to jail. Will you %s?",
        "You and %s participated in a bank robbery. The police have enough evidence to convict you unless you testify against %s. However, if you both testify against each other, you'll recieve an even greater sentence. Will you %s?",
        "You were the passenger in %s's hit and run. The victim's family is pressuring the police to charge you, but they have no direct evidence. If you blame %s for the crime, they'll have enough to arrest them, but if you both deny, they may not be able pursue further. Will you %s?",
        "You and hacked into a government system using %s's computer. The authorities are investigating, but they can't trace it directly back to you unless you confess. However, if %s knows you did it and you %s, the consequences will be severe. Will you confess to hacking?",
        "%s committed tax fraud while helping you fill out finantial documents. The IRS is suspicious of your financial activities, but they lack concrete evidence. If you disclose everything, you might be able to clear your name and bring %s to justice, but if you both %s, they might sentence you both with negligence. Do you disclose your college's actions?",
        "You and %s were caught possessing illegal substances, but they can't prove you were selling them. You might get away scott free if you claim %s was selling them. However, if you claim to both be users, you'll both recieve a much lighter sentence. Will you admit to distributing?",
        "You and %s were involved in an insider trading scandal. The SEC is investigating, but they need your testimony to build a case. If you both refuse to cooperate, they may struggle to prove anything. Will you testify against your college?",
        "You and %s committed arson. The fire department suspects foul play, but they lack direct evidence. If you admit to starting the fire, they'll have enough to arrest you, but if you and %s both %s, they may not pursue further. Will you plead accident?",
        //"You and %s stole a valuable painting from a museum. The museum has security footage of you, but they haven't identified you yet. If you turn yourself in, they'll go easy on you, but if you both %s, they may never catch you. Will you %s?",
        //"You and %s were caught bribing a public official. The authorities are investigating corruption, and they suspect you're involved. If you provide evidence against others, they may reduce your punishment, but if you both %s, they'll intensify their scrutiny. Will you cooperate with the investigation?"
    };

    private static final String[] DENY_SYNONYMS = {
        "deny the crime", "stay silent", "refuse to admit", "keep quiet"
    };
    
    // Random object to generate random numbers
    public static final Random RANDOM = new Random();

    /**
     * Constructor for the Crime class.
     * Initializes the JTextArea with a random crime scenario.
     */
    public Crime() {
        super(5, 20); // Setting default rows and columns for the JTextArea
        this.setText(getRandomCrime());
        //this.setEditable(false);
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
        String associate = NAMES[RANDOM.nextInt(NAMES.length)];
        String crimeTemplate = CRIMES[RANDOM.nextInt(CRIMES.length)]; //RANDOM.nextInt(CRIMES.length)];
        String denySynonym = DENY_SYNONYMS[RANDOM.nextInt(DENY_SYNONYMS.length)];

        return String.format(crimeTemplate, associate, associate, denySynonym);
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