package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.register.BlockRegister;
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
        registryMetals();
    }

    private void registryMetals(){
        for (BlockRegister.BlockRegistryObject metal : BlockRegister.MetalBlock.metalBlocks) {
            Block block = metal.getBlock();
            simpleBlock(block, new ModelFile.UncheckedModelFile(modLoc("block/" + block.getRegistryName().getPath() + "_model")));
        }
    }
}
