package org.example.mine.peer;


import org.example.core.BlockChain;
import org.example.mine.nodes.PeerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PeerServer implements Runnable {
    private final int port;
    private final BlockChain blockchain;

    public PeerServer(int port, BlockChain blockchain) {
        this.port = port;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening for peers on port " + port);
            while (true) {
                Socket peerSocket = serverSocket.accept();
                new Thread(new PeerHandler(peerSocket, blockchain)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}