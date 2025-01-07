package com.binance.example;

import java.io.Closeable;
import java.util.HashSet;
import java.util.Set;

public final class CloseableActionsHolder {

    private Set<Closeable> closeableSet = new HashSet<>();

    private final static CloseableActionsHolder INSTANCE = new CloseableActionsHolder();

    private CloseableActionsHolder() {
    }

    public static CloseableActionsHolder getInstance() {
        return INSTANCE;
    }

    public void addClosable(Closeable closeable) {
        this.closeableSet.add(closeable);
    }

    public Set<Closeable> getCloseableSet() {
        return this.closeableSet;
    }
}
