package indi.mrzhang21626.moderntech.blocks;

import indi.mrzhang21626.moderntech.materials.Material;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlateBlockItem extends BaseBlockItem {
    private final Material plate, screw;

    public PlateBlockItem(Block block, Material plate, Material screw) {
        super(block);
        this.plate = plate;
        this.screw = screw;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent("tooltip.moderntech.plate"));
        components.add(new TranslatableComponent("materials.moderntech." + plate.getName()).withStyle(ChatFormatting.GRAY));
        components.add(new TranslatableComponent("tooltip.moderntech.screw"));
        components.add(new TranslatableComponent("materials.moderntech." + screw.getName()).withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, level, components, flag);
    }
}
