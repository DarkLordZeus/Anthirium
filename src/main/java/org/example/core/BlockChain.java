package org.example.core;

import org.example.BlockChainObserver.Observer;
import org.example.BlockChainObserver.ObserverInterface;
import org.example.block.Block;
import org.example.block.BlockData;
import org.example.core.interfaces.BlockChainInterface;
import org.example.core.interfaces.BlockChainObsInterface;

import java.util.ArrayList;

public class BlockChain implements BlockChainInterface, BlockChainObsInterface {
    private final  String name;
    private final int uniqueId;
    private final ArrayList<Block> blockchain = new ArrayList<>();
    private final ArrayList<ObserverInterface> observers = new ArrayList<>();


    public BlockChain(int uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }


    @Override
    public void add(BlockData data) {
        int prevHash=  blockchain.isEmpty()?0:blockchain.getLast().getBlockHash();
        Block block = new Block(data,prevHash);
        blockchain.add(block);
        notifyObservers();
        System.out.println(blockchain);
    }

    @Override
    public void validate() {
        for(int i = 1; i < blockchain.size(); i++){
            Block current = blockchain.get(i);
            Block previous = blockchain.get(i - 1);

            // 1. Check previous hash consistency
            if (current.getPrevBlockHash() !=  previous.getBlockHash()) {
                System.out.println("❌ Invalid chain at block " + i + ": Previous hash mismatch.");
                return;
            }

            // 2. Check current block's hash correctness
            //! Stored hash must be same as expected hash
            int expectedHash = Integer.hashCode(current.getData().hashCode() + current.getPrevBlockHash());
            if (current.getBlockHash() != expectedHash) {
                System.out.println("❌ Invalid block at " + i + ": Block hash incorrect.");
                return;
            }
        }
    }

    @Override
    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
        observer.addBlockChainToObs(name);

    }
    @Override
    public void removeObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ObserverInterface observer : observers){
            observer.update(blockchain,name);
        }
    }


    public int getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Observer> getAllObservers(){
        ArrayList<Observer> observers = new ArrayList<>();
        for(ObserverInterface obs : this.observers){
            observers.add((Observer) obs);
        }
        return observers;

    }



}
