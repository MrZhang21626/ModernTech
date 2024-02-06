package com.mrzhang21626.moderntech.materials;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class MaterialTier implements Tier {
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private LazyLoadedValue<Ingredient> repairIngredient;

    public MaterialTier(TierProperties properties) {
        this.level = properties.getLevel();
        this.uses = properties.getUses();
        this.speed = properties.getSpeed();
        this.damage = properties.getAttackDamageBonus();
        this.enchantmentValue = properties.getEnchantmentValue();
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    @NotNull
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    public MaterialTier setRepairIngredient(Supplier<Ingredient> repairIngredient) {
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        return this;
    }

    public static class TierProperties {
        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final String repairIngredient;

        public TierProperties(int level, int uses, float speed, float damage, int enchantmentValue, String repairIngredient) {
            this.level = level;
            this.uses = uses;
            this.speed = speed;
            this.damage = damage;
            this.enchantmentValue = enchantmentValue;
            this.repairIngredient = repairIngredient;
        }

        public int getUses() {
            return uses;
        }

        public float getSpeed() {
            return speed;
        }

        public float getAttackDamageBonus() {
            return damage;
        }

        public int getLevel() {
            return level;
        }

        public int getEnchantmentValue() {
            return enchantmentValue;
        }

        @NotNull
        public String getRepairIngredientName() {
            return repairIngredient;
        }
    }
}
