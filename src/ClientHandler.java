
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * Firas Mahmoud  | 1845407
 * Abdulaziz Ajaj | 1854387
 */

/**
 *
 * @authors Abdulaziz & Firas
 */
public class ClientHandler extends Thread implements Runnable {

    static Socket clientSocket = null;
    //static BufferedReader in;
    //static PrintWriter out;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {

        try {
            int score = 0;
            //receiving information from the client through this buffered reader
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //sending output to the client through this printWriter
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to the server");

            while (true) {
                out.println("Enter anything to start the game or 'Exit' to leave from the server");
                String choice = in.readLine();
                if (choice.toLowerCase().equals("exit")) {
                    //out.println("Exitting the server...  Good bye");
                    System.out.println("Client " + clientSocket.getPort() + " has exitted the server");
                    clientSocket.close();
                    break;
                }
                String word = getRandomWord().toLowerCase();
		System.out.println("The server Chose the word: "+ word);
                hangmanGame g = new hangmanGame(clientSocket, in, out,word);
                score += g.getScore();
                out.print(g.getString() + score + "\n");
            }
        } catch (Exception e) {

        }
    }
	ArrayList<String> words = new ArrayList<>();
	/**
     * this method gets us a random word every time the game starts.
     * @return a random word 
     */
      
    public String getRandomWord() {
        
        try (Scanner sc = new Scanner(new File("words.txt"))) {
            while (sc.hasNext()) {
                String str = sc.next();
                words.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        int index = new Random().nextInt(words.size());
        return words.get(index);
    }

}
