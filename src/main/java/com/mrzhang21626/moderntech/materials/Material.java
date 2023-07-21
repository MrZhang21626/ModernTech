package com.mrzhang21626.moderntech.materials;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.registries.registration.BlockRegistration;
import com.mrzhang21626.moderntech.registries.registration.ItemRegistration;
import net.minecraft.world.level.block.SoundType;

import java.util.HashMap;
import java.util.Map;

public enum Material {
    BERYLLIUM("beryllium", "Be", 0x559855, 5.5f, 282),
    IRON("iron", "Fe", 0xd8d8d8, 5.0f, 256),
    COPPER("copper", "Cu", 0xc15a36, 3.0f, 154),
    GOLD("gold", "Au", 0xfdf55f, 3.0f, 32);
    public final String name, formula;

    public final int color, durability;
    public final float strength;
    public final net.minecraft.world.level.material.Material material;
    public final SoundType sound;
    public final boolean hasIngot, hasNugget, hasBlock, hasPlate, hasDustSeries, hasRod, hasBoltAndScrew, hasGearSeries, hasTools;
    public final Map<String, ItemRegistration> ITEMS = new HashMap<>();
    public final Map<String, ItemRegistration> TOOLS = new HashMap<>();
    public BlockRegistration block;

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
