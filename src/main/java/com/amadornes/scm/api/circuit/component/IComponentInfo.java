package com.amadornes.scm.api.circuit.component;

import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.math.CircuitPos;

public interface IComponentInfo<Q extends IQuirk> {

    Q getQuirk();

    CircuitPos getPos();

    IUpdateQueue getUpdates();

    void markCommit();

    void markSave();

    void notifyClients(String... keys);

    void notifySignalUpdate(CircuitDirection... directions);

}
