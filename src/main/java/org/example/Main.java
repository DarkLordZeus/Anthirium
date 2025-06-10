package org.example;

import org.example.block.Block;
import org.example.mine.nodes.Node;
import org.example.mine.peer.PeerServer;
import org.example.block.BlockData;
import org.example.core.BlockChain;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java Main <port> [peer1] [peer2] ...");
            return;
        }

        int myPort = Integer.parseInt(args[0]);
        BlockChain blockchain = new BlockChain();
        List<Socket> peers = new ArrayList<>();

        // 1. Start server on this node's port
        new Thread(new PeerServer(myPort, blockchain)).start();
        System.out.println("Node started on port " + myPort);

        // 2. Connect to peers if any are passed
        Thread.sleep(30000);
        for (int i = 1; i < args.length; i++) {
            int peerPort = Integer.parseInt(args[i]);
            try {
                Socket socket = new Socket("localhost", peerPort);
                peers.add(socket);
                System.out.println("Connected to peer at port " + peerPort);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to connect to peer at port " + peerPort);
            }
        }

        // 3. Start the node and broadcast a block
        Node node = new Node(peers,blockchain);
        node.addBlockInNode();   // add a block to this node
        node.broadcast();        // broadcast to peers


        while (true){
            Thread.sleep(5000);
            node.addBlockInNode();   // add a block to this node
            node.broadcast();
           // System.out.println(blockchain.getBlockchain().stream().map(e->(e.getData().getTransactionData()+e.getData().getBlockId())).toList());
        }


    }
}
