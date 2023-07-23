package com.mrzhang21626.moderntech;

import com.mojang.logging.LogUtils;
import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.registries.RegistryBlocks;
import com.mrzhang21626.moderntech.registries.RegistryItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
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
    public static final CreativeModeTab MATERIALS_TAB = new CreativeModeTab("materials_tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(Material.BERYLLIUM.ITEMS.get("ingots").get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> stacks) {
            for (var material : Material.values()) {
                if (material.hasBlock) {
                    stacks.add(new ItemStack(material.block.getBlockItem()));
                }
                if (material.hasIngot) {
                    stacks.add(new ItemStack(material.ITEMS.get("ingots").get()));
                }
                if (material.hasNugget) {
                    stacks.add(new ItemStack(material.ITEMS.get("nuggets").get()));
                }
                if (material.hasPlate) {
                    stacks.add(new ItemStack(material.ITEMS.get("plates").get()));
                }
                if (material.hasDustSeries) {
                    stacks.add(new ItemStack(material.ITEMS.get("dusts").get()));
                    stacks.add(new ItemStack(material.ITEMS.get("small_dusts").get()));
                    stacks.add(new ItemStack(material.ITEMS.get("tiny_dusts").get()));
                }
                if (material.hasRod) {
                    stacks.add(new ItemStack(material.ITEMS.get("rods").get()));
                }
                if (material.hasBoltAndScrew) {
                    stacks.add(new ItemStack(material.ITEMS.get("bolts").get()));
                    stacks.add(new ItemStack(material.ITEMS.get("screws").get()));
                }
                if (material.hasGearSeries) {
                    stacks.add(new ItemStack(material.ITEMS.get("gears").get()));
                    stacks.add(new ItemStack(material.ITEMS.get("small_gears").get()));
                }
            }
        }
    };
    public static final CreativeModeTab TOOLS_TAB = new CreativeModeTab("tool_tab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(Material.COPPER.TOOLS.get("hammers").get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> stacks) {
            String[] types = new String[]{"hammers", "files"};
            for (var type : types) {
                for (var material : Material.values()) {
                    if (material.hasTools) {
                        stacks.add(new ItemStack(material.TOOLS.get(type).get()));
                    }
                }
            }
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
            return switch (type) {
                case "bolts" -> "bolt";
                case "dusts" -> "dust";
                case "gears" -> "gear";
                case "ingots" -> "ingot";
                case "nuggets" -> "nugget";
                case "plates" -> "plate";
                case "rods" -> "rod";
                case "screws" -> "screw";
                case "small_dusts" -> "small_dust";
                case "small_gears" -> "small_gear";
                case "tiny_dusts" -> "tiny_dust";
                case "hammers" -> "hammer";
                case "files" -> "file";
                case "file_heads" -> "file_head";
                default -> "";
            };
        }

        public static String toUpper(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] >= 'a' && chars[0] <= 'z') chars[0] = (char) (chars[0] - 'a' + 'A');
            return String.valueOf(chars);
        }
    }
}
