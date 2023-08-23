import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountGUI extends JFrame {
    private JTextArea inputTextArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCountGUI() {
        setTitle("Word Count Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count: 0");

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextArea.getText();
                int wordCount = countWords(inputText);
                resultLabel.setText("Word count: " + wordCount);
            }
        });

        JScrollPane scrollPane = new JScrollPane(inputTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        add(buttonPanel, BorderLayout.SOUTH);

        add(resultLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCountGUI();
            }
        });
    }
}
