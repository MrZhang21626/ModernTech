package indi.mrzhang21626.moderntech.datagen;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ModernTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(Item item : Lists.itemList){
            getBuilder(item.getDescriptionId())
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0",modLoc(item.getDescriptionId()));
        }
    }
}
