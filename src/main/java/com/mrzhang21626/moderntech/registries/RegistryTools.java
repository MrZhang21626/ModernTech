package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.items.tools.SimpleToolItem;
import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;
import com.mrzhang21626.moderntech.registries.registration.ItemRegistration;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

import static com.mrzhang21626.moderntech.registries.RegistryItems.ITEMS;

public class RegistryTools {
    public static void init() {
        registryTiers();
        registryTools();
    }

    private static void registryTiers() {
        for (var material : Material.values()) {
            switch (material.name) {
                case "gold":
                    material.tier = Tiers.GOLD;
                case "iron":
                    material.tier = Tiers.IRON;
                default:
                    var item = material.ITEMS.get(material.tierProperties.getRepairIngredientName());
                    material.tier = new MaterialTier(material.tierProperties).setRepairIngredient(() -> Ingredient.of(item.get()));
            }

        }
    }

    private static void registryTools() {
        for (var material : Material.values()) {
            if (material.hasTools) {
                material.TOOLS.put("hammers", new ItemRegistration(ITEMS.register(material.name + "_hammer",
                        () -> new SimpleToolItem(material.tier))));
                material.TOOLS.put("files", new ItemRegistration(ITEMS.register(material.name + "_file",
                        () -> new SimpleToolItem(material.tier))));
            }
        }
    }
}
