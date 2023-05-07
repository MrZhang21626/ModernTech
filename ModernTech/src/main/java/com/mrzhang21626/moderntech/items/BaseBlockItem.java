package com.mrzhang21626.moderntech.items;

import com.mrzhang21626.moderntech.ModernTech;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseBlockItem extends BlockItem {
    String tooltip = "";
    ChatFormatting chatFormatting = ChatFormatting.GRAY;

    public BaseBlockItem(Block block, Properties properties) {
        super(block, properties.tab(ModernTech.MAIN_TAB));
    }

    public BaseBlockItem(Block block, Properties properties, String tooltip) {
        this(block, properties);
        this.tooltip = tooltip;
    }

    public BaseBlockItem(Block block, Properties properties, String tooltip, ChatFormatting chatFormatting) {
        this(block, properties);
        this.tooltip = tooltip;
        this.chatFormatting = chatFormatting;
    }

    public BaseBlockItem(Block block, String tooltip, ChatFormatting chatFormatting) {
        this(block, new Properties(), tooltip, chatFormatting);
    }

    public BaseBlockItem(Block block, String tooltip) {
        this(block, new Properties(), tooltip);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag flag) {
        components.add(new TextComponent(tooltip).withStyle(chatFormatting));
        super.appendHoverText(stack, p_41422_, components, flag);
    }
}
