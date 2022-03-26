package com.mrzhang21626.moderntech.events;

import com.mrzhang21626.moderntech.ModernTech;
import com.mrzhang21626.moderntech.utils.Utils;
import com.mrzhang21626.moderntech.items.BaseItem;
import com.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = Utils.MODID)
public class CommonEvents {
    private static Logger LOGGER = ModernTech.LOGGER;

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event){
        for(BaseItem item : ChemicalItems.items) {
            event.getRegistry().register(item);
        }
    }

}
