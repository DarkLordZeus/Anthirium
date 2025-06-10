package org.example.block;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class BlockData {

    private final String blockId;
    private final String transactionData;

    public BlockData(String transactionData) {
        this.blockId = UUID.randomUUID().toString();

        this.transactionData = transactionData;
    }

    public String getTransactionData() {
        return transactionData;
    }

    public String getBlockId() {
        return blockId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionData);
    }
}
