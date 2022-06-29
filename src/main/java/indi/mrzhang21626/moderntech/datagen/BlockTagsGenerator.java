package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.register.BlockRegister;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator p_126511_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        registryMetals();
    }

    private void registryMetals(){
        for (BlockRegister.BlockRegistryObject metal : BlockRegister.MetalBlock.metalBlocks) {
            Block block = metal.getBlock();
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
    }
}
