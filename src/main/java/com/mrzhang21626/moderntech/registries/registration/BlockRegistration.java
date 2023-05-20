package com.mrzhang21626.moderntech.registries.registration;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistration {
    private Block block;
    private BlockItem blockItem;
    private RegistryObject<Block> blockRegistryObject;
    private RegistryObject<BlockItem> blockItemRegistryObject;
    private final boolean isSimpleBlock;

    public BlockRegistration(Block block) {
        this.block = block;
        isSimpleBlock = true;
    }

    public BlockRegistration(RegistryObject<Block> blockRegistryObject) {
        this.blockRegistryObject = blockRegistryObject;
        isSimpleBlock = false;
    }

    public void setBlockItem(BlockItem blockItem) {
        this.blockItem = blockItem;
    }

    public void setBlockItem(RegistryObject<BlockItem> blockItemRegistryObject) {
        this.blockItemRegistryObject = blockItemRegistryObject;
    }

    public Block getBlock() {
        if (isSimpleBlock) return block;
        else return blockRegistryObject.get();
    }

    public BlockItem getBlockItem() {
        if (isSimpleBlock) return blockItem;
        else return blockItemRegistryObject.get();
    }
}
