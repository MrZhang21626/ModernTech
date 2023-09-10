package com.mrzhang21626.moderntech.materials;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.registries.registration.BlockRegistration;
import com.mrzhang21626.moderntech.registries.registration.ItemRegistration;
import net.minecraft.world.level.block.SoundType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Material {
    public static final Map<String, Material> MATERIALS = new HashMap<>();

    public final String name, formula;
    public final int color, durability;
    public final float strength;
    public final net.minecraft.world.level.material.Material material;
    public final SoundType sound;
    public final boolean hasIngot, hasNugget, hasBlock, hasPlate, hasDustSeries, hasRod, hasBoltAndScrew, hasGearSeries, hasTools;
    public final Map<String, ItemRegistration> ITEMS = new HashMap<>();
    public final Map<String, ItemRegistration> TOOLS = new HashMap<>();
    public BlockRegistration block;

    public Material(Properties properties) {
        this.name = properties.name;
        this.formula = ModernTech.Utils.formatFormula(properties.formula);
        this.color = properties.color;
        this.durability = properties.durability;
        this.strength = properties.strength;
        this.material = properties.material;
        this.sound = properties.sound;
        this.hasIngot = properties.hasIngot;
        this.hasNugget = properties.hasNugget;
        this.hasBlock = properties.hasBlock;
        this.hasPlate = properties.hasPlate;
        this.hasDustSeries = properties.hasDustSeries;
        this.hasRod = properties.hasRod;
        this.hasBoltAndScrew = properties.hasBoltAndScrew;
        this.hasGearSeries = properties.hasGearSeries;
        this.hasTools = properties.hasTools;
    }

    public static List<Material> values() {
        return MATERIALS.values().stream().toList();
    }

    public static void addMaterial(Material material) {
        MATERIALS.put(material.name, material);
        ModernTech.LOGGER.info("Registry Material: " + material.name);
    }

    public static Material get(String name) {
        return Material.MATERIALS.get(name);
    }

    public static class Properties {
        private String name;
        private String formula;

        private int color, durability;
        private float strength;
        private net.minecraft.world.level.material.Material material;
        private SoundType sound;
        private boolean hasIngot, hasNugget, hasBlock, hasPlate, hasDustSeries, hasRod, hasBoltAndScrew,
                hasGearSeries, hasTools;

        Properties(String name) {
            this.name = name;
            formula = "";
            color = durability = 0;
            strength = 0;
            material = net.minecraft.world.level.material.Material.METAL;
            sound = SoundType.METAL;
            hasIngot = hasNugget = hasBlock = hasPlate = hasDustSeries = hasRod = hasBoltAndScrew = hasGearSeries = hasTools = false;
        }

        public static Properties of(String name) {
            return new Properties(name);
        }

        public Properties formula(String formula) {
            this.formula = formula;
            return this;
        }

        public Properties color(int color) {
            this.color = color;
            return this;
        }

        public Properties durability(int durability) {
            this.durability = durability;
            return this;
        }

        public Properties strength(float strength) {
            this.strength = strength;
            return this;
        }

        public Properties material(net.minecraft.world.level.material.Material material) {
            this.material = material;
            return this;
        }

        public Properties sound(SoundType sound) {
            this.sound = sound;
            return this;
        }

        public Properties hasIngot() {
            this.hasIngot = true;
            return this;
        }

        public Properties hasNugget() {
            this.hasNugget = true;
            return this;
        }

        public Properties hasBlock() {
            this.hasBlock = true;
            return this;
        }

        public Properties hasPlate() {
            this.hasPlate = true;
            return this;
        }

        public Properties hasDustSeries() {
            this.hasDustSeries = true;
            return this;
        }

        public Properties hasRod() {
            this.hasRod = true;
            return this;
        }

        public Properties hasBoltAndScrew() {
            this.hasBoltAndScrew = true;
            return this;
        }

        public Properties hasGearSeries() {
            this.hasGearSeries = true;
            return this;
        }

        public Properties hasTools() {
            this.hasTools = true;
            return this;
        }

        public Properties hasAll() {
            this.hasIngot = true;
            this.hasNugget = true;
            this.hasBlock = true;
            this.hasPlate = true;
            this.hasDustSeries = true;
            this.hasRod = true;
            this.hasBoltAndScrew = true;
            this.hasGearSeries = true;
            this.hasTools = true;
            return this;
        }
    }
}
