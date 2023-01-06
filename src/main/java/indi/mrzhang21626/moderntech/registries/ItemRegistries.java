package indi.mrzhang21626.moderntech.registries;

import indi.mrzhang21626.moderntech.Main;
import indi.mrzhang21626.moderntech.blocks.BaseBlockItem;
import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    private static void registryMaterials() {
        for (Material material : Material.values()) {
            material.setDust(ITEMS.register(material.getName() + "_dust", BaseItem::new));
            material.setTinyDust(ITEMS.register(material.getName() + "_tiny_dust", BaseItem::new));
            material.setIngot(ITEMS.register(material.getName() + "_ingot", BaseItem::new));
            material.setNugget(ITEMS.register(material.getName() + "_nugget", BaseItem::new));
            material.setPlate(ITEMS.register(material.getName() + "_plate", BaseItem::new));
            material.setRod(ITEMS.register(material.getName() + "_rod", BaseItem::new));
            material.setBlockItem(ITEMS.register(material.getName() + "_block",
                    () -> new BaseBlockItem(material.getBlock().get())));
        }
    }

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        registryMaterials();
    }
}
