package indi.mrzhang21626.moderntech.utils.action.item.update;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

@FunctionalInterface
public interface IEntityItemUpdateAction {
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity);
}
