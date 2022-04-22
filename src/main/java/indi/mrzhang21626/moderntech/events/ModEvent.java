package indi.mrzhang21626.moderntech.events;

import indi.mrzhang21626.moderntech.items.chemical.ChemicalItem;
import indi.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import indi.mrzhang21626.moderntech.items.chemical.ItemType;
import indi.mrzhang21626.moderntech.utils.Utils;
import net.minecraft.client.color.item.ItemColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Utils.MODID)
public class ModEvent {
    @SubscribeEvent
    public static void colorStuff(ColorHandlerEvent.Item event) {
        ItemColors colors = event.getItemColors();
        ChemicalItems.items.stream()
                .filter(item -> ((ChemicalItem) item).getType().equals(ItemType.GAS))
                .forEach(item -> colors.register(((ChemicalItem) item)::getColor, item));
        ChemicalItems.items.stream()
                .filter(item -> ((ChemicalItem) item).getType().equals(ItemType.INGOT) || ((ChemicalItem) item).getType().equals(ItemType.NUGGET))
                .forEach(item -> colors.register((stack, tintIndex) -> ((ChemicalItem) item).color, item));
    }
}
