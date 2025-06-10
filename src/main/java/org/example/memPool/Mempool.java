package org.example.memPool;

import org.example.transaction.TransactionData;

import java.util.ArrayList;

public class Mempool {
    public static final ArrayList<TransactionData> transactions = new ArrayList<>();
    public static final ArrayList<TransactionData> transactionsInProgress = new ArrayList<>();
}
