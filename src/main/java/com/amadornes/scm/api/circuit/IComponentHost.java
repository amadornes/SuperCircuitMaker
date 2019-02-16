package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.circuit.component.IComponentInterface;
import com.amadornes.scm.api.circuit.component.IComponentType;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.math.CircuitPos;
import com.amadornes.scm.api.util.CircuitSlot;

import java.util.EnumSet;

public interface IComponentHost {

    boolean isValidPosition(CircuitPos pos);

    IComponentInterface getComponent(CircuitPos pos, CircuitSlot slot);

    <I extends IComponentInterface> I placeComponent(CircuitPos pos, IComponentType<I, ?> componentType);

    boolean removeComponent(CircuitPos pos, CircuitSlot slot);

    EnumSet<CircuitDirection> getAdjacentEdges(CircuitPos pos);

}
