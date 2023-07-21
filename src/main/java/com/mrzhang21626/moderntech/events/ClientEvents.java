package com.mrzhang21626.moderntech.events;

import com.mrzhang21626.moderntech.materials.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onItemColorHandlerEvent(ColorHandlerEvent.Item event) {
        for (var material : Material.values()) {
            for (var item : material.ITEMS.values()) {
                switch (Objects.requireNonNull(item.get().getRegistryName()).getPath()) {
                    case "iron_ingot", "iron_nugget", "copper_ingot", "gold_ingot", "gold_nugget" -> {
                    }
                    default -> event.getItemColors().register((stack, id) -> material.color, item.get());
                }
            }
            for (var item : material.TOOLS.values()) {
                event.getItemColors().register((stack, id) -> {
                    if (id == 0) return material.color;
                    else return -1;
                }, item.get());
            }
        }
    }

}
