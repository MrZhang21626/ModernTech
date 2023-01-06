package indi.mrzhang21626.moderntech.blocks;

import indi.mrzhang21626.moderntech.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(Block block) {
        this(block, new Properties().tab(Main.TAB));
    }

    public BaseBlockItem(Block block, Properties properties) {
        super(block, properties);
    }
}
