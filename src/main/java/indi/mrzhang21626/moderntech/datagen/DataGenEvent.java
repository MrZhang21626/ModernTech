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
        }
        if (event.includeClient()) {
            datagen.addProvider(new BlockStateAndModelGenerator(datagen, helper));
            var itemModelGenerator = new ItemModelGenerator(datagen, helper, ItemRegistries.ITEMS);
            for (var material : Material.values()) {
                itemModelGenerator.skipItems(material.getDust().get());
                itemModelGenerator.skipItems(material.getTinyDust().get());
                itemModelGenerator.skipItems(material.getIngot().get());
                itemModelGenerator.skipItems(material.getNugget().get());
                itemModelGenerator.skipItems(material.getPlate().get());
                itemModelGenerator.skipItems(material.getRod().get());
            }
            datagen.addProvider(itemModelGenerator);
        }
    }
}
