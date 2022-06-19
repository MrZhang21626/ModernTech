package indi.mrzhang21626.moderntech.items;

import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class BaseItem extends Item {
    private int burnTime = -1;

    public BaseItem() {
        this(new Properties());
    }

    public BaseItem(Properties properties) {
        this(properties, ModernTech.MTTabs.TAB);
    }

    public BaseItem(Properties properties, CreativeModeTab tab) {
        super(properties.tab(tab));
    }

    public BaseItem setBurnTime(int burnTime) {
        this.burnTime = burnTime;
        return this;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burnTime;
    }


}
