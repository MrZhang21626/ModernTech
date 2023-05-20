package com.mrzhang21626.moderntech.datagen;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen) {
        super(gen, ModernTech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (var material : Material.values()) {
            for (var type : material.ITEMS.keySet()) {
                var item = material.ITEMS.get(type).get();
                var names = item.getRegistryName().getPath().split("_");
                StringBuilder stringBuilder = new StringBuilder();
                for (var str : names) {
                    stringBuilder.append(ModernTech.Utils.toUpper(str));
                    stringBuilder.append(' ');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                add(item, stringBuilder.toString());
            }
            if (material.hasBlock) {
                switch (material) {
                    case COPPER, IRON -> {
                    }
                    default -> {
                        var block = material.block.getBlock();
                        var names = block.getRegistryName().getPath().split("_");
                        StringBuilder stringBuilder = new StringBuilder();
                        for (var str : names) {
                            stringBuilder.append(ModernTech.Utils.toUpper(str));
                            stringBuilder.append(' ');
                        }
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        add(block, stringBuilder.toString());
                    }
                }
            }
            for (var type : material.TOOLS.keySet()) {
                var item = material.TOOLS.get(type).get();
                var names = item.getRegistryName().getPath().split("_");
                StringBuilder stringBuilder = new StringBuilder();
                for (var str : names) {
                    stringBuilder.append(ModernTech.Utils.toUpper(str));
                    stringBuilder.append(' ');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                add(item, stringBuilder.toString());
            }
        }
    }
}
