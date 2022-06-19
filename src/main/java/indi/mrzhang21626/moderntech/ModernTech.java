package indi.mrzhang21626.moderntech;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModernTech.MODID)
public class ModernTech {
    public static final String MODID = "moderntech";
    public static final CreativeModeTab TAB = new CreativeModeTab("moderntech") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.COPPER_INGOT);
        }
    };

    public ModernTech() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        EventContent.modConstruction();
    }

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }

}
