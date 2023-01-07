package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateAndModelGenerator extends BlockStateProvider {
    public BlockStateAndModelGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (var material : Material.values()) {
            if (material.isHasBlock()) {
                var block = material.getBlock().get();
                var name = block.getRegistryName();
                simpleBlock(block, models().cubeAll(name.getPath(),
                        new ResourceLocation(name.getNamespace(), "block/materials/" + name.getPath())));
            }
        }
        for (var plate : Material.values()) {
            if (!plate.isHasPlate()) continue;
            for (var screw : Material.values()) {
                if (!screw.isHasScrew()) continue;
                var block = plate.getBlockOfPlate().get(screw).get();
                var name = block.getRegistryName();
                simpleBlock(block, models()
                        .withExistingParent(name.getPath(), modLoc("block/block_of_plate"))
                        .texture("screw", "block/materials/" + screw.getName() + "_block")
                        .texture("plate", "block/materials/" + plate.getName() + "_plate"));
            }
        }
    }
}
