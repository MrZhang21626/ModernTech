package indi.mrzhang21626.moderntech.items;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {
    public BaseItem() {
        this(new Properties());
    }

    public BaseItem(int maxStackSize) {
        this(new Properties(), maxStackSize);
    }

    public BaseItem(Properties properties) {
        this(properties, ModernTech.TAB);
    }

    public BaseItem(Properties properties, int maxStackSize) {
        this(properties.stacksTo(maxStackSize), ModernTech.TAB);
    }

    public BaseItem(Properties properties, CreativeModeTab group) {
        super(properties.tab(group));
        Lists.itemList.add(this);
    }
}
