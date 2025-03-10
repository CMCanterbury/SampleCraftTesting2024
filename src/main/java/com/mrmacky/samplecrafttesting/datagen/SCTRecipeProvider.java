package com.mrmacky.samplecrafttesting.datagen;

import com.mrmacky.samplecrafttesting.SampleCraftTesting;
import com.mrmacky.samplecrafttesting.registry.SCTBlocks;
import com.mrmacky.samplecrafttesting.registry.SCTItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;

public class SCTRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SCTRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreSmelting(pRecipeOutput, List.of(SCTItems.EXAMPLE_ITEM), RecipeCategory.MISC, SCTBlocks.EXAMPLE_BLOCK, 1F, 200, "example_group");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SCTBlocks.EXAMPLE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SCTItems.EXAMPLE_ITEM.get())
                .unlockedBy(getHasName(SCTItems.EXAMPLE_ITEM), has(SCTItems.EXAMPLE_ITEM))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SCTItems.EXAMPLE_ITEM.get(), 9)
                .requires(SCTBlocks.EXAMPLE_BLOCK.get())
                .unlockedBy(getHasName(SCTBlocks.EXAMPLE_BLOCK.get()), has(SCTBlocks.EXAMPLE_BLOCK))
                .save(pRecipeOutput);
    }


    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, SampleCraftTesting.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
