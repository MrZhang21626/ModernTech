package indi.mrzhang21626.moderntech.registries;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.blocks.BaseBlockItem;
import indi.mrzhang21626.moderntech.blocks.PlateBlockItem;
import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    private static void registerMaterials() {
        for (var material : Material.values()) {
            if (material.isHasDust()) material.setDust(ITEMS.register(material.getName() + "_dust", BaseItem::new));
            if (material.isHasTinyDust())
                material.setTinyDust(ITEMS.register(material.getName() + "_tiny_dust", BaseItem::new));
            if (material.isHasIngot()) material.setIngot(ITEMS.register(material.getName() + "_ingot", BaseItem::new));
            if (material.isHasNugget())
                material.setNugget(ITEMS.register(material.getName() + "_nugget", BaseItem::new));
            if (material.isHasPlate()) material.setPlate(ITEMS.register(material.getName() + "_plate", BaseItem::new));
            if (material.isHasRod()) material.setRod(ITEMS.register(material.getName() + "_rod", BaseItem::new));
            if (material.isHasScrew()) material.setScrew(ITEMS.register(material.getName() + "_screw", BaseItem::new));

            if (material.isHasBlock()) material.setBlockItem(ITEMS.register(material.getName() + "_block",
                    () -> new BaseBlockItem(material.getBlock().get())));

            if (material.isHasPlate()) {
                for (var screw : Material.values()) {
                    if (screw.isHasScrew()) {
                        material.addItemBlockOfPlate(screw, ITEMS.register(
                                "block_of_" + material.getName() + "_plate_with_" + screw.getName() + "_screw",
                                () -> new PlateBlockItem(material.getBlockOfPlate().get(screw).get(), material, screw)));
                    }
                }
            }
        }
    }

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        registerMaterials();
    }
}
