/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylittleconcert_servertcp_alexis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class client_recived extends Thread {

    private Socket clientSocket;

    public client_recived(Socket Socket) {
        clientSocket = Socket;

    }

    @Override
    public void run() {
        try {
            System.out.println("......... CLIENT CONNECTION " + clientSocket.getInetAddress().toString() + " PORT: " + clientSocket.getPort());
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String messege = "WELCOME TO MY LITTLE CONCERT e-TICKETING SERVER \n WAITING YOUR BOOKING REQUEST";
            bw.write(messege);
            bw.newLine();
            bw.flush();
            String client_asnware = br.readLine();

            String[] concertname = client_asnware.toLowerCase().split(",");

            String allinfo = "";
            Date date = new Date();

            if (concertname[0].equals("rihanna")) {

                if (concertname[2].equals("vip")) {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 200 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                } else {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 100 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                }

            } else if (concertname[0].equals("one direction")) {
                if (concertname[2].equals("vip")) {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 225 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                } else {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 125 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                }
            } else if (concertname[0].equals("madonna")) {

                if (concertname[2].equals("vip")) {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 250 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                } else {
                    allinfo = date.toString() + "Concert: " + concertname[0] + "   Price: 150 euros   Type: " + concertname[2] + "   Name:" + concertname[1];
                }

            } else {
                allinfo = "THERE´S AN ERROR IN BOOKING INFO";

            }
            bw.write(allinfo);
            bw.newLine();
            bw.flush();
            br.close();
            bw.close();
            clientSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(client_recived.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
