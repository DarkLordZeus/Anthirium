package org.Anthirium.core.interfaces;

import org.Anthirium.block.Block;
import org.Anthirium.block.BlockData;

import java.util.ArrayList;

public interface BlockChainInterface {
    void add(BlockData data);

    public boolean validate(ArrayList<Block> blockchain);


}
