package com.mrzhang21626.moderntech.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseItem extends Item {
    String tooltip = "";
    ChatFormatting chatFormatting;

    public BaseItem(Properties properties) {
        super(properties);
    }

    public BaseItem(Properties properties, CreativeModeTab tab) {
        this(properties.tab(tab));
    }

    public BaseItem(Properties properties, CreativeModeTab tab, String tooltip, ChatFormatting chatFormatting) {
        this(properties, tab);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public BaseItem(Properties properties, String tooltip, ChatFormatting chatFormatting) {
        this(properties);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public BaseItem(Properties properties, CreativeModeTab tab, String tooltip) {
        this(properties, tab, tooltip, ChatFormatting.GRAY);
    }

    public BaseItem(CreativeModeTab tab, String tooltip, ChatFormatting chatFormatting) {
        this(new Properties(), tab, tooltip, chatFormatting);
    }

    public BaseItem(String tooltip, ChatFormatting chatFormatting) {
        this(new Properties(), tooltip, chatFormatting);
    }

    public BaseItem(CreativeModeTab tab, String tooltip) {
        this(new Properties(), tab, tooltip);
    }

    public BaseItem(String tooltip) {
        this(new Properties(), tooltip, ChatFormatting.GRAY);
    }


    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level p_41422_, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (!tooltip.equals("")) components.add(new TextComponent(tooltip).withStyle(chatFormatting));
        super.appendHoverText(stack, p_41422_, components, flag);
    }
}
