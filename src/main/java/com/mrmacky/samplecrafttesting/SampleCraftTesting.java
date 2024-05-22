package com.mrmacky.samplecrafttesting;

import com.mojang.logging.LogUtils;
import com.mrmacky.samplecrafttesting.registry.SCTBlocks;
import com.mrmacky.samplecrafttesting.registry.SCTCreativeModeTabs;
import com.mrmacky.samplecrafttesting.registry.SCTItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SampleCraftTesting.MOD_ID)
public class SampleCraftTesting
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "samplecrafttesting";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public SampleCraftTesting(IEventBus modEventBus) {

        SCTItems.register(modEventBus);
        SCTBlocks.register(modEventBus);
        SCTCreativeModeTabs.register(modEventBus);

    }

}
