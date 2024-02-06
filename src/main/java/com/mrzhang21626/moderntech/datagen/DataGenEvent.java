package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.datagen.lang.LangGenerator;
import com.mrzhang21626.moderntech.datagen.loot.LootTableGenerator;
import com.mrzhang21626.moderntech.datagen.model.BlockModelGenerator;
import com.mrzhang21626.moderntech.datagen.model.ItemModelGenerator;
import com.mrzhang21626.moderntech.datagen.recipe.RecipeGenerator;
import com.mrzhang21626.moderntech.datagen.tag.BlockTagGenerator;
import com.mrzhang21626.moderntech.datagen.tag.ItemTagGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModernTech.MODID)
public class DataGenEvent {
    @SubscribeEvent
    public static void register(GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();
        DataGenerator generator = event.getGenerator();
        if (event.includeClient()) {
            generator.addProvider(new BlockModelGenerator(generator, helper));
            generator.addProvider(new ItemModelGenerator(generator, helper));
        }
        if (event.includeServer()) {
            var blockTagsGenerator = new BlockTagGenerator(generator, helper);
            generator.addProvider(blockTagsGenerator);
            generator.addProvider(new ItemTagGenerator(generator, blockTagsGenerator, helper));
            generator.addProvider(new LootTableGenerator(generator));
            generator.addProvider(new RecipeGenerator(generator));
            generator.addProvider(new LangGenerator(generator));
        }
    }
}
