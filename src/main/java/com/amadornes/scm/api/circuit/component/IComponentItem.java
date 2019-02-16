package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.circuit.IComponentHost;
import com.amadornes.scm.api.math.CircuitPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public interface IComponentItem {

    @CapabilityInject(IComponentItem.class)
    Capability<IComponentItem> CAPABILITY = null;

    boolean place(IComponentHost host, CircuitPos pos);

}
