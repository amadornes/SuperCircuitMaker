package com.amadornes.scm.api.circuit;

import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.math.CircuitPos;
import com.amadornes.scm.api.util.CircuitSlot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public interface IComponentData {

    IComponentHost getHost();

    CircuitPos getPos();

    IWorld getRealWorld();

    BlockPos getRealPos();

    EnumFacing getRealFacing(CircuitDirection direction);

    CircuitDirection getInternalDirection(EnumFacing facing);

    IUpdateQueue getUpdateQueue();

}
