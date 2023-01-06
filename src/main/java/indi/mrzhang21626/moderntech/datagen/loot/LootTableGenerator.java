package indi.mrzhang21626.moderntech.datagen.loot;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import indi.mrzhang21626.moderntech.Main;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator generator) {
        super(generator);
    }

    protected BlockLoot getBlockLootTable() {
        return new BlockLootGenerator();
    }

    @Override
    public String getName() {
        return super.getName() + Main.MODID;
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        ImmutableList.Builder<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> builder = new ImmutableList.Builder<>();
        BlockLoot blockLoot = getBlockLootTable();
        if (blockLoot != null) {
            builder.add(Pair.of(() -> blockLoot, LootContextParamSets.BLOCK));
        }
        return builder.build();
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {

    }
}
