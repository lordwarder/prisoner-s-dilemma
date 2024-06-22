import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class InterrogationPane extends JFrame {
    private Image backgroundImage;

    public InterrogationPane() {
        // Load the background image
        backgroundImage = new ImageIcon("interrogationRoom.png").getImage();
        
        // Set up the frame
        setTitle("Custom Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());

        // Create and add the background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        add(backgroundPanel);

        // Set the initial size and make it visible
        setSize(800, 600);
        setVisible(true);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Draw the scaled image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            // Set layout and add components
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            //gbc.fill = GridBagConstraints.NONE;
            //gbc.insets = new Insets(10, 10, 10, 10);

            // Top-center aligned text box
            JTextField topTextBox = new JTextField(20);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 0.5;
            add(topTextBox, gbc);

            // Variable size gap
            gbc.gridy = 1;
            gbc.weighty = 0.5;
            add(Box.createVerticalGlue(), gbc);

            // Mid-center aligned text box
            JTextField midTextBox = new JTextField(20);
            gbc.gridy = 2;
            gbc.weighty = 0.5;
            add(midTextBox, gbc);

            // Two buttons at the bottom
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
            JButton button1 = new JButton("Button 1");
            JButton button2 = new JButton("Button 2");
            buttonPanel.add(button1);
            buttonPanel.add(button2);

            gbc.gridy = 3;
            gbc.weighty = 0.5;
            gbc.anchor = GridBagConstraints.PAGE_END;
            add(buttonPanel, gbc);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterrogationPane());
    }
}
