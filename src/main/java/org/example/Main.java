package org.example;

import org.example.BlockChainObserver.Observer;
import org.example.BlockChainObserver.ObserverInterface;
import org.example.block.BlockData;
import org.example.callable.BlockChainManager;
import org.example.core.BlockChain;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BlockChainManager blockChainManager = new BlockChainManager();
        BlockChain doggie=   blockChainManager.createBlockChain("doggie");
        doggie.add( new BlockData("TAX1"));
        doggie.add( new BlockData("TAX2"));
        doggie.add( new BlockData("TAX3"));
        for(int i=0;i<4;i++){
            doggie.addObserver(new Observer("gaurav"+i));
        }
    }
}