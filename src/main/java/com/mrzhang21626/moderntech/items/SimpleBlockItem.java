package com.mrzhang21626.moderntech.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SimpleBlockItem extends BlockItem {
    String tooltip = "";
    ChatFormatting chatFormatting = ChatFormatting.GRAY;

    public SimpleBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public SimpleBlockItem(Block block, Properties properties, CreativeModeTab tab) {
        this(block, properties.tab(tab));
    }

    public SimpleBlockItem(Block block, Properties properties, CreativeModeTab tab, String tooltip, ChatFormatting chatFormatting) {
        this(block, properties, tab);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public SimpleBlockItem(Block block, Properties properties, String tooltip, ChatFormatting chatFormatting) {
        this(block, properties);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public SimpleBlockItem(Block block, Properties properties, CreativeModeTab tab, String tooltip) {
        this(block, properties, tab, tooltip, ChatFormatting.GRAY);
    }

    public SimpleBlockItem(Block block, CreativeModeTab tab, String tooltip, ChatFormatting chatFormatting) {
        this(block, new Properties(), tab, tooltip, chatFormatting);
    }

    public SimpleBlockItem(Block block, String tooltip, ChatFormatting chatFormatting) {
        this(block, new Properties(), tooltip, chatFormatting);
    }

    public SimpleBlockItem(Block block, CreativeModeTab tab, String tooltip) {
        this(block, new Properties(), tab, tooltip);
    }

    public SimpleBlockItem(Block block, String tooltip) {
        this(block, new Properties(), tooltip, ChatFormatting.GRAY);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level p_41422_, List<Component> components, @NotNull TooltipFlag flag) {
        components.add(new TextComponent(tooltip).withStyle(chatFormatting));
        super.appendHoverText(stack, p_41422_, components, flag);
    }
}
