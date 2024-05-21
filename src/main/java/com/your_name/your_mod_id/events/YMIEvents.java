package com.your_name.your_mod_id.events;

import com.your_name.your_mod_id.YourModID;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;

@Mod.EventBusSubscriber(modid = YourModID.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class YMIEvents {

    @SubscribeEvent
    public static void doAThing(LivingAttackEvent event) {

    }

}
