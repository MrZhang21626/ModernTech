package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.items.BaseBlockItem;
import com.mrzhang21626.moderntech.items.BaseItem;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernTech.MODID);

    public static void init() {
        ITEMS.register(ModernTech.bus);
        registryMaterialItems();
    }

    private static void registryMaterialItems() {
        for (var material : Material.values()) {
            if (material.hasIngot) {
                material.ITEMS.put("ingot", ITEMS.register(material.name + "_ingot", () -> new BaseItem(material.formula)));
            }
            if (material.hasNugget) {
                material.ITEMS.put("nugget", ITEMS.register(material.name + "_nugget", () -> new BaseItem(material.formula)));
            }
            if (material.hasPlate) {
                material.ITEMS.put("plate", ITEMS.register(material.name + "_plate", () -> new BaseItem(material.formula)));
            }
            if (material.hasDustSeries) {
                material.ITEMS.put("dust", ITEMS.register(material.name + "_dust", () -> new BaseItem(material.formula)));
                material.ITEMS.put("small_dust", ITEMS.register(material.name + "_small_dust", () -> new BaseItem(material.formula)));
                material.ITEMS.put("tiny_dust", ITEMS.register(material.name + "_tiny_dust", () -> new BaseItem(material.formula)));
            }
            if (material.hasBlock) {
                material.blockItem = ITEMS.register(material.name + "_block", () -> new BaseBlockItem(material.block.get(), material.formula));
            }
            if (material.hasRod) {
                material.ITEMS.put("rod", ITEMS.register(material.name + "_rod", () -> new BaseItem(material.formula)));
            }
            if (material.hasBoltAndScrew) {
                material.ITEMS.put("bolt", ITEMS.register(material.name + "_bolt", () -> new BaseItem(material.formula)));
                material.ITEMS.put("screw", ITEMS.register(material.name + "_screw", () -> new BaseItem(material.formula)));
            }
            if (material.hasGearSeries) {
                material.ITEMS.put("gear", ITEMS.register(material.name + "_gear", () -> new BaseItem(material.formula)));
                material.ITEMS.put("small_gear", ITEMS.register(material.name + "_small_gear", () -> new BaseItem(material.formula)));
            }
        }
    }
}
