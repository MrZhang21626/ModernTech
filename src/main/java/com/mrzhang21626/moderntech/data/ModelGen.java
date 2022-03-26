package com.mrzhang21626.moderntech.data;

import com.mrzhang21626.moderntech.utils.Utils;
import com.mrzhang21626.moderntech.items.BaseItem;
import com.mrzhang21626.moderntech.items.chemical.ChemicalItem;
import com.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import com.mrzhang21626.moderntech.items.chemical.ItemType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelGen extends ItemModelProvider {

    public ModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Utils.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(BaseItem item : ChemicalItems.items){
            if(item instanceof ChemicalItem){
                if(((ChemicalItem) item).getType().equals(ItemType.GAS)){
                    getBuilder(item.getRegistryName().getPath())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0",Utils.mtLoc("item/compound"))
                            .texture("layer1",mcLoc("item/glass_bottle"));
                }
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
