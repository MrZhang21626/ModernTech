package indi.mrzhang21626.moderntech.items;

import indi.mrzhang21626.moderntech.utils.Utils;
import indi.mrzhang21626.moderntech.utils.action.item.update.IEntityItemUpdateAction;
import indi.mrzhang21626.moderntech.utils.action.item.use.IItemUseOnAction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class BaseItem extends Item {
    private IItemUseOnAction itemUseOnAction;
    private IEntityItemUpdateAction entityItemUpdateAction;

    public BaseItem(String name, Properties properties) {
        super(properties);
        setRegistryName(new ResourceLocation(Utils.MODID, name));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult result = super.useOn(pContext);
        if (result.equals(InteractionResult.PASS)) {
            result = this.itemUseOnAction.useOn(pContext);
        }
        return result;
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        boolean result = super.onEntityItemUpdate(stack, entity);
        if (!result) {
            result = this.entityItemUpdateAction.onEntityItemUpdate(stack, entity);
        }
        return result;
    }

    public void setItemUseOnAction(IItemUseOnAction itemUseOnAction) {
        this.itemUseOnAction = itemUseOnAction;
    }

    public void setEntityItemUpdateAction(IEntityItemUpdateAction entityItemUpdateAction) {
        this.entityItemUpdateAction = entityItemUpdateAction;
    }
}
