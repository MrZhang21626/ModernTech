package indi.mrzhang21626.moderntech.register;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.blocks.BaseBlock;
import indi.mrzhang21626.moderntech.blocks.BaseBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernTech.MODID);

    public static final class MetalBlock {
        public static final BlockRegistryObject ZINC_BLOCK = registry("zinc_block", 2.5f);

        private static void init() {
        }
    }

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MetalBlock.init();
    }

    private static BlockRegistryObject registry(String name, float strength) {
        return registry(name, Material.METAL, MaterialColor.METAL, strength, SoundType.METAL);
    }

    private static BlockRegistryObject registry(String name, Material material, MaterialColor materialColor, float strength, SoundType soundType) {
        RegistryObject<BaseBlock> block = BLOCKS.register(name, () -> new BaseBlock(material, materialColor, strength, soundType));
        RegistryObject<BaseBlockItem> item = ItemRegister.ITEMS.register(name, () -> new BaseBlockItem(block.get()));
        Lists.blockList.add(block.get());
        return new BlockRegistryObject(block, item);
    }

    public static class BlockRegistryObject {
        private RegistryObject<BaseBlock> block;
        private RegistryObject<BaseBlockItem> blockItem;

        public BlockRegistryObject(RegistryObject<BaseBlock> block, RegistryObject<BaseBlockItem> blockItem) {
            this.block = block;
            this.blockItem = blockItem;
        }

        public BaseBlock getBlock() {
            return block.get();
        }

        public BaseBlockItem getBlockItem() {
            return blockItem.get();
        }
    }
}
