package org.example.BlockChainObserver;

import org.example.block.Block;
import org.example.core.BlockChain;

import java.util.ArrayList;

public class Observer implements  ObserverInterface {
    private ArrayList<Integer>  data;
    private final String name;
    private final ArrayList<String> blockChains = new ArrayList<>();
    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(ArrayList<Block> blocks, String nameOfBlk) {

        System.out.println(name + " got a new update in blockchain : " + nameOfBlk + "with total TXNS : " + blocks.size() + "and BlockChain : " + blocks);

    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addBlockChainToObs(String blockchainName){
        blockChains.add(blockchainName);
    }

    public  ArrayList<String> getBlockChains(){
        return blockChains;
    }



}
