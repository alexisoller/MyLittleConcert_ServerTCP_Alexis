/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylittleconcert_servertcp_alexis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class MyLittleConcert_ServerTCP_Alexis {

    /**
     * @param args the command line arguments
     */
    private static final int PORT = 8888;
    private static final String MACHINE = "localhost";

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("********LITTLE TICKETING SERVER STARTED**********");
            System.out.println("BINDING TO SOCKET[" + MACHINE + "," + PORT + "}");
            System.out.println("ACCEPTING CLIENT CONECCTIONS...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                client_recived cr = new client_recived(clientSocket);
                cr.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(MyLittleConcert_ServerTCP_Alexis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
