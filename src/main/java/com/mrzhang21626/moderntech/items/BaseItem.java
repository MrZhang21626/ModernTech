package com.mrzhang21626.moderntech.items;

import com.mrzhang21626.moderntech.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {
    public BaseItem(String name, Properties properties){
        super(properties);
        setRegistryName(new ResourceLocation(Utils.MODID,name));
    }
}
