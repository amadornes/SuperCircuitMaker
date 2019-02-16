package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.util.IWorldUpdater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.INBTSerializable;

public interface IComponent<I extends IComponentInterface> extends INBTSerializable<NBTTagCompound> {

    I getInterface();

    IBlockState getActualState(IBlockState state);

    void commit();

    @Override
    NBTTagCompound serializeNBT();

    @Override
    void deserializeNBT(NBTTagCompound tag);

    void serialize(String key, PacketBuffer buf);

    void deserialize(String key, PacketBuffer buf, IWorldUpdater updater);

}
