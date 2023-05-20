package com.mrzhang21626.moderntech.registries.registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistration {
    private Item item;
    private RegistryObject<Item> registryObject;
    private final boolean isSimpleItem;

    public ItemRegistration(Item item) {
        this.item = item;
        isSimpleItem = true;
    }

    public ItemRegistration(RegistryObject<Item> registryObject) {
        this.registryObject = registryObject;
        isSimpleItem = false;
    }

    public Item get() {
        if (isSimpleItem) return item;
        else return registryObject.get();
    }
}
