package com.amadornes.scm.circuit;

import com.amadornes.scm.api.circuit.IComponentHost;
import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.circuit.system.ISystem;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.math.CircuitPos;
import com.amadornes.scm.api.util.CircuitSlot;

public abstract class SystemBase<Q extends IQuirk> implements ISystem<Q> {

    protected final IComponentHost host;

    protected SystemBase(IComponentHost host) {
        this.host = host;
    }

    protected final boolean isNeighborConnectable(CircuitPos pos, CircuitSlot slot, CircuitDirection direction) {
        return host.getComponent(pos.offset(direction), slot).isConnectable(slot, direction.getOpposite());
    }

    protected final int getStrongInput(CircuitPos pos, CircuitSlot slot, CircuitDirection direction) {
        return host.getComponent(pos.offset(direction), slot).getStrongOutput(slot, direction.getOpposite());
    }

    protected final int getWeakInput(CircuitPos pos, CircuitSlot slot, CircuitDirection direction) {
        return host.getComponent(pos.offset(direction), slot).getWeakOutput(slot, direction.getOpposite());
    }

}
