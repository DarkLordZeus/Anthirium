package org.Anthirium.BlockChainObserver;

import org.Anthirium.block.Block;

import java.util.ArrayList;

public interface ObserverInterface {
    public void update(ArrayList<Block> blocks, String name);
    public void addBlockChainToObs(String blockchainName);
    public String getName();
}
