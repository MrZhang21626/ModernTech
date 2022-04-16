package com.mrzhang21626.moderntech.items.action.use;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;

public interface IItemUseAction {
    InteractionResult onUse(UseOnContext context);
}
