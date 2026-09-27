import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chatbot {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ChatbotEngine bot = new ChatbotEngine();

    ArrayList<String> conversationHistory = new ArrayList<>();

    System.out.println("=================================");
    System.out.println("          AI CHATBOT");
    System.out.println("=================================");
    System.out.println("Hello! I am your chatbot.");
    System.out.println("Type 'history' to see the conversation.");
    System.out.println("Type 'bye' to exit.");

    while (true) {

        System.out.print("\nYou: ");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("bye") ||
            input.equalsIgnoreCase("exit")) {

            System.out.println("Bot: Goodbye! Have a nice day.");
            break;
        }

        // Display conversation history
        if (input.equalsIgnoreCase("history")) {

            System.out.println("\n--- Conversation History ---");

            if (conversationHistory.isEmpty()) {
                System.out.println("No conversation yet.");
            } else {
                for (String message : conversationHistory) {
                    System.out.println(message);
                }
            }

            continue;
        }
        String response = bot.getResponse(input);

System.out.println("Bot: " + response);

// Get current date and time
LocalDateTime now = LocalDateTime.now();

DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

String time = now.format(formatter);

// Save conversation with timestamp
conversationHistory.add("[" + time + "] You: " + input);
conversationHistory.add("[" + time + "] Bot: " + response);
       
    }

    sc.close();
    }
}