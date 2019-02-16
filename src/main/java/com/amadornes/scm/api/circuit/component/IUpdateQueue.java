package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.math.CircuitDirection;

import java.util.EnumSet;

public interface IUpdateQueue {

    boolean isEmpty();

    EnumSet<CircuitDirection> getAllUpdates();

    EnumSet<CircuitDirection> getRemovedComponents();

    EnumSet<CircuitDirection> getPlacedComponents();

    EnumSet<CircuitDirection> getUpdatedSignals();

}
