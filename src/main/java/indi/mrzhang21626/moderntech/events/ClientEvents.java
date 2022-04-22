package indi.mrzhang21626.moderntech.events;

import indi.mrzhang21626.moderntech.utils.Utils;
import indi.mrzhang21626.moderntech.utils.tooltip.ITooltipValue;
import indi.mrzhang21626.moderntech.utils.tooltip.TooltipValue;
import indi.mrzhang21626.moderntech.utils.tooltip.TooltipValuePair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

import static indi.mrzhang21626.moderntech.utils.Utils.getAbbr;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Utils.MODID)
public class ClientEvents {
    @SubscribeEvent
    public static void onTooltipCheck(ItemTooltipEvent event) {
        Map<Item, ITooltipValue> items = new HashMap<>();
        items.put(Items.BONE, new TooltipValue(getAbbr("Ca3(PO4)2")));
        items.put(Items.COAL, new TooltipValuePair(getAbbr("C"), 6));

        for (Map.Entry<Item, ITooltipValue> pair : items.entrySet()) {
            if (event.getItemStack().getItem().equals(pair.getKey())) {
                event.getToolTip().add(new TextComponent(pair.getValue().getAbbr()).withStyle(ChatFormatting.GRAY));
                if (pair.getValue() instanceof TooltipValuePair) {
                    event.getToolTip().add(new TextComponent("(" + pair.getValue().getAbbr() + ")").withStyle(ChatFormatting.GRAY));
                }
            }
        }
    }
}
