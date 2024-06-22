import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageButtonExample extends JFrame {

    public ImageButtonExample() {
        // Set up the frame
        setTitle("Main Menu");
        Dimension fixedSize = new Dimension(800, 600);
        setPreferredSize(fixedSize);
        setMinimumSize(fixedSize);
        setMaximumSize(fixedSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Load the background image
        ImageIcon originalImageIcon = new ImageIcon("mainMenu.jpg");

        // Create a JTextField with a document filter to limit input to 10 characters
        JTextField textField = new JTextField(10);
        textField.setBounds(200, 100, 200, 30);

        // Scale the image to fit the frame
        Image scaledImage = originalImageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);

        // Create a JPanel with a null layout for absolute positioning
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // Create buttons with images
        ImageIcon buttonImageIcon1 = new ImageIcon("button1.png");
        JButton button1 = new JButton(buttonImageIcon1);
        button1.setBounds(200, 200, buttonImageIcon1.getIconWidth(), buttonImageIcon1.getIconHeight());
        panel.add(button1);

        ImageIcon buttonImageIcon2 = new ImageIcon("button1.png");
        JButton button2 = new JButton(buttonImageIcon2);
        button2.setBounds(200, 400, buttonImageIcon2.getIconWidth(), buttonImageIcon2.getIconHeight());
        panel.add(button2);
        
        // Add the image label to the panel
        imageLabel.setBounds(0, 0, getWidth(), getHeight());
        panel.add(imageLabel);
        
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                int newLength = fb.getDocument().getLength() - length + text.length();
                if (newLength <= 10) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                int newLength = fb.getDocument().getLength() + text.length();
                if (newLength <= 10) {
                    super.insertString(fb, offset, text, attr);
                }
            }
        });

        // Set up an action listener on the JTextField to call a button when Enter is pressed
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.doClick(); // Call button1's action when Enter is pressed
            }
        });

        panel.add(textField);

        // Add the panel to the frame
        add(panel);

        pack(); // Adjust the frame size to fit the preferred size of the panel
        setVisible(true); // Make the frame visible
    }

    @Override
    public void setSize(int width, int height) 
    {
        super.setSize(width, height);
        if (getContentPane().getComponentCount() > 0) 
        {
            // Reload and scale the background image to fit the new size
            ImageIcon originalImageIcon = new ImageIcon("mainMenu.jpg");
            Image scaledImage = originalImageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            ((JLabel)((JPanel)getContentPane()).getComponent(0)).setIcon(scaledImageIcon);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageButtonExample());
    }
}
