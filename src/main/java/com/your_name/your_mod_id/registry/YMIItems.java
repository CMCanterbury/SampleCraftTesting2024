package com.your_name.your_mod_id.registry;

import com.your_name.your_mod_id.YourModID;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class YMIItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YourModID.MOD_ID);

    //Items go here

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }


}
