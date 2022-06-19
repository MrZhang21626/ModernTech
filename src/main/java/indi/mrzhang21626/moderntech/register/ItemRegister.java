package indi.mrzhang21626.moderntech.register;

import indi.mrzhang21626.moderntech.ModernTech;
import indi.mrzhang21626.moderntech.items.BaseItem;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernTech.MODID);

    public static final class Materials{
        public static final ItemRegistryObject<BaseItem> ZINC_INGOT = registry("zinc_ingot");

        private static void init(){}
    }

    public static void init(){
        ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Materials.init();
    }

    private static ItemRegistryObject<BaseItem> registryWithStackSize(String name, int maxStackSize) {
        return registry(name, p -> p.stacksTo(maxStackSize), i -> {
        });
    }

    private static ItemRegistryObject<BaseItem> registry(String name) {
        return registry(name, $ -> {
        }, $ -> {
        });
    }

    private static ItemRegistryObject<BaseItem> registry(String name, Consumer<Item.Properties> propertiesConsumer, Consumer<BaseItem> baseItemConsumer) {
        return register(name, () -> Util.make(new BaseItem(Util.make(new Item.Properties(), propertiesConsumer)), baseItemConsumer));
    }

    private static <I extends Item> ItemRegistryObject<I> register(String name, Supplier<? extends I> make) {
        return new ItemRegistryObject<>(ITEMS. register(name, make));
    }

    private static <I extends Item> ItemRegistryObject<I> of(I item) {
        return new ItemRegistryObject<>(RegistryObject.create(item.getRegistryName(), ForgeRegistries.ITEMS));
    }

    public static class ItemRegistryObject<I extends Item> implements Supplier<I>, ItemLike {
        private final RegistryObject<I> registryObject;

        private ItemRegistryObject(RegistryObject<I> registryObject) {
            this.registryObject = registryObject;
        }

        @Override
        @Nonnull
        public I get() {
            return registryObject.get();
        }

        @Override
        @Nonnull
        public Item asItem() {
            return registryObject.get();
        }

        public ResourceLocation getID() {
            return registryObject.getId();
        }
    }
}
