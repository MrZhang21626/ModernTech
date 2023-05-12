package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.blocks.BaseBlock;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernTech.MODID);

    public static void init() {
        BLOCKS.register(ModernTech.bus);
        registryMaterialBlocks();
    }

    private static void registryMaterialBlocks() {
        for (var material : Material.values()) {
            if (material.hasBlock)
                material.block = BLOCKS.register(material.name + "_block", () -> new BaseBlock(material.material, material.sound, material.strength));
        }
    }
}
