package org.example.transaction;

public class TransactionData {
    private final String signature;
    private final Object TransactionData;
    private final Integer timestampInEpoch;

    public TransactionData(String signature, Object transactionData, Integer timestampInEpoch) {
        this.signature = signature;
        this.TransactionData = transactionData;
        this.timestampInEpoch = timestampInEpoch;
    }

    public Object getTransactionData() {
        return TransactionData;
    }

    public String getSignature() {
        return signature;
    }

    public Integer getTimestampInEpoch() {
        return timestampInEpoch;
    }
}
