package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper helper) {
        super(generator, provider, ModernTech.MODID, helper);
    }

    @Override
    protected void addTags() {
        //Material Items
        for (var material : Material.values()) {
            for (var type : material.ITEMS.keySet()) {
                var item = material.ITEMS.get(type).get();
                tag(getTag("forge", type + "/" + material.name)).add(item);
                tag(getTag("forge", type)).add(item);
            }
            for (var type : material.TOOLS.keySet()) {
                var item = material.TOOLS.get(type).get();
                tag(getTag("forge", "tools")).add(item);
                tag(getTag("forge", "tools/" + type)).add(item);
                tag(getTag("forge", "tools/" + type + "/" + material.name)).add(item);
                for (var beProcessedMaterial : Material.values()) {
                    if (material.strength >= beProcessedMaterial.strength) {
                        tag(getTag(ModernTech.MODID, "tools/can_process_" + beProcessedMaterial.name)).add(item);
                    } else tag(getTag(ModernTech.MODID, "tools/cannot_process_" + beProcessedMaterial.name)).add(item);
                }
            }
        }
    }

    private TagKey<Item> getTag(String modid, String name) {
        return ItemTags.create(new ResourceLocation(modid, name));
    }
}
