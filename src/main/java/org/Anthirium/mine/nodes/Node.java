package org.Anthirium.mine.nodes;



import com.google.gson.Gson;
import org.Anthirium.block.BlockData;
import org.Anthirium.core.BlockChain;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Node implements nodeInterface {

    private final BlockChain blockchain;
    private final List<Socket> peers;
    private static int count=1;

    public Node(List<Socket> peers, BlockChain blockchain) {
        this.peers = peers;
        this.blockchain =blockchain;
    }

    @Override
    public boolean isChainValid() {
        return blockchain.validate(blockchain.getBlockchain());
    }

    @Override
    public void addBlockInNode() {
        blockchain.add(new BlockData("new data"));
    }

    @Override
    public void broadcast() {
        System.out.println(peers.size());
        for (Socket peer : peers) {
            try {
                Socket socket = new Socket(peer.getInetAddress(), peer.getPort());  // fresh socket
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(new Gson().toJson(blockchain.getBlockchain()));
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public BlockChain getBlockchain(){
        return blockchain;
    }

}
