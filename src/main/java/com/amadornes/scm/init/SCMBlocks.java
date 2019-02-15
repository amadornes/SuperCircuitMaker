package com.amadornes.scm.init;

import com.amadornes.scm.SuperCircuitMaker;
import com.amadornes.scm.block.BlockCircuit;
import com.amadornes.scm.tile.TileCircuit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SuperCircuitMaker.MODID)
public class SCMBlocks {

    public static final Block CIRCUIT_BIG = new BlockCircuit();
    public static final Block CIRCUIT_SMALL = new BlockCircuit();
    public static final TileEntityType<TileCircuit> CIRCUIT_TILE = new TileEntityType<>(TileCircuit::new, null);

    @SubscribeEvent
    public static void onBlockRegistration(final RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(CIRCUIT_BIG.setRegistryName("circuit_big"));
        registry.register(CIRCUIT_SMALL.setRegistryName("circuit_small"));
    }

    @SubscribeEvent
    public static void onTileEntityRegistration(final RegistryEvent.Register<TileEntityType<?>> event) {
        IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();

        registry.register(CIRCUIT_TILE.setRegistryName("circuit"));
    }

    @SubscribeEvent
    public static void onItemRegistration(final RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(new ItemBlock(CIRCUIT_BIG, new Item.Properties()).setRegistryName(CIRCUIT_BIG.getRegistryName()));
        registry.register(new ItemBlock(CIRCUIT_SMALL, new Item.Properties()).setRegistryName(CIRCUIT_SMALL.getRegistryName()));
    }

}
