package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Utils;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for (var material : Material.values()) {
            if (material.isHasDust() && material.isHasTinyDust())
                ShapedRecipeBuilder.shaped(material.getDust().get())
                        .pattern("TTT")
                        .pattern("TTT")
                        .pattern("TTT")
                        .define('T', forgetag("tiny_dusts/" + material.getName()))
                        .unlockedBy("has_" + material.getTinyDust().get().getRegistryName().getPath(), has(material.getTinyDust().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_tiny_dust_to_" + material.getName() + "_dust"));
            if (material.isHasIngot() && material.isHasNugget())
                ShapedRecipeBuilder.shaped(material.getIngot().get())
                        .pattern("NNN")
                        .pattern("NNN")
                        .pattern("NNN")
                        .define('N', forgetag("nuggets/" + material.getName()))
                        .unlockedBy("has_" + material.getNugget().get().getRegistryName().getPath(), has(material.getNugget().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_nugget_to_" + material.getName() + "_ingot"));
            if (material.isHasBlock() && material.isHasIngot())
                ShapedRecipeBuilder.shaped(material.getBlock().get())
                        .pattern("III")
                        .pattern("III")
                        .pattern("III")
                        .define('I', forgetag("ingots/" + material.getName()))
                        .unlockedBy("has_" + material.getIngot().get().getRegistryName().getPath(), has(material.getIngot().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_ingot_to_" + material.getName() + "_block"));
            if (material.isHasRod() && material.isHasIngot())
                ShapedRecipeBuilder.shaped(material.getRod().get(), 4)
                        .pattern("I")
                        .pattern("I")
                        .define('I', forgetag("ingots/" + material.getName()))
                        .unlockedBy("has_" + material.getIngot().get().getRegistryName().getPath(), has(material.getIngot().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_ingot_to_" + material.getName() + "_rod"));
            if (material.isHasIngot() && material.isHasDust())
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(forgetag("dusts/" + material.getName())),
                                material.getIngot().get(), 0f, 200)
                        .unlockedBy("has_" + material.getDust().get().getRegistryName().getPath(), has(material.getDust().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_ingot_from_smelting_" + material.getName() + "_dust"));
            if (material.isHasIngot() && material.isHasDust())
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(forgetag("tiny_dusts/" + material.getName())),
                                material.getNugget().get(), 0f, 200)
                        .unlockedBy("has_" + material.getTinyDust().get().getRegistryName().getPath(), has(material.getTinyDust().get()))
                        .save(consumer, Utils.modLoc(material.getName() + "_nugget_from_smelting_" + material.getName() + "_tiny_dust"));
            if (material.isHasPlate()) {
                var blockOfPlate = material.getBlockOfPlate();
                for (var screw : blockOfPlate.keySet()) {
                    Block block = blockOfPlate.get(screw).get();
                    ShapedRecipeBuilder.shaped(block, 4)
                            .pattern("SPS")
                            .pattern("P P")
                            .pattern("SPS")
                            .define('S', forgetag("screws/" + screw.getName()))
                            .define('P', forgetag("plates/" + material.getName()))
                            .unlockedBy("has_" + screw.getScrew().get().getRegistryName().getPath(), has(screw.getScrew().get()))
                            .save(consumer, Utils.modLoc(block.getRegistryName().getPath() + "_from_crafting"));

                }
            }
        }
    }

    private TagKey<Item> forgetag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
