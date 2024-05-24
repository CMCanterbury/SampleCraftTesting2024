package com.mrmacky.samplecrafttesting.datagen;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import com.mrmacky.samplecrafttesting.registry.SCTBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SCTBlockTagGenerator extends BlockTagsProvider {
    public SCTBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SampleCraftTesting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(SCTBlocks.EXAMPLE_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SCTBlocks.EXAMPLE_BLOCK.get());
    }
}
