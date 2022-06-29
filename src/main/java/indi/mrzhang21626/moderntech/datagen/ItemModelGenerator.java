package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.HashSet;
import java.util.Set;

public class ItemModelGenerator extends ItemModelProvider {
    private static final Set<Item> generatedItems = new HashSet<>();
    private static final Set<BlockItem> generatedBlockItems = new HashSet<>();

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registryMetals();
    }

    private void registry(Item item) {
        getBuilder(item.getRegistryName().getPath())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", modLoc("item/" + item.getRegistryName().getPath()));
        if (!generatedItems.add(item))
            throw new IllegalStateException("Failed to generate item model '" + modLoc(item.getRegistryName().getPath()) + "'");
    }

    private void registryBlockItem(BlockItem item) {
        getBuilder(item.getRegistryName().getPath())
                .parent(new ModelFile.UncheckedModelFile("moderntech:block/" + item.getRegistryName().getPath() + "_model"));
        if (!generatedItems.add(item))
            throw new IllegalStateException("Failed to generate item model '" + modLoc(item.getRegistryName().getPath()) + "'");
    }

    private void registryMetals(){
        for (Item item : Lists.itemList) {
            if(!generatedItems.contains(item)){
                registry(item);
            }
        }
        for (BlockItem item : Lists.blockItemList) {
            if(!generatedBlockItems.contains(item)){
                registryBlockItem(item);
            }
        }
    }
}
