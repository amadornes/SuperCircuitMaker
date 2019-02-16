package com.amadornes.scm.init;

import com.amadornes.scm.api.circuit.component.IComponentItem;
import net.minecraft.nbt.INBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class SCMCapabilities {

    public static void register() {
        CapabilityManager.INSTANCE.register(IComponentItem.class, new NullStorage<>(), () -> null);
    }

    private static final class NullStorage<T> implements Capability.IStorage<T> {

        @Nullable
        @Override
        public INBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<T> capability, T instance, EnumFacing side, INBTBase nbt) {
        }

    }

}
