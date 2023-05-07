package com.mrzhang21626.moderntech;

import com.mojang.logging.LogUtils;
import com.mrzhang21626.moderntech.registries.RegistryBlocks;
import com.mrzhang21626.moderntech.registries.RegistryItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ModernTech.MODID)
public class ModernTech {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "moderntech";
    public static final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("main_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.COPPER_INGOT);
        }
    };

    public ModernTech() {
        RegistryBlocks.init();
        RegistryItems.init();
    }

    public static final class Utils {
        public static String formatFormula(String raw) {
            boolean flag = false;
            StringBuilder stringBuilder = new StringBuilder();
            for (var c : raw.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    if (!flag) stringBuilder.append(c);
                    else stringBuilder.append((char) (c - '0' + '₀'));
                } else if (c == '·') {
                    stringBuilder.append(c);
                    flag = false;
                } else {
                    stringBuilder.append(c);
                    flag = true;
                }
            }
            return stringBuilder.toString();
        }
    }
}
