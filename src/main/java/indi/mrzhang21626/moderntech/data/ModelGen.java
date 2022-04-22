package indi.mrzhang21626.moderntech.data;

import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.items.chemical.ChemicalItem;
import indi.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import indi.mrzhang21626.moderntech.utils.Utils;
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
        for (BaseItem item : ChemicalItems.items) {
            if (item instanceof ChemicalItem) {
                switch (((ChemicalItem) item).getType()) {
                    case GAS -> getBuilder(item.getRegistryName().getPath())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", Utils.mtLoc("item/layer"))
                            .texture("layer1", mcLoc("item/glass_bottle"));
                    case INGOT -> getBuilder(item.getRegistryName().getPath())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", Utils.mtLoc("item/ingot_layer"))
                            .texture("layer1", mcLoc("item/iron_ingot"));
                    case NUGGET -> getBuilder(item.getRegistryName().getPath())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", Utils.mtLoc("item/nugget_layer"))
                            .texture("layer1", mcLoc("item/iron_nugget"));
                }
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
