package com.mrzhang21626.moderntech.items.tools;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.items.BaseItem;
import net.minecraft.world.item.ItemStack;

public class HammerItem extends BaseItem {
    public HammerItem(int durability, String tooltip) {
        super(new Properties().stacksTo(1).durability(durability).tab(ModernTech.TOOL_TAB), ModernTech.TOOL_TAB, tooltip);
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack ret = new ItemStack(this);
        ret.setDamageValue(itemStack.getDamageValue() + 1);
        if (ret.getDamageValue() >= ret.getMaxDamage()) return ItemStack.EMPTY;
        return ret;
    }
}
