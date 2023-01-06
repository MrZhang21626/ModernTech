package indi.mrzhang21626.moderntech.datagen.tags;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (var material : Material.values()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(material.getBlock().get());
        }
    }

    @Override
    public String getName() {
        return Main.MODID + "BlockTagsGen";
    }
}
