package com.amadornes.scm.init;

import com.amadornes.scm.SuperCircuitMaker;
import com.amadornes.scm.api.circuit.component.IComponentType;
import com.amadornes.scm.api.circuit.system.ISystemType;
import com.amadornes.scm.circuit.ComponentBase;
import com.amadornes.scm.circuit.component.ComponentLamp;
import com.amadornes.scm.item.ItemComponent;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SuperCircuitMaker.MODID)
public class SCMComponents {

    public static final ComponentBase.ComponentType<?> LAMP_COMPONENT = new ComponentLamp.ComponentType();
    public static final ComponentBase.SystemType<?> LAMP_SYSTEM = new ComponentLamp.SystemType();
    public static final Item LAMP_ITEM = new ItemComponent(LAMP_COMPONENT);

    @SubscribeEvent
    public static void onBlockRegistration(final RegistryEvent.Register<IComponentType<?, ?>> event) {
        IForgeRegistry<IComponentType<?, ?>> registry = event.getRegistry();

        registry.register(LAMP_COMPONENT.setRegistryName("lamp"));
    }

    @SubscribeEvent
    public static void onTileEntityRegistration(final RegistryEvent.Register<ISystemType<?>> event) {
        IForgeRegistry<ISystemType<?>> registry = event.getRegistry();

        registry.register(LAMP_SYSTEM.setRegistryName("lamp"));
    }

    @SubscribeEvent
    public static void onItemRegistration(final RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(LAMP_ITEM.setRegistryName("lamp"));
    }

}
