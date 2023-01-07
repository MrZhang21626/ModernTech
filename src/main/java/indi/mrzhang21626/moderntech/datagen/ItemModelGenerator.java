package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemModelGenerator extends ItemModelProvider {

    protected final DeferredRegister<? extends Item> deferredRegister;
    private final Set<Item> skipItems = new HashSet<>();

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper, DeferredRegister<? extends Item> deferredRegister) {
        super(generator, Main.MODID, existingFileHelper);
        this.deferredRegister = deferredRegister;
    }

    protected void skipItems(Item... items) {
        Collections.addAll(skipItems, items);
    }

    protected void skipItems(Collection<? extends Item> items) {
        skipItems.addAll(items);
    }

    protected Set<Item> getItems() {
        return deferredRegister.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }

    protected void registerItem(Set<Item> items) {
        items.forEach(this::generatedItem);
        for (var material : Material.values()) {
            if (material.isHasDust()) generatedItem(material.getDust().get(), "materials/dust/");
            if (material.isHasTinyDust()) generatedItem(material.getTinyDust().get(), "materials/tiny_dust/");
            if (material.isHasIngot()) generatedItem(material.getIngot().get(), "materials/ingot/");
            if (material.isHasNugget()) generatedItem(material.getNugget().get(), "materials/nugget/");
            if (material.isHasPlate()) generatedItem(material.getPlate().get(), "materials/plate/");
            if (material.isHasRod()) generatedItem(material.getRod().get(), "materials/rod/");
            if (material.isHasScrew()) generatedItem(material.getScrew().get(), "materials/screw/");
        }
    }

    protected final ItemModelBuilder generatedItem(String name) {
        return withExistingParent(name, "item/generated").texture("layer0", modLoc("item/" + name));
    }

    protected final ItemModelBuilder generatedItem(Item item) {
        return generatedItem(item.getRegistryName().getPath());
    }

    protected final ItemModelBuilder generatedItem(String name, String loc) {
        return withExistingParent(name, "item/generated").texture("layer0", modLoc("item/" + loc + name));
    }

    protected final ItemModelBuilder generatedItem(Item item, String loc) {
        return generatedItem(item.getRegistryName().getPath(), loc);
    }

    protected void registerItemBlock(@NotNull Set<BlockItem> blockItems) {
        blockItems.forEach(blockItem -> withExistingParent(blockItem.getRegistryName().getPath(),
                modLoc("block/" + blockItem.getRegistryName().getPath())));
        skipItems(blockItems);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = getItems();
        items.removeAll(skipItems);
        registerItemBlock(items.stream()
                .filter(item -> item instanceof BlockItem)
                .map(item -> (BlockItem) item)
                .collect(Collectors.toSet()));
        items.removeAll(skipItems);
        registerItem(items);
    }
}
