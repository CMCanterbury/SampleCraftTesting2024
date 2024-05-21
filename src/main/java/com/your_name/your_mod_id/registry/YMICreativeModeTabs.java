package com.your_name.your_mod_id.registry;

import com.your_name.your_mod_id.YourModID;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class YMICreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YourModID.MOD_ID);

    //Items go here

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

}
