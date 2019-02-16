package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.circuit.quirk.IQuirk;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;

public interface IComponentInterface {

    <T extends IQuirk> T getQuirk(Class<T> type);

    boolean isConnectable(CircuitSlot slot, CircuitDirection direction);

    byte getStrongOutput(CircuitSlot slot, CircuitDirection direction);

    byte getWeakOutput(CircuitSlot slot, CircuitDirection direction);

    boolean isTopSolid();

}
