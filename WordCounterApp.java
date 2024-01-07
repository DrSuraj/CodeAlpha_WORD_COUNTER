import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    private JLabel resultLabel;
    private JTextArea textArea;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resultLabel = new JLabel("Word Count: 0");
        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Layout setup
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(scrollPane)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(countButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultLabel)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addGroup(layout.createParallelGroup()
                        .addComponent(countButton)
                        .addComponent(resultLabel)));

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        resultLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp().setVisible(true);
            }
        });
    }
}
