package indi.mrzhang21626.moderntech.blocks;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(Block block) {
        this(block, new Properties());
    }

    public BaseBlockItem(Block block, int maxStackSize) {
        this(block, new Properties(), maxStackSize);
    }

    public BaseBlockItem(Block block, Properties properties) {
        this(block, properties, ModernTech.TAB);
    }

    public BaseBlockItem(Block block, Properties properties, int maxStackSize) {
        this(block, properties.stacksTo(maxStackSize), ModernTech.TAB);
    }

    public BaseBlockItem(Block block, Properties properties, CreativeModeTab group) {
        super(block, properties.tab(group));
        Lists.blockItemList.add(this);
    }
}
