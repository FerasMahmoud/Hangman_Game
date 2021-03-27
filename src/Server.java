
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


/*
 * Firas Mahmoud  | 1845407
 * Abdulaziz Ajaj | 1854387
 */

/**
 * The server class.
 * @author Abdulaziz & Firas
 * 
 */
public class Server {

    public static void main(String[] args) throws IOException {
        
        /**
         * We create a server socket to port 5000.
         */
        ServerSocket serverSocket = new ServerSocket(5000);
        /**
         * Send a message to the server so we know it started successfully.
         */
        System.out.println("Server has started...");
        
        /**
         * keep the server running, and accept incoming client requests.
         */
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client " + clientSocket.getPort() + " has joined the server.");
                Thread s = new ClientHandler(clientSocket);
                s.start();
            } catch (Exception e) {
            }
        }
    }
}
