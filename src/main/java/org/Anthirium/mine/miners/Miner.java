package org.Anthirium.mine.miners;

import org.Anthirium.core.BlockChain;
import org.Anthirium.mine.nodes.Node;
import org.Anthirium.utils.Helpers;

import java.net.Socket;
import java.util.List;

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
