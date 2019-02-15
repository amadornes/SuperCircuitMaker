package com.amadornes.scm.client;

import com.amadornes.scm.SuperCircuitMaker;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperCircuitMaker.MODID)
public class CircuitRenderer {

    @SubscribeEvent
    public static void onRenderLast(RenderWorldLastEvent event) {

    }

}
