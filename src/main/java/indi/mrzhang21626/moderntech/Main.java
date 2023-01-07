package indi.mrzhang21626.moderntech;

import indi.mrzhang21626.moderntech.registries.BlockRegistries;
import indi.mrzhang21626.moderntech.registries.ItemRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "moderntech";

    public static final CreativeModeTab TAB = new CreativeModeTab("tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.COPPER_INGOT);
        }
    };

    public Main() {
        BlockRegistries.init();
        ItemRegistries.init();
    }
}
