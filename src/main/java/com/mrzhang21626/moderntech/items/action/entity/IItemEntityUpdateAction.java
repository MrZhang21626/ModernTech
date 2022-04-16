package com.mrzhang21626.moderntech.items.action.entity;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

public interface IItemEntityUpdateAction {
    boolean onEntityUpdate(ItemStack stack, ItemEntity entity);
}
