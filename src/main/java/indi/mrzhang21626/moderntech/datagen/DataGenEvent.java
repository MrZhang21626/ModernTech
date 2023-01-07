package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.datagen.loot.LootTableGenerator;
import indi.mrzhang21626.moderntech.datagen.tags.BlockTagsGenerator;
import indi.mrzhang21626.moderntech.datagen.tags.ItemTagsGenerator;
import indi.mrzhang21626.moderntech.materials.Material;
import indi.mrzhang21626.moderntech.registries.ItemRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Main.MODID)
public class DataGenEvent {
    @SubscribeEvent
    public static void register(GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();
        DataGenerator datagen = event.getGenerator();
        if (event.includeServer()) {
            var blockTags = new BlockTagsGenerator(datagen, helper);
            datagen.addProvider(blockTags);
            datagen.addProvider(new ItemTagsGenerator(datagen, blockTags, helper));
            datagen.addProvider(new LootTableGenerator(datagen));
            datagen.addProvider(new RecipeGenerator(datagen));
        }
        if (event.includeClient()) {
            datagen.addProvider(new BlockStateAndModelGenerator(datagen, helper));
            var itemModelGenerator = new ItemModelGenerator(datagen, helper, ItemRegistries.ITEMS);
            for (var material : Material.values()) {
                if (material.isHasDust()) itemModelGenerator.skipItems(material.getDust().get());
                if (material.isHasTinyDust()) itemModelGenerator.skipItems(material.getTinyDust().get());
                if (material.isHasIngot()) itemModelGenerator.skipItems(material.getIngot().get());
                if (material.isHasNugget()) itemModelGenerator.skipItems(material.getNugget().get());
                if (material.isHasPlate()) itemModelGenerator.skipItems(material.getPlate().get());
                if (material.isHasRod()) itemModelGenerator.skipItems(material.getRod().get());
                if (material.isHasScrew()) itemModelGenerator.skipItems(material.getScrew().get());
            }
            datagen.addProvider(itemModelGenerator);
        }
    }
}
