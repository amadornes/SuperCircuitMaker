package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;

public interface IComponentInterface {

    <Q extends IQuirk> Q getQuirk(Class<Q> type);

    boolean isConnectable(CircuitSlot slot, CircuitDirection direction);

    byte getStrongOutput(CircuitSlot slot, CircuitDirection direction);

    byte getWeakOutput(CircuitSlot slot, CircuitDirection direction);

    boolean isTopSolid();

}
