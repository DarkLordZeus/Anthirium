package org.Anthirium.mine.nodes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.Anthirium.block.Block;
import org.Anthirium.core.BlockChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PeerHandler implements Runnable {
    private Socket socket;
    private BlockChain blockchain;

    public PeerHandler(Socket socket, BlockChain blockchain) {
        this.socket = socket;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String incomingJson = in.readLine();
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Block>>() {}.getType();
            ArrayList<Block> peerChain = gson.fromJson(incomingJson, listType);
            if(peerChain==null){
                System.out.println("peer chain  null.");
            }
            // Check and replace if valid and longer
            else if (peerChain.size() <= blockchain.getBlockchain().size()){
                System.out.println("Received chain was shorter or equal.");
               // System.out.println(peerChain.stream().map((e)->(e.getData().getTransactionData()+e.getData().getBlockId())).toList()+"PEER CHAIN SHORTER");
            }
            else if (! blockchain.validate(peerChain)){
                System.out.println("Received chain was invalid or not longer.");
               // System.out.println(peerChain.stream().map((e)->(e.getData().getTransactionData()+e.getData().getBlockId())).toList()+"PEER CHAIN INVALID");
            }
            else  {
                blockchain.replaceChain(peerChain);
                System.out.println("Blockchain updated from peer!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
