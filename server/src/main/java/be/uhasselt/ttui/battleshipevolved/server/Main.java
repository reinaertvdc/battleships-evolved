package be.uhasselt.ttui.battleshipevolved.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import be.uhasselt.ttui.battleshipevolved.Game;

/**
 * Main is the entry point for the Battleship Evolved server.
 */
public class Main {
    public final static int PLAYERAMOUNT = 4;
    private static ArrayList<Socket> mPlayers;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        mPlayers = new ArrayList<>();
        int count = 0;

        try {
            serverSocket = new ServerSocket(4004);
            System.out.println("The server started and listens to port 4004.");
            while(count < PLAYERAMOUNT) {
                Socket playerSocket = serverSocket.accept();
                System.out.println("Client " + count + " connected.");
                PlayerServer playerServer = new PlayerServer(playerSocket, count);
                playerServer.start();
                mPlayers.add(playerSocket);
                count++;
                System.out.println("Client " + count + " saved.");
                updateAmount();
                System.out.println("Clients notified.");
            }
            Game game = new Game();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4004");
        }
    }

    private static void updateAmount() {
        try {
            for (int i = 0; i < mPlayers.size(); i++) {
                PrintWriter outp = new PrintWriter(mPlayers.get(i).getOutputStream(), true);
                outp.println("Players " + mPlayers.size() + " " + PLAYERAMOUNT);
            }
        } catch (IOException e) {
            System.err.println("Could not send to client.");
        }
    }
}
