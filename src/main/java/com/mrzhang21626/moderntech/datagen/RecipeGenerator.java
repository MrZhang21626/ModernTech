package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        for (var material : Material.values()) {
            if (material.hasIngot && material.hasPlate) {
                var plate = material.ITEMS.get("plates").get();
                var ingot = material.ITEMS.get("ingots").get();
                ShapelessRecipeBuilder.shapeless(plate)
                        .requires(ItemTags.create(new ResourceLocation("moderntech", "tools/can_process_" + material.name)))
                        .requires(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                        .unlockedBy("has_" + material.name + "plates", has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "materials/" + material.name + "_plate_can_process"));
                ShapelessRecipeBuilder.shapeless(ingot)
                        .requires(ItemTags.create(new ResourceLocation("moderntech", "tools/cannot_process_" + material.name)))
                        .requires(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                        .unlockedBy("has_" + material.name + "plates", has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "materials/" + material.name + "_plate_cannot_process"));
            }
        }
    }
}
