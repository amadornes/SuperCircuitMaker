package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.util.CircuitSlot;

import java.util.EnumSet;

public interface IComponentType<I extends IComponentInterface, B extends IComponentBehavior> {

    EnumSet<CircuitSlot> getSlots();

    boolean requiresTicks();

    Instance<I, B> create(IComponentData info);

    interface Instance<I extends IComponentInterface, B extends IComponentBehavior> {

        I getInterface();

        B getBehavior();

    }

}
