package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModelGenerator extends ItemModelProvider {
    public static final ResourceLocation GENERATED = new ResourceLocation("item/generated");

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Material Items
        for (var material : Material.values()) {
            for (var type : material.ITEMS.keySet()) {
                var item = material.ITEMS.get(type).get();
                generatedItem(name(item), modLoc("item/material/" + type));
            }
            withExistingParent(name(material.blockItem.get()), modLoc("block/" + name(material.blockItem.get())));
        }
    }

    protected final ItemModelBuilder generatedItem(String name, ResourceLocation texture) {
        return withExistingParent(name, GENERATED).texture("layer0", texture);
    }

    protected final String name(Item item) {
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }
}
