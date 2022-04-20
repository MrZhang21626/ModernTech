package indi.mrzhang21626.moderntech.utils.action.item.use;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;

@FunctionalInterface
public interface IItemUseOnAction {
    public InteractionResult useOn(UseOnContext pContext);
}
