import javax.swing.*;
import java.awt.*;

public class SwingTextComponentsExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Swing Text Components Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // JLabel
        JLabel label = new JLabel("Label:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

        // JTextField
        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(textField, gbc);

        // Reset gridwidth and fill
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // JPasswordField
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(passwordField, gbc);

        // Reset gridwidth and fill
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // JTextArea
        JLabel textAreaLabel = new JLabel("Text Area:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(textAreaLabel, gbc);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(scrollPane, gbc);

        // Reset gridwidth and fill
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // JEditorPane
        JLabel editorPaneLabel = new JLabel("Editor Pane:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(editorPaneLabel, gbc);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText("<html><body><h1>HTML content</h1><p>This is a paragraph.</p></body></html>");
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(editorScrollPane, gbc);

        // Reset gridwidth and fill
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // JTextPane
        JLabel textPaneLabel = new JLabel("Text Pane:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(textPaneLabel, gbc);

        JTextPane textPane = new JTextPane();
        textPane.setText("This is a JTextPane with styled text.");
        JScrollPane textPaneScrollPane = new JScrollPane(textPane);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(textPaneScrollPane, gbc);

        // Adjust frame settings and make it visible
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
