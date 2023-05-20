package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (var material : Material.values()) {
            if (material.hasBlock) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(material.block.getBlock());
                tag(BlockTags.create(new ResourceLocation("forge", "storage_blocks/" + material.name))).add(material.block.getBlock());
                tag(BlockTags.create(new ResourceLocation("forge", "storage_blocks"))).add(material.block.getBlock());
            }
        }
    }
}
