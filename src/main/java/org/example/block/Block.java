package org.example.block;

import org.example.utils.Helpers;

public class Block {
    private final BlockData data;
    private final String blockHash;
    private final String prevBlockHash;

    public Block(BlockData data,String prevBlockHash){
        this.data = data;
        this.prevBlockHash=prevBlockHash;
        this.blockHash = Helpers.sha256(data.hashCode() + prevBlockHash);
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public BlockData getData() {
        return data;
    }
}
