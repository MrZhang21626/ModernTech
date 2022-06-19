package indi.mrzhang21626.moderntech;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ModernTech.MODID)
public class ModernTech {
    public static final String MODID = "moderntech";

    public ModernTech() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static class MTTabs{
        public static final CreativeModeTab TAB = new CreativeModeTab("moderntech") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(Items.COPPER_INGOT);
            }
        };
    }
}
