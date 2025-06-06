package org.example.BlockChainObserver;

import org.example.block.Block;
import org.example.core.BlockChain;

import java.util.ArrayList;

public interface ObserverInterface {
    public void update(ArrayList<Block> blocks, String name);
    public void addBlockChainToObs(String blockchainName);
    public String getName();
}
