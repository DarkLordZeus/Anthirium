package org.example.core.interfaces;

import org.example.BlockChainObserver.Observer;
import org.example.block.BlockData;

public interface BlockChainInterface {
    void add(BlockData data);

    public void validate();


}
