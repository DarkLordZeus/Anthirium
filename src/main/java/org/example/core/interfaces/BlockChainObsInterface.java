package org.example.core.interfaces;

import org.example.BlockChainObserver.Observer;
import org.example.BlockChainObserver.ObserverInterface;

public interface BlockChainObsInterface {
    void addObserver(ObserverInterface observer);

    void removeObserver(ObserverInterface observer);

    void notifyObservers();
}
