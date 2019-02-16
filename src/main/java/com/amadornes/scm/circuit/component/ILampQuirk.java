package com.amadornes.scm.circuit.component;

import com.amadornes.scm.api.circuit.component.quirk.IQuirk;

public interface ILampQuirk extends IQuirk {

    int getInputs();

    void setInputs(int inputs);

}
