package com.mrzhang21626.moderntech.events;

import com.mrzhang21626.moderntech.materials.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onItemColorHandlerEvent(ColorHandlerEvent.Item event) {
        for (var material : Material.values()) {
            for (var item : material.ITEMS.values()) {
                event.getItemColors().register((stack, id) -> material.color, item.get());
            }
        }
    }

}
