package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ModernTech.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Block block : Lists.blockList) {
            simpleBlock(block, new ModelFile.UncheckedModelFile(modLoc("block/" + block.getRegistryName().getPath() + "_model")));
        }
    }
}
