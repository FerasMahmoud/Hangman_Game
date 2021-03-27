
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
 * Firas Mahmoud  | 1845407
 * Abdulaziz Ajaj | 1854387
 */
/**
 *
 * @authors Abdulaziz and Firas
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        BufferedReader stdIn;

        /**
         * This is where we try to create a new client and connect it
         * to a server.
         */
        try {
            Scanner scn = new Scanner(System.in);
            //create connection with the server 
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost");
            clientSocket = new Socket(ip, 5000);
            //create IO streams:
            //out to the server
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            //read from the server
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //ask the client to input something
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            //welcome to the server
            System.out.println(in.readLine());
            boolean f1 = true;
            while (f1) {
                //enter anything to start a new hangman game
                System.out.println(in.readLine());
                //taking client's choice
                String choice = scn.next();
                //sending client's choice to the server
                if (choice.toLowerCase().equals("exit")) {
                    out.println(choice);
                    System.out.println("Exitting the server...  Good bye");
                    break;
                }
                out.println(choice); // send choice
                System.out.println(in.readLine());//welcome hangman

                while (true) {
                    String ex = in.readLine();
                    if (ex.equals("exit")) {
                        break;
                    }
                    System.out.println(ex + "\n" + in.readLine() + in.readLine() + "\n" + in.readLine() + "\n");//Guess any ...
                    String letter = scn.next(); // send letter
                    if (letter.equals("exit")) {
                        System.out.println("Exitting the server...  Good bye");
                    }
                    out.println(letter);
                }
                System.out.println(in.readLine());//win or lose ...
                System.out.println(in.readLine());//score ...
            }

            scn.close();
        } catch (Exception e) {

        }
    }
}
