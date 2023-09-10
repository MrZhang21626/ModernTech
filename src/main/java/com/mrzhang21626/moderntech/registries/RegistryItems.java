package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.items.BaseBlockItem;
import com.mrzhang21626.moderntech.items.BaseItem;
import com.mrzhang21626.moderntech.items.tools.SimpleToolItem;
import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.registries.registration.ItemRegistration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
                switch (material.name) {
                    case "iron" -> material.ITEMS.put("ingots", new ItemRegistration(Items.IRON_INGOT));
                    case "copper" -> material.ITEMS.put("ingots", new ItemRegistration(Items.COPPER_INGOT));
                    case "gold" -> material.ITEMS.put("ingots", new ItemRegistration(Items.GOLD_INGOT));
                    default -> material.ITEMS.put("ingots", getMaterialItem(material.name, "ingot", material.formula));
                }
            }
            if (material.hasNugget) {
                switch (material.name) {
                    case "iron" -> material.ITEMS.put("nuggets", new ItemRegistration(Items.IRON_NUGGET));
                    case "gold" -> material.ITEMS.put("nuggets", new ItemRegistration(Items.GOLD_NUGGET));
                    default ->
                            material.ITEMS.put("nuggets", getMaterialItem(material.name, "nugget", material.formula));
                }
            }
            if (material.hasPlate) {
                material.ITEMS.put("plates", getMaterialItem(material.name, "plate", material.formula));
            }
            if (material.hasDustSeries) {
                material.ITEMS.put("dusts", getMaterialItem(material.name, "dust", material.formula));
                material.ITEMS.put("small_dusts", getMaterialItem(material.name, "small_dust", material.formula));
                material.ITEMS.put("tiny_dusts", getMaterialItem(material.name, "tiny_dust", material.formula));
            }
            if (material.hasBlock) {
                switch (material.name) {
                    case "iron" -> material.block.setBlockItem((BlockItem) Items.IRON_BLOCK);
                    case "copper" -> material.block.setBlockItem((BlockItem) Items.COPPER_BLOCK);
                    case "gold" -> material.block.setBlockItem((BlockItem) Items.GOLD_BLOCK);
                    default ->
                            material.block.setBlockItem(ITEMS.register(material.name + "_block", () -> new BaseBlockItem(material.block.getBlock(), ModernTech.MATERIALS_TAB, material.formula)));
                }
            }
            if (material.hasRod) {
                material.ITEMS.put("rods", getMaterialItem(material.name, "rod", material.formula));
            }
            if (material.hasBoltAndScrew) {
                material.ITEMS.put("bolts", getMaterialItem(material.name, "bolt", material.formula));
                material.ITEMS.put("screws", getMaterialItem(material.name, "screw", material.formula));
            }
            if (material.hasGearSeries) {
                material.ITEMS.put("gears", getMaterialItem(material.name, "gear", material.formula));
                material.ITEMS.put("small_gears", getMaterialItem(material.name, "small_gear", material.formula));
            }
            if (material.hasTools) {
                material.TOOLS.put("hammers", new ItemRegistration(ITEMS.register(material.name + "_hammer", () -> new SimpleToolItem(material.durability, material.formula))));
                material.TOOLS.put("files", new ItemRegistration(ITEMS.register(material.name + "_file", () -> new SimpleToolItem(material.durability, material.formula))));
            }
        }
    }

    private static ItemRegistration getMaterialItem(String materialName, String type, String formula) {
        return new ItemRegistration(ITEMS.register(materialName + "_" + type, () -> new BaseItem(ModernTech.MATERIALS_TAB, formula)));
    }
}
