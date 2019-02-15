package com.amadornes.scm.circuit.component;

import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;
import com.amadornes.scm.circuit.ComponentBase;

import java.util.EnumSet;

public class ComponentLamp extends ComponentBase {

    private int inputs = 0;

    private ComponentLamp() {
    }

    @Override
    public boolean isConnectable(CircuitSlot slot, CircuitDirection direction) {
        return slot == CircuitSlot.BOTTOM;
    }

    @Override
    public void onQueuedUpdates() {
        for (CircuitDirection direction : getUpdateQueue().getAllUpdates()) {
            inputs &= ~(1 << direction.ordinal());
            if (getStrongInput(CircuitSlot.BOTTOM, direction) > 0) {
                inputs |= (1 << direction.ordinal());
            }
        }
    }

    public static class Type extends ComponentBase.Type<ComponentLamp> {

        @Override
        protected ComponentLamp create() {
            return new ComponentLamp();
        }

        @Override
        public EnumSet<CircuitSlot> getSlots() {
            return EnumSet.of(CircuitSlot.BOTTOM, CircuitSlot.CENTER);
        }

    }

}
