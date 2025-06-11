//package org.example.callable;
//
//import org.example.core.BlockChain;
//import org.example.storage.BlockChainDto;
//import org.example.storage.BlockChainStorage;
//
//public class BlockChainManager {
//
//    public BlockChain createBlockChain(String name){
//        if(BlockChainStorage.blockChainsStoredAndManaged.stream().anyMatch(bc-> bc.getName().equals(name)))
//            throw new RuntimeException("Block chain with this name already exists");
//        BlockChain newBlockChain = new BlockChain(name.hashCode(),name);
//        BlockChainDto blockChainDto = new BlockChainDto();
//        blockChainDto.setName(name);
//        blockChainDto.setBlockChain(newBlockChain);
//        BlockChainStorage.blockChainsStoredAndManaged.add(blockChainDto);
//        return newBlockChain;
//    }
//}
