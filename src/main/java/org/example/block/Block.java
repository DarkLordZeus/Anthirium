package org.example.block;

public class Block {
    private final Object data;
    private final int blockHash;
    private final int prevBlockHash;

    public Block(Object data,Integer prevBlockHash){
        this.data = data;
        this.prevBlockHash=prevBlockHash;
        this.blockHash = Integer.hashCode(data.hashCode() + prevBlockHash);
    }

    public int getBlockHash() {
        return blockHash;
    }

    public int getPrevBlockHash() {
        return prevBlockHash;
    }

    public Object getData() {
        return data;
    }
}
