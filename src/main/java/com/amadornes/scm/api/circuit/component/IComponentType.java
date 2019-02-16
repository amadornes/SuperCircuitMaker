package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.util.CircuitSlot;
import net.minecraft.state.StateContainer;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.EnumSet;
import java.util.Set;

public interface IComponentType<I extends IComponentInterface, C extends IComponent<I>> extends IForgeRegistryEntry<IComponentType<?, ?>> {

    void fillStateContainer(StateContainer.Builder<IComponentType<I, C>, IComponentState> builder);

    EnumSet<CircuitSlot> getSlots();

    Set<Class<? extends IQuirk>> getQuirks();

    C create();

}
