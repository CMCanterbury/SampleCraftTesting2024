package com.your_name.your_mod_id.registry;

import com.your_name.your_mod_id.YourModID;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class YMIBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YourModID.MOD_ID);

    //Blocks go here

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }


    private static DeferredBlock<Block> registerWithItem(String blockID, Supplier<? extends Block> sup) {
        DeferredBlock<Block> block = registerWithNoItem(blockID, sup);
        YMIItems.ITEMS.registerSimpleBlockItem(blockID, sup);
        return block;
    }

    private static DeferredBlock<Block> registerWithNoItem(String blockID, Supplier<? extends Block> sup) {
        return BLOCKS.register(blockID, sup);
    }

}
