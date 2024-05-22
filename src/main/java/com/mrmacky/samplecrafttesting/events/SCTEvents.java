package com.mrmacky.samplecrafttesting.events;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;

@Mod.EventBusSubscriber(modid = SampleCraftTesting.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SCTEvents {

    @SubscribeEvent
    public static void doAThing(LivingAttackEvent event) {

    }

}
