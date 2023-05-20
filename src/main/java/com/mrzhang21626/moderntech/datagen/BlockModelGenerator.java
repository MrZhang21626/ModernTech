package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelGenerator extends BlockStateProvider {
    public BlockModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Material Blocks
        for (var material : Material.values()) {
            if (material.hasBlock) {
                switch (material) {
                    case COPPER, IRON -> {
                    }
                    default -> simpleBlock(material.block.getBlock(), models().cubeAll(material.name + "_block",
                            modLoc("block/material/" + material.name + "_block")));
                }
            }
        }
    }
}
