package org.example.core.interfaces;

import org.example.block.Block;
import org.example.block.BlockData;

import java.util.ArrayList;

public interface BlockChainInterface {
    void add(BlockData data);

    public boolean validate(ArrayList<Block> blockchain);


}
