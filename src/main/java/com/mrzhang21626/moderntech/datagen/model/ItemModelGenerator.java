package com.mrzhang21626.moderntech.datagen.model;

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
                if (item.getRegistryName().getNamespace().equals("minecraft")) continue;
                generatedItem(name(item), modLoc("item/material/" + ModernTech.Utils.getTextureName(type)));
            }
            if (material.hasBlock) {
                switch (material.name) {
                    case "iron", "copper", "gold" -> {
                    }
                    default -> withExistingParent(name(material.block.getBlockItem()),
                            modLoc("block/" + name(material.block.getBlockItem())));

                }
            }
            for (var type : material.TOOLS.keySet()) {
                var item = material.TOOLS.get(type).get();
                if (item.getRegistryName().getNamespace().equals("minecraft")) continue;
                switch (type) {
                    case "hammers" -> withExistingParent(name(item), GENERATED)
                            .texture("layer0", modLoc("item/tools/hammer"))
                            .texture("layer1", modLoc("item/tools/handle_hammer"));
                    case "files" -> withExistingParent(name(item), GENERATED)
                            .texture("layer0", modLoc("item/tools/file"))
                            .texture("layer1", modLoc("item/tools/handle_file"));
                }
            }
        }
    }

    protected final ItemModelBuilder generatedItem(String name, ResourceLocation texture) {
        return withExistingParent(name, GENERATED).texture("layer0", texture);
    }

    protected final String name(Item item) {
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }
}
