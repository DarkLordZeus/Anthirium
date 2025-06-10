package org.example.mine.miners;

import org.example.core.BlockChain;
import org.example.mine.nodes.Node;

import java.net.Socket;
import java.util.List;
import java.util.Objects;

public class Miner extends Node implements minerInterface{

    private int noonce=1;

    public Miner(List<Socket> peers, BlockChain blockchain) {
        super(peers,blockchain);
    }

    @Override
    public void mine() {
        while(true){
            int hashFound=  Objects.hashCode(super.getBlockchain().getBlockchain().getLast().getPrevBlockHash()+
                    super.getBlockchain().getBlockchain().getLast().getData().hashCode()
                    +(noonce++));



        }

    }


}
