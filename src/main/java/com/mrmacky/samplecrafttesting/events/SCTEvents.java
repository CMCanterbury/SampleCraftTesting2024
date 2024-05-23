package com.mrmacky.samplecrafttesting.events;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;

@Mod.EventBusSubscriber(modid = SampleCraftTesting.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SCTEvents {

    @SubscribeEvent
    public static void doAThing(LivingAttackEvent event) {
        if (event.getEntity().getType() == EntityType.CHICKEN) {
            Level pLevel = event.getEntity().level();
            BlockPos pPos = event.getEntity().getOnPos();
            PrimedTnt primedtnt = new PrimedTnt(pLevel, (double)pPos.getX() + 0.5, (double)pPos.getY() + 1, (double)pPos.getZ() + 0.5, null);
            primedtnt.setFuse(1);
            pLevel.addFreshEntity(primedtnt);
        }
    }

}
