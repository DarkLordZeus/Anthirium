package org.Anthirium.core.interfaces;

import org.Anthirium.BlockChainObserver.ObserverInterface;

public interface BlockChainObsInterface {
    void addObserver(ObserverInterface observer);

    void removeObserver(ObserverInterface observer);

    void notifyObservers();
}
