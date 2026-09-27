# AI Chatbot using Java

## Project Description

This project is a simple rule-based AI chatbot developed using Java.
The chatbot accepts user input, processes the text, identifies keywords
and provides suitable responses using a predefined FAQ system.

## Features

- Greeting responses
- Java-related questions
- OOP-related questions
- Programming-related questions
- FAQ-based responses
- Text preprocessing
- Conversation history
- Conversation timestamps
- Exit command

## Technologies Used

- Java
- Object-Oriented Programming
- Java ArrayList
- Java Scanner
- Basic NLP-style text preprocessing

## Project Structure

AIChatbot
│
├── Chatbot.java
├── ChatbotEngine.java
├── FAQ.java
└── README.md

## How to Run

Compile the Java files:

javac Chatbot.java ChatbotEngine.java FAQ.java

Run the chatbot:

java Chatbot

## Example

You: hello

Bot: Hello! How can I help you?

You: what is java

Bot: Java is a popular object-oriented programming language.

You: what is oop

Bot: OOP stands for Object-Oriented Programming. It uses objects and classes.

You: history

The chatbot displays the previous conversation with timestamps.

You: bye

Bot: Goodbye! Have a nice day.

## Working

1. The user enters a message.
2. The chatbot converts the input to lowercase.
3. Unnecessary special characters are removed.
4. The input is compared with predefined FAQ questions.
5. A suitable response is returned.
6. The conversation is stored with a timestamp.

## Future Improvements

- Add more FAQ questions.
- Add a graphical user interface.
- Add voice input and output.
- Connect the chatbot to a database.
- Use a machine-learning NLP model for more advanced responses.