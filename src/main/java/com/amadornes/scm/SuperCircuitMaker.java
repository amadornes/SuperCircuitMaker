package com.amadornes.scm;

import com.amadornes.scm.init.SCMCapabilities;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SuperCircuitMaker.MODID)
public class SuperCircuitMaker {

    public static final String MODID = "supercircuitmaker";
    private static final Logger LOGGER = LogManager.getLogger();

    public SuperCircuitMaker() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        SCMCapabilities.register();
    }

}
