package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.math.CircuitDirection;

import java.util.EnumSet;

public interface IUpdateQueue {

    EnumSet<CircuitDirection> getAllUpdates();

    EnumSet<CircuitDirection> getRemovedComponents();

    EnumSet<CircuitDirection> getPlacedComponents();

    EnumSet<CircuitDirection> getUpdatedSignals();

    void queueSignalUpdate(CircuitDirection direction);

}
