package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelGenerator extends BlockModelProvider {
    public BlockModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (Block block : Lists.blockList) {
            getBuilder(block.getRegistryName().getPath() + "_model")
                    .parent(new ModelFile.UncheckedModelFile("block/cube_all"))
                    .texture("all", modLoc("block/" + block.getRegistryName().getPath()));
        }
    }
}
