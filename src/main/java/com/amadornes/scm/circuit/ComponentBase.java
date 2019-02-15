package com.amadornes.scm.circuit;

import com.amadornes.scm.api.circuit.*;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.math.CircuitPos;
import com.amadornes.scm.api.util.CircuitSlot;

public class ComponentBase implements IComponentInterface, IComponentBehavior {

    private IComponentData info;

    protected ComponentBase() {
    }

    final void setInfo(IComponentData info) {
        this.info = info;
    }

    protected final IComponentHost getHost() {
        return info.getHost();
    }

    protected final CircuitPos getPos() {
        return info.getPos();
    }

    protected final IUpdateQueue getUpdateQueue() {
        return info.getUpdateQueue();
    }

    @Override
    public boolean isConnectable(CircuitSlot slot, CircuitDirection direction) {
        return false;
    }

    @Override
    public byte getStrongOutput(CircuitSlot slot, CircuitDirection direction) {
        return 0;
    }

    @Override
    public byte getWeakOutput(CircuitSlot slot, CircuitDirection direction) {
        return 0;
    }

    @Override
    public boolean isTopSolid() {
        return false;
    }

    @Override
    public void tick() {
    }

    @Override
    public void onQueuedUpdates() {
    }

    protected final boolean isNeighborConnectable(CircuitSlot slot, CircuitDirection direction) {
        return getHost().getComponent(getPos().offset(direction), slot).isConnectable(slot, direction.getOpposite());
    }

    protected final int getStrongInput(CircuitSlot slot, CircuitDirection direction) {
        return getHost().getComponent(getPos().offset(direction), slot).getStrongOutput(slot, direction.getOpposite());
    }

    protected final int getWeakInput(CircuitSlot slot, CircuitDirection direction) {
        return getHost().getComponent(getPos().offset(direction), slot).getWeakOutput(slot, direction.getOpposite());
    }

    public static abstract class Type<C extends ComponentBase> implements IComponentType<C, C> {

        protected abstract C create();

        @Override
        public boolean requiresTicks() {
            return false;
        }

        @Override
        public final Instance<C, C> create(IComponentData info) {
            C c = create();
            c.setInfo(info);
            return new ComponentBase.Instance<>(c);
        }

    }

    private static final class Instance<C extends ComponentBase> implements IComponentType.Instance<C, C> {

        private final C component;

        private Instance(C component) {
            this.component = component;
        }

        @Override
        public C getInterface() {
            return component;
        }

        @Override
        public C getBehavior() {
            return component;
        }

    }

}
