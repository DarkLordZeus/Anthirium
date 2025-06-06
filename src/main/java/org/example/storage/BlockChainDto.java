package org.example.storage;

import org.example.core.BlockChain;

public class BlockChainDto {
    private String name;
    private BlockChain blockChain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlockChain getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(BlockChain blockChain) {
        this.blockChain = blockChain;
    }
}
