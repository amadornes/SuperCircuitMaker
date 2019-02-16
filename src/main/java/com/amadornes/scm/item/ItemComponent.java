package com.amadornes.scm.item;

import com.amadornes.scm.api.circuit.IComponentHost;
import com.amadornes.scm.api.circuit.component.IComponentItem;
import com.amadornes.scm.api.math.CircuitPos;
import com.amadornes.scm.circuit.ComponentBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemComponent extends Item implements ICapabilityProvider, IComponentItem {

    private final ComponentBase.ComponentType<?> type;

    public ItemComponent(ComponentBase.ComponentType<?> type) {
        super(new Item.Properties());
        this.type = type;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return this;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable EnumFacing side) {
        return IComponentItem.CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this));
    }

    @Override
    public boolean place(IComponentHost host, CircuitPos pos) {
        return host.placeComponent(pos, type) != null;
    }

}
