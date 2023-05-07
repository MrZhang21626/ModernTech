package com.mrzhang21626.moderntech.items;

import com.mrzhang21626.moderntech.ModernTech;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseItem extends Item {
    String tooltip = "";
    ChatFormatting chatFormatting = ChatFormatting.GRAY;

    public BaseItem(Properties properties) {
        super(properties.tab(ModernTech.MAIN_TAB));
    }

    public BaseItem(Properties properties, String tooltip) {
        this(properties);
        this.tooltip = tooltip;
    }

    public BaseItem(Properties properties, String tooltip, ChatFormatting chatFormatting) {
        this(properties);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public BaseItem(String tooltip, ChatFormatting chatFormatting) {
        this(new Properties(), tooltip, chatFormatting);
    }

    public BaseItem(String tooltip) {
        this(new Properties(), tooltip);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag flag) {
        components.add(new TextComponent(tooltip).withStyle(chatFormatting));
        super.appendHoverText(stack, p_41422_, components, flag);
    }
}
