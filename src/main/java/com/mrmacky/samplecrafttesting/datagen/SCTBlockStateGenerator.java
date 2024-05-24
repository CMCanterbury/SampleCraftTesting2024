package com.mrmacky.samplecrafttesting.datagen;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import com.mrmacky.samplecrafttesting.registry.SCTBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SCTBlockStateGenerator extends BlockStateProvider {

    public SCTBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SampleCraftTesting.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(SCTBlocks.EXAMPLE_BLOCK.get(), cubeAll(Blocks.GOLD_BLOCK));
    }
}
