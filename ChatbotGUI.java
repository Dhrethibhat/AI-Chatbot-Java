import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatbotGUI {

    private static ChatbotEngine bot = new ChatbotEngine();
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static DateTimeFormatter timeFormatter =
        DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {

        JFrame frame = new JFrame("AI Chatbot");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // =========================
        // HEADER
        // =========================

        JPanel header = new JPanel();
        header.setBackground(new Color(45, 85, 140));
        header.setPreferredSize(new Dimension(700, 70));
        header.setLayout(new BorderLayout());

        JLabel title = new JLabel("  AI CHATBOT");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitle = new JLabel("  Java-based Intelligent Assistant");
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        titlePanel.add(subtitle);

        header.add(titlePanel, BorderLayout.CENTER);

        // =========================
        // CHAT AREA
        // =========================

        chatArea = new JTextArea();

        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));
        chatArea.setBackground(new Color(245, 247, 250));
        chatArea.setForeground(Color.DARK_GRAY);
        chatArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // =========================
        // INPUT FIELD
        // =========================

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));
        inputField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(190, 195, 200)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 10, 8, 10
                        )
                )
        );

        // =========================
        // BUTTONS
        // =========================

        JButton sendButton = new JButton("Send");
        JButton clearButton = new JButton("Clear Chat");
        JButton helpButton = new JButton("Help");

        sendButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 13));

        sendButton.setFocusPainted(false);
        clearButton.setFocusPainted(false);

        // =========================
        // INPUT PANEL
        // =========================

        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 5, 10)
        );

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // =========================
        // BOTTOM PANEL
        // =========================

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel clearPanel = new JPanel(
                new FlowLayout(FlowLayout.RIGHT)
        );
        clearPanel.add(helpButton);
        clearPanel.add(clearButton);

        bottomPanel.add(clearPanel, BorderLayout.SOUTH);

        // =========================
        // ADD COMPONENTS
        // =========================

        frame.add(header, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // =========================
        // WELCOME MESSAGE
        // =========================

        chatArea.append(
                "Bot: Hello! I am your Java AI chatbot.\n"
        );

        chatArea.append(
                "Bot: Ask me about Java, OOP or programming.\n\n"
        );

        // =========================
        // SEND BUTTON
        // =========================

        sendButton.addActionListener(e -> sendMessage());

        // Enter key
        inputField.addActionListener(e -> sendMessage());

        // Clear button
        clearButton.addActionListener(e -> clearChat());
        helpButton.addActionListener(e -> showHelp());

        // =========================
        // FRAME SETTINGS
        // =========================

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // =========================
    // SEND MESSAGE
    // =========================

    private static void sendMessage() {

        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            return;
        }

        String currentTime =
        LocalTime.now().format(timeFormatter);

chatArea.append(
        "[" + currentTime + "] You: " + input + "\n"
);

        if (input.equalsIgnoreCase("bye") ||
            input.equalsIgnoreCase("exit")) {

            chatArea.append(
                    "Bot: Goodbye! Have a nice day.\n"
            );

            inputField.setEnabled(false);

            return;
        }

        inputField.setEnabled(false);

        chatArea.append("Bot: Typing...\n");

        Timer timer = new Timer(800, e -> {

            String response = bot.getResponse(input);

            String currentText = chatArea.getText();

            currentText = currentText.replace(
                    "Bot: Typing...\n",
                    ""
            );

            chatArea.setText(currentText);

            String botTime =
        LocalTime.now().format(timeFormatter);

chatArea.append(
        "[" + botTime + "] Bot: " + response + "\n\n"
);

            inputField.setText("");
            inputField.setEnabled(true);
            inputField.requestFocus();

            chatArea.setCaretPosition(
                    chatArea.getDocument().getLength()
            );
        });

        timer.setRepeats(false);
        timer.start();
    }

    // =========================
    // CLEAR CHAT
    // =========================

    private static void clearChat() {

        chatArea.setText("");

        chatArea.append(
                "Bot: Chat cleared.\n"
        );

        chatArea.append(
                "Bot: How can I help you?\n\n"
        );
    }
    private static void showHelp() {

    String helpMessage =
            "Available Topics:\n\n" +
            "• Java\n" +
            "• JDK / JRE / JVM\n" +
            "• OOP\n" +
            "• Class and Object\n" +
            "• Inheritance\n" +
            "• Polymorphism\n" +
            "• Encapsulation\n" +
            "• Abstraction\n" +
            "• Exception Handling\n" +
            "• ArrayList / HashMap\n" +
            "• Programming\n" +
            "• Algorithms\n" +
            "• Debugging";

    JOptionPane.showMessageDialog(
            null,
            helpMessage,
            "Chatbot Help",
            JOptionPane.INFORMATION_MESSAGE
    );
}
}