package com.mrmacky.samplecrafttesting.datagen;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static net.neoforged.fml.common.Mod.EventBusSubscriber.Bus.MOD;

@Mod.EventBusSubscriber(modid = SampleCraftTesting.MOD_ID, bus = MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new SCTRecipeProvider(packOutput));
        generator.addProvider(event.includeClient(), new SCTBlockStateGenerator(packOutput, helper));
        generator.addProvider(event.includeClient(), new SCTItemModelGenerator(packOutput, helper));

        SCTBlockTagGenerator tagGenerator = generator.addProvider(event.includeServer(), new SCTBlockTagGenerator(packOutput, lookupProvider, helper));


    }
}
