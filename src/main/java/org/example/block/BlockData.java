package org.example.block;

public class BlockData {
    private static int uid =1;
    private final int blockId;
    private final String transactionData;

    public BlockData(String transactionData) {
        this.blockId = uid++;

        this.transactionData = transactionData;
    }

    public String getTransactionData() {
        return transactionData;
    }

    public int getBlockId() {
        return blockId;
    }
}
