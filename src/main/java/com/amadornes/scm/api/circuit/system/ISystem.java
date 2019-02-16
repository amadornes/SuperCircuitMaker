package com.amadornes.scm.api.circuit.system;

import com.amadornes.scm.api.circuit.component.IComponentInfo;
import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.stream.Stream;

public interface ISystem<Q extends IQuirk> extends INBTSerializable<NBTTagCompound> {

    void update(Stream<IComponentInfo<Q>> components);

    @Override
    default NBTTagCompound serializeNBT() {
        return null;
    }

    @Override
    default void deserializeNBT(NBTTagCompound tag) {
    }

}
