package com.mrzhang21626.moderntech.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        ImmutableList.Builder<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> builder = new ImmutableList.Builder<>();
        var blockLoot = getBlockLootTable();
        if (blockLoot != null) builder.add(Pair.of(() -> blockLoot, LootContextParamSets.BLOCK));
        return builder.build();
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {

    }

    protected BlockLoot getBlockLootTable() {
        return new BlockLoots();
    }

    protected static class BlockLoots extends BlockLoot {
        private final Set<Block> skipBlocks = new HashSet<>();

        protected void dropSelfWithContents(Block block) {
            this.add(block, createSingleItemTable(block));
        }

        @Override
        protected void add(@NotNull Block block, LootTable.@NotNull Builder builder) {
            super.add(block, builder);
            skipBlocks.add(block);
        }

        @Override
        protected void addTables() {
            for (var material : Material.values()) {
                if (material.hasBlock) {
                    var block = material.block.getBlock();
                    dropSelfWithContents(block);
                }
            }
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return skipBlocks;
        }
    }
}
