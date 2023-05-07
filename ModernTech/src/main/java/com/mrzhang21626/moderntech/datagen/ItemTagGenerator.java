package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
                var item = material.ITEMS.get(type);
                tag(ItemTags.create(new ResourceLocation("forge", type + "s/" + material.name))).add(item.get());
                tag(ItemTags.create(new ResourceLocation("forge", type + "s"))).add(item.get());
            }
        }
    }
}
