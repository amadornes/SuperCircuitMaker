package com.amadornes.scm.api.circuit.system;

import com.amadornes.scm.api.circuit.IComponentHost;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ISystemType<S extends ISystem> extends IForgeRegistryEntry<ISystemType<?>> {

    S create(IComponentHost host);

}
