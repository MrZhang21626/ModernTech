package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.items.BaseBlockItem;
import com.mrzhang21626.moderntech.items.BaseItem;
import com.mrzhang21626.moderntech.items.tools.HammerItem;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernTech.MODID);

    public static void init() {
        ITEMS.register(ModernTech.bus);
        registryMaterialItems();
    }

    private static void registryMaterialItems() {
        for (var material : Material.values()) {
            if (material.hasIngot) {
                material.ITEMS.put("ingots", getMaterialItem(material.name, "ingot", material.formula));
            }
            if (material.hasNugget) {
                material.ITEMS.put("nuggets", getMaterialItem(material.name, "nugget", material.formula));
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
                material.blockItem = ITEMS.register(material.name + "_block", () ->
                        new BaseBlockItem(material.block.get(), ModernTech.MATERIAL_TAB, material.formula));
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
                material.TOOLS.put("hammers", ITEMS.register(material.name + "_hammer", () -> new HammerItem(material.durability, material.formula)));
            }
        }
    }

    private static RegistryObject<Item> getMaterialItem(String materialName, String type, String formula) {
        return ITEMS.register(materialName + "_" + type, () -> new BaseItem(ModernTech.MATERIAL_TAB, formula));
    }
}
