package indi.mrzhang21626.moderntech.datagen.tags;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ItemTagsGenerator extends ItemTagsProvider {
    public ItemTagsGenerator(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (var material : Material.values()) {
            if (material.isHasDust()) tag(forgetag("dusts/" + material.getName())).add(material.getDust().get());
            if (material.isHasTinyDust())
                tag(forgetag("tiny_dusts/" + material.getName())).add(material.getTinyDust().get());
            if (material.isHasIngot()) tag(forgetag("ingots/" + material.getName())).add(material.getIngot().get());
            if (material.isHasNugget()) tag(forgetag("nuggets/" + material.getName())).add(material.getNugget().get());
            if (material.isHasPlate()) tag(forgetag("plates/" + material.getName())).add(material.getPlate().get());
            if (material.isHasRod()) tag(forgetag("rods/" + material.getName())).add(material.getRod().get());
            if (material.isHasScrew()) tag(forgetag("screws/" + material.getName())).add(material.getScrew().get());
            if (material.isHasDust()) tag(forgetag("dusts")).add(material.getDust().get());
            if (material.isHasTinyDust()) tag(forgetag("tiny_dusts")).add(material.getTinyDust().get());
            if (material.isHasIngot()) tag(forgetag("ingots")).add(material.getIngot().get());
            if (material.isHasNugget()) tag(forgetag("nuggets")).add(material.getNugget().get());
            if (material.isHasPlate()) tag(forgetag("plates")).add(material.getPlate().get());
            if (material.isHasRod()) tag(forgetag("rods")).add(material.getRod().get());
            if (material.isHasScrew()) tag(forgetag("screws")).add(material.getScrew().get());

        }
    }

    private TagKey<Item> forgetag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
