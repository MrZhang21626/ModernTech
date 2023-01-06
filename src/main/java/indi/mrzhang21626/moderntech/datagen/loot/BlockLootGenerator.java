package indi.mrzhang21626.moderntech.datagen.loot;

import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.Set;

public class BlockLootGenerator extends BlockLoot {
    private Set<Block> skipBlocks = new HashSet<>();

    protected void dropSelfWithContents(Block block) {
        add(block, createSingleItemTable(block));
        skipBlocks.add(block);
    }

    @Override
    protected void addTables() {
        for (var material : Material.values()) {
            dropSelfWithContents(material.getBlock().get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return skipBlocks;
    }
}
