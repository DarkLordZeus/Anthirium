package org.example.mine.miners;

import org.example.core.BlockChain;
import org.example.mine.nodes.Node;
import org.example.utils.Helpers;

import java.net.Socket;
import java.util.List;
import java.util.Objects;

public class Miner extends Node implements minerInterface{

    private int noonce=1;

    public Miner(List<Socket> peers, BlockChain blockchain) {
        super(peers,blockchain);
        mine();
    }

    @Override
    public void mine() {
        while(true){
            String hashFound=  Helpers.sha256(super.getBlockchain().getBlockchain().getLast().getPrevBlockHash()+
                    super.getBlockchain().getBlockchain().getLast().getData().hashCode()
                    +(noonce++));

            if(hashFound.substring(0,BlockChain.difficulty).equals("0".repeat(BlockChain.difficulty))){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                addBlockInNode();
                broadcast();
            }

        }

    }


}
