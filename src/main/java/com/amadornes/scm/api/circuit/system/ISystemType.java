package com.amadornes.scm.api.circuit.system;

import com.amadornes.scm.api.circuit.IComponentHost;

public interface ISystemType<S extends ISystem> {

    S create(IComponentHost host);

}
