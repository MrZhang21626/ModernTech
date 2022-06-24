package indi.mrzhang21626.moderntech.register;

import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.items.BaseItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernTech.MODID);

    private ItemRegister() {
    }

    public static final class Metal {
        public static final RegistryObject<Item> ZINC_INGOT = registry("zinc_ingot");
        public static final RegistryObject<Item> TIN_INGOT = registry("tin_ingot");

        private static void init() {
        }
    }

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Metal.init();
    }

    private static <T extends Item> RegistryObject<T> registry(String name, int maxStackSize){
        return (RegistryObject<T>) registry(name,()->new BaseItem(maxStackSize));
    }

    private static <T extends Item> RegistryObject<T> registry(String name){
        return (RegistryObject<T>) registry(name,BaseItem::new);
    }

    private static <T extends Item> RegistryObject<T> registry(String name,final Supplier<T> item){
        RegistryObject<T> object = ITEMS.register(name,item);
        return object;
    }
}
