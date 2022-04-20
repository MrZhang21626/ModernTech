package indi.mrzhang21626.moderntech;

import indi.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tabs {
    public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("main") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ChemicalItems.hydrogenum);
        }
    };
    public static final CreativeModeTab CHEMISTRY_TAB = new CreativeModeTab("chemistry") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ChemicalItems.hydrogenum);
        }
    };
}
