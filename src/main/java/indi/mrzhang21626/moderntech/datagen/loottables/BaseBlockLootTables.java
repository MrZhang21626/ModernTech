package indi.mrzhang21626.moderntech.datagen.loottables;

import indi.mrzhang21626.moderntech.register.BlockRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseBlockLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    private BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer;
    private final Set<ResourceLocation> generated = new HashSet<>();

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer) {
        this.resourceLocationBuilderBiConsumer = resourceLocationBuilderBiConsumer;
        registryDefault();
    }

    private void registryDefault() {
        for (RegistryObject<Block> object : BlockRegister.BLOCKS.getEntries()) {
            Block block = object.get();
            if (!generated.contains(toTableLoc(block.getRegistryName()))) {
                selfDrop(new Supplier<Block>() {
                    @Override
                    public Block get() {
                        return block;
                    }
                });
            }
        }
    }

    private void selfDrop(Supplier<? extends Block> block, LootPool.Builder... pools) {
        LootPool.Builder[] self = Arrays.copyOf(pools, pools.length + 1);
        self[self.length - 1] = blockItem(block.get());
        register(block, self);
    }

    private LootPool.Builder blockItem(ItemLike itemLike) {
        return LootPool.lootPool().when(ExplosionCondition.survivesExplosion())
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(itemLike));
    }

    private ResourceLocation toTableLoc(ResourceLocation in) {
        return new ResourceLocation(in.getNamespace(), "blocks/" + in.getPath());
    }

    private void register(Supplier<? extends Block> block, LootPool.Builder... pools) {
        LootTable.Builder lootTable = LootTable.lootTable();
        for (LootPool.Builder pool : pools) lootTable.withPool(pool);
        register(block, lootTable);
    }

    private void register(Supplier<? extends Block> block, LootTable.Builder lootTable) {
        register(block.get().getRegistryName(), lootTable);
    }

    private void register(ResourceLocation name, LootTable.Builder lootTable) {
        ResourceLocation location = toTableLoc(name);
        if (!generated.add(location))
            throw new IllegalStateException("Failed to generate loot table '" + location + "', because it has been generated.");
        resourceLocationBuilderBiConsumer.accept(location, lootTable.setParamSet(LootContextParamSets.BLOCK));
    }
}
