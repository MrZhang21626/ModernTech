package com.mrzhang21626.moderntech.materials;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.blocks.BaseBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public enum Material {
    BERYLLIUM("beryllium", "Be", 0x559855, 5.5f, 256);
    public final String name, formula;
    public final int color, durability;
    public final float strength;
    public final net.minecraft.world.level.material.Material material;
    public final SoundType sound;
    public final boolean hasIngot, hasNugget, hasBlock, hasPlate, hasDustSeries, hasRod, hasBoltAndScrew, hasGearSeries, hasTools;
    public final Map<String, RegistryObject<Item>> ITEMS = new HashMap<>();
    public final Map<String, RegistryObject<Item>> TOOLS = new HashMap<>();
    public RegistryObject<BaseBlock> block;
    public RegistryObject<BlockItem> blockItem;

    Material(String name, String formula, int color, int durability, float strength, net.minecraft.world.level.material.Material material, SoundType sound,
             boolean hasIngot, boolean hasNugget, boolean hasBlock, boolean hasPlate, boolean hasDustSeries, boolean hasRod,
             boolean hasBoltAndScrew, boolean hasGearSeries, boolean hasTools) {
        this.name = name;
        this.formula = ModernTech.Utils.formatFormula(formula);
        this.color = color;
        this.durability = durability;
        this.strength = strength;
        this.material = material;
        this.sound = sound;
        this.hasIngot = hasIngot;
        this.hasNugget = hasNugget;
        this.hasBlock = hasBlock;
        this.hasPlate = hasPlate;
        this.hasDustSeries = hasDustSeries;
        this.hasRod = hasRod;
        this.hasBoltAndScrew = hasBoltAndScrew;
        this.hasGearSeries = hasGearSeries;
        this.hasTools = hasTools;
    }

    Material(String name, String formula, int color, float strength, int durability) {
        this(name, formula, color, durability, strength, net.minecraft.world.level.material.Material.METAL, SoundType.METAL,
                true, true, true, true, true, true, true, true, true);
    }
}
