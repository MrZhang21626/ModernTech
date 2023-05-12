package com.mrzhang21626.moderntech;

import com.mojang.logging.LogUtils;
import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.registries.RegistryBlocks;
import com.mrzhang21626.moderntech.registries.RegistryItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Mod(ModernTech.MODID)
public class ModernTech {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "moderntech";
    public static final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("main_tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(Items.COPPER_INGOT);
        }
    };
    public static final CreativeModeTab MATERIAL_TAB = new CreativeModeTab("material_tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(Material.BERYLLIUM.ITEMS.get("ingots").get());
        }
    };
    public static final CreativeModeTab TOOL_TAB = new CreativeModeTab("tool_tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(Items.IRON_PICKAXE);
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

        public static String getTextureName(String type) {
            switch (type) {
                case "bolts" -> {
                    return "bolt";
                }
                case "dusts" -> {
                    return "dust";
                }
                case "gears" -> {
                    return "gear";
                }
                case "ingots" -> {
                    return "ingot";
                }
                case "nuggets" -> {
                    return "nugget";
                }
                case "plates" -> {
                    return "plate";
                }
                case "rods" -> {
                    return "rod";
                }
                case "screws" -> {
                    return "screw";
                }
                case "small_dusts" -> {
                    return "small_dust";
                }
                case "small_gears" -> {
                    return "small_gear";
                }
                case "tiny_dusts" -> {
                    return "tiny_dust";
                }
            }
            return "";
        }
    }
}
