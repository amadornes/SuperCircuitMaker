package com.amadornes.scm.circuit;

import com.amadornes.scm.api.circuit.component.*;
import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.circuit.system.ISystem;
import com.amadornes.scm.api.circuit.system.ISystemType;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;
import com.amadornes.scm.api.util.IWorldUpdater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

public class ComponentBase<T extends ComponentBase<T>> implements IComponentInterface, IComponent<T> {

    protected ComponentBase() {
    }

    @Override
    public T getInterface() {
        return (T) this;
    }

    @Override
    public IBlockState getActualState(IBlockState state) {
        return state;
    }

    @Override
    public void commit() {
    }

    @Override
    public <Q extends IQuirk> Q getQuirk(Class<Q> type) {
        return null;
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
    public NBTTagCompound serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound tag) {
    }

    @Override
    public void serialize(String key, PacketBuffer buf) {
    }

    @Override
    public void deserialize(String key, PacketBuffer buf, IWorldUpdater updater) {
    }

    public static abstract class Type<C extends ComponentBase<C>, S extends ISystem<?>> implements IComponentType<C, C>, ISystemType<S> {

    }

}
