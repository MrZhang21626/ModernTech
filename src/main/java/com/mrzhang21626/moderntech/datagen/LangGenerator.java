package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Objects;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen) {
        super(gen, ModernTech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (var material : Material.values()) {
            for (var type : material.ITEMS.keySet()) {
                var item = material.ITEMS.get(type).get();

                add(item, switch (type) {
                    case "small_dusts" -> toDisplayName("small_pile_of_" + material.name + "_dust");
                    case "tiny_dusts" -> toDisplayName("tiny_pile_of_" + material.name + "_dust");
                    case "small_gears" -> toDisplayName("small_" + material.name + "_gear");
                    default -> toDisplayName(Objects.requireNonNull(item.getRegistryName()).getPath());
                });
            }
            if (material.hasBlock) {
                switch (material.name) {
                    case "iron", "copper", "gold" -> {
                    }
                    default -> {
                        var block = material.block.getBlock();
                        add(block, toDisplayName(Objects.requireNonNull(block.getRegistryName()).getPath()));
                    }
                }
            }
            for (var type : material.TOOLS.keySet()) {
                var item = material.TOOLS.get(type).get();
                add(item, toDisplayName(Objects.requireNonNull(item.getRegistryName()).getPath()));
            }
        }
    }

    private String toDisplayName(String id) {
        var names = id.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (var str : names) {
            if (Objects.equals(str, "of"))
                stringBuilder.append("of");
            else
                stringBuilder.append(ModernTech.Utils.toUpper(str));
            stringBuilder.append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
