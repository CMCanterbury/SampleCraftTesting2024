package com.mrmacky.samplecrafttesting.datagen;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import com.mrmacky.samplecrafttesting.registry.SCTItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class SCTItemModelGenerator extends ItemModelProvider {
    public SCTItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SampleCraftTesting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SCTItems.EXAMPLE_ITEM);
        simpleItem(SCTItems.SECOND_ITEM);
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SampleCraftTesting.MOD_ID, "item/" + item.getId().getPath()));
    }

}
