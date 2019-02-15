package com.amadornes.scm.tile;

import com.amadornes.scm.init.SCMBlocks;
import net.minecraft.tileentity.TileEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TileCircuit extends TileEntity {

    private static final Logger LOGGER = LogManager.getLogger();

    private boolean loaded = false;

    public TileCircuit() {
        super(SCMBlocks.CIRCUIT_TILE);
    }

}
