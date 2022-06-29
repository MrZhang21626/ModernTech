package indi.mrzhang21626.moderntech.register;

import indi.mrzhang21626.moderntech.Lists;
import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.items.BaseItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernTech.MODID);

    private ItemRegister() {
    }

    public static final class Metal {
        public static final List<ItemRegistryObject<BaseItem>> metals_ingot = new ArrayList<>();

        private static void init() {
            for (String name : Lists.metals.keySet()) {
                metals_ingot.add(defaultRegistry(name + "_ingot"));
            }
        }
    }

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Metal.init();
    }

    private static ItemRegistryObject<BaseItem> defaultRegistry(String name, int maxStackSize) {
        return register(name, () -> new BaseItem(maxStackSize));
    }

    private static ItemRegistryObject<BaseItem> defaultRegistry(String name) {
        return register(name, BaseItem::new);
    }

    private static <T extends Item> ItemRegistryObject<T> register(String name, final Supplier<T> item) {
        return new ItemRegistryObject<>(ITEMS.register(name, item));
    }

    public static class ItemRegistryObject<T extends Item> implements Supplier<T>, ItemLike {
        private RegistryObject<T> item;
        public ItemRegistryObject(RegistryObject<T> registryObject){
            this.item = registryObject;
        }

        @Override
        public T get() {
            return item.get();
        }

        @Override
        public @NotNull Item asItem() {
            return item.get();
        }
    }
}
