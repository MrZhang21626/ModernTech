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

import java.util.ArrayList;
import java.util.List;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernTech.MODID);

    public static final class MetalBlock {
        public static final List<BlockRegistryObject> metalBlocks = new ArrayList<>();

        private static void init() {
            for(String name : Lists.metals.keySet()){
                metalBlocks.add(registryWithGen(name+"_block",Lists.metals.get(name)));
            }
        }
    }

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MetalBlock.init();
    }

    private static BlockRegistryObject registryWithGen(String name, float strength) {
        return registryWithGen(name, Material.METAL, MaterialColor.METAL, strength, SoundType.METAL);
    }

    private static BlockRegistryObject registryWithGen(String name, Material material, MaterialColor materialColor, float strength, SoundType soundType) {
        RegistryObject<BaseBlock> block = BLOCKS.register(name, () -> new BaseBlock(material, materialColor, strength, soundType).withGen());
        RegistryObject<BaseBlockItem> item = ItemRegister.ITEMS.register(name, () -> new BaseBlockItem(block.get()));
        return new BlockRegistryObject(block, item);
    }

    private static BlockRegistryObject registry(String name, float strength) {
        return registry(name, Material.METAL, MaterialColor.METAL, strength, SoundType.METAL);
    }

    private static BlockRegistryObject registry(String name, Material material, MaterialColor materialColor, float strength, SoundType soundType) {
        RegistryObject<BaseBlock> block = BLOCKS.register(name, () -> new BaseBlock(material, materialColor, strength, soundType));
        RegistryObject<BaseBlockItem> item = ItemRegister.ITEMS.register(name, () -> new BaseBlockItem(block.get()));
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
