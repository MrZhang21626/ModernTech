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
            tag(forgetag("dusts/" + material.getName())).add(material.getDust().get());
            tag(forgetag("tiny_dusts/" + material.getName())).add(material.getTinyDust().get());
            tag(forgetag("ingots/" + material.getName())).add(material.getIngot().get());
            tag(forgetag("nuggets/" + material.getName())).add(material.getNugget().get());
            tag(forgetag("plates/" + material.getName())).add(material.getPlate().get());
            tag(forgetag("rods/" + material.getName())).add(material.getRod().get());
            tag(forgetag("storage_blocks/" + material.getName())).add(material.getBlockItem().get());
            tag(forgetag("dusts")).add(material.getDust().get());
            tag(forgetag("tiny_dusts")).add(material.getTinyDust().get());
            tag(forgetag("ingots")).add(material.getIngot().get());
            tag(forgetag("nuggets")).add(material.getNugget().get());
            tag(forgetag("plates")).add(material.getPlate().get());
            tag(forgetag("rods")).add(material.getRod().get());
            tag(forgetag("storage_blocks")).add(material.getBlockItem().get());

        }
    }

    private TagKey<Item> forgetag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
