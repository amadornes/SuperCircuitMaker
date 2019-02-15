package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;

public interface IComponentInterface {

    boolean isConnectable(CircuitSlot slot, CircuitDirection direction);

    byte getStrongOutput(CircuitSlot slot, CircuitDirection direction);

    byte getWeakOutput(CircuitSlot slot, CircuitDirection direction);

    boolean isTopSolid();

}
