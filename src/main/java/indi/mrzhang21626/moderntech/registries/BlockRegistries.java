package indi.mrzhang21626.moderntech.registries;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.blocks.BaseBlock;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    private static void registryMaterialBlocks() {
        for (var material : Material.values()) {
            material.setBlock(BLOCKS.register(material.getName() + "_block",
                    () -> new BaseBlock(net.minecraft.world.level.material.Material.METAL, material.getHardness())));
        }
    }

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        registryMaterialBlocks();
    }
}
