package org.example.core;

import org.example.block.Block;
import org.example.block.BlockData;
import org.example.core.interfaces.BlockChainInterface;
import org.example.utils.Helpers;

import java.util.ArrayList;
import java.util.Objects;

public class BlockChain implements BlockChainInterface {
    private ArrayList<Block> blockchain = new ArrayList<>();
    protected int blockMinedSince =0;
    public static int difficulty =1;
    public BlockChain() {
        blockchain.add(new Block(new BlockData("0"), "0"));
        startDifficultyThread();
    }



    @Override
    public void add(BlockData data) {
        String prevHash=  blockchain.getLast().getBlockHash();
        Block block = new Block(data,prevHash);
        blockMinedSince++;
        blockchain.add(block);
        //System.out.println(blockchain);
    }

    @Override
    public boolean validate(ArrayList<Block> blockchain) {
        for(int i = 1; i < blockchain.size(); i++){
            Block current = blockchain.get(i);
            Block previous = blockchain.get(i - 1);

            // 1. Check previous hash consistency
            if (!Objects.equals(current.getPrevBlockHash(), previous.getBlockHash())) {
                System.out.println("❌ Invalid chain at block " + i + ": Previous hash mismatch.");
                return false;
            }

            // 2. Check current block's hash correctness
            //! Stored hash must be same as expected hash
            String expectedHash = Helpers.sha256(current.getData().hashCode() + current.getPrevBlockHash());
            if (!Objects.equals(current.getBlockHash(), expectedHash)) {
                System.out.println("❌ Invalid block at " + i + ": Block hash incorrect.");
                return false;
            }
        }
        return true;
    }

    public ArrayList<Block> getBlockchain() {
        return blockchain;
    }

    public void replaceChain(ArrayList<Block> newChain) {
        if (newChain.size() > blockchain.size() && validate(newChain)) {
            int newBlocks = newChain.size()-blockchain.size();
            this.blockchain = newChain;
            System.out.println("\033[0;31m"+ "Block Size"+blockchain.size()+" : "+ blockchain.stream().map(e->(e.getData().getTransactionData()+e.getData().getBlockId())).toList()+"\033[0m");
            blockMinedSince+=newBlocks;
        }
    }

    private void startDifficultyThread() {
        Thread difficultyThread = new Thread(() -> {
            while (true) {
                System.out.println("blocked mine : "+blockMinedSince);
                if (blockMinedSince > 20) {
                    difficulty++;
                    blockMinedSince = blockMinedSince%20; // Optional: reset the counter
                    System.out.println("\033[0;32m" + "NEW DIFFICULTY AS : " + difficulty + "\033[0m");
                }
                try {
                    Thread.sleep(1000); // 1 second pause before checking again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break; // exit thread if interrupted
                }
            }
        });
        difficultyThread.setDaemon(true); // So it doesn’t block JVM exit
        difficultyThread.start();
    }
}
