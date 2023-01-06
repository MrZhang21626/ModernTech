package indi.mrzhang21626.moderntech.items;

import indi.mrzhang21626.moderntech.Main;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {
    public BaseItem(){
        this(new Properties().tab(Main.TAB));
    }

    public BaseItem(Properties properties) {
        super(properties);
    }
}
