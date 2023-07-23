package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
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
                ShapedRecipeBuilder.shaped(plate)
                        .pattern("H")
                        .pattern("#")
                        .pattern("#")
                        .define('H', ItemTags.create(new ResourceLocation("moderntech", "tools/hammers/can_process_" + material.name)))
                        .define('#', ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                        .unlockedBy("has_" + material.name + "ingots",
                                has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name +
                                "_plate"));

            }
            if (material.hasIngot && material.hasRod) {
                var rod = material.ITEMS.get("rods").get();
                ShapelessRecipeBuilder.shapeless(rod)
                        .requires(ItemTags.create(new ResourceLocation("moderntech", "tools/files/can_process_" + material.name)))
                        .requires(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                        .unlockedBy("has_" + material.name + "ingots",
                                has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_rod"));
            }
            if (material.hasIngot && material.hasBlock) {
                var ingot = material.ITEMS.get("ingots").get();
                var block = material.block.getBlockItem();
                ShapedRecipeBuilder.shaped(block)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                        .unlockedBy("has_" + material.name + "_ingots",
                                has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_storage_blocks_from_ingots"));
                ShapelessRecipeBuilder.shapeless(ingot, 9)
                        .requires(Ingredient.of(ItemTags.create(new ResourceLocation("forge", "storage_blocks/" + material.name))))
                        .unlockedBy("has_" + material.name + "_blocks",
                                has(ItemTags.create(new ResourceLocation("forge", "storage_blocks/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_ingots_from_storage_blocks"));
            }
            if (material.hasIngot && material.hasNugget) {
                var nugget = material.ITEMS.get("nuggets").get();
                var ingot = material.ITEMS.get("ingots").get();
                ShapedRecipeBuilder.shaped(ingot)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ItemTags.create(new ResourceLocation("forge", "nuggets/" + material.name)))
                        .unlockedBy("has_" + material.name + "_nuggets",
                                has(ItemTags.create(new ResourceLocation("forge", "nuggets/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_ingots_from_nuggets"));
                ShapelessRecipeBuilder.shapeless(nugget, 9)
                        .requires(Ingredient.of(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .unlockedBy("has_" + material.name + "_ingots",
                                has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "nuggets_from_ingots"));
            }
            if (material.hasDustSeries) {
                var small_dust = material.ITEMS.get("small_dusts").get();
                var dust = material.ITEMS.get("dusts").get();
                ShapedRecipeBuilder.shaped(dust)
                        .pattern("##")
                        .pattern("##")
                        .define('#', ItemTags.create(new ResourceLocation("forge", "small_dusts/" + material.name)))
                        .unlockedBy("has_" + material.name + "_small_dusts",
                                has(ItemTags.create(new ResourceLocation("forge", "small_dusts/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_dusts_from_small_dusts"));
                ShapedRecipeBuilder.shaped(dust)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ItemTags.create(new ResourceLocation("forge", "tiny_dusts/" + material.name)))
                        .unlockedBy("has_" + material.name + "_tiny_dusts",
                                has(ItemTags.create(new ResourceLocation("forge", "tiny_dusts/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_dusts_from_tiny_dusts"));
                ShapelessRecipeBuilder.shapeless(small_dust, 4)
                        .requires(Ingredient.of(ItemTags.create(new ResourceLocation("forge", "dusts/" + material.name))))
                        .unlockedBy("has_" + material.name + "_dusts",
                                has(ItemTags.create(new ResourceLocation("forge", "dusts/" + material.name))))
                        .save(consumer, new ResourceLocation("moderntech", "crafting/materials/" + material.name + "_small_dusts_from_dusts"));
            }
            if (material.hasTools) {
                if (material.hasIngot) {
                    var hammer = material.TOOLS.get("hammers").get();
                    ShapedRecipeBuilder.shaped(hammer)
                            .pattern("## ")
                            .pattern("##-")
                            .pattern("## ")
                            .define('#', ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                            .define('-', ItemTags.create(new ResourceLocation("forge", "rods/wooden")))
                            .unlockedBy("has_" + material.name + "_ingots",
                                    has(ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name))))
                            .save(consumer, new ResourceLocation("moderntech", "crafting/tools/" + material.name + "_hammer"));
                    var file = material.TOOLS.get("files").get();
                    ShapedRecipeBuilder.shaped(file)
                            .pattern("H#")
                            .pattern("/ ")
                            .define('H', ItemTags.create(new ResourceLocation("moderntech", "tools/hammers/can_process_" + material.name)))
                            .define('#', ItemTags.create(new ResourceLocation("forge", "ingots/" + material.name)))
                            .define('/', ItemTags.create(new ResourceLocation("forge", "rods/wooden")))
                            .unlockedBy("has_" + material.name + "_ingots",
                                    has(ItemTags.create(new ResourceLocation("forge", "tool_heads/file_heads/" + material.name))))
                            .save(consumer, new ResourceLocation("moderntech", "crafting/tools/" + material.name + "_file"));
                }
            }
        }
    }
}
