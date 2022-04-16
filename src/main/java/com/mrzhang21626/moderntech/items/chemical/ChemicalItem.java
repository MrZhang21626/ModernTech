package com.mrzhang21626.moderntech.items.chemical;

import com.mrzhang21626.moderntech.Tabs;
import com.mrzhang21626.moderntech.items.action.entity.IItemEntityUpdateAction;
import com.mrzhang21626.moderntech.items.action.entity.ItemEntityUpdateAction;
import com.mrzhang21626.moderntech.items.action.use.IItemUseAction;
import com.mrzhang21626.moderntech.items.action.use.ItemUseActions;
import com.mrzhang21626.moderntech.utils.Utils;
import com.mrzhang21626.moderntech.items.BaseItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class ChemicalItem extends BaseItem implements IElement {
    private final int atomicNumber;
    private final String abbreviation;
    private final String internalName;
    private int color;
    private ItemType type;
    private IItemEntityUpdateAction entityUpdateAction;
    private IItemUseAction useAction;

    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color,ItemType type){
        super(name,new Item.Properties().tab(Tabs.CHEMISTRY_TAB));
        this.internalName = name;
        this.atomicNumber = atomicNumber;
        this.abbreviation = abbreviation;
        this.color = color.getRGB();
        this.type = type;
        this.useAction = ItemUseActions.DEFAULT;
        this.entityUpdateAction = ItemEntityUpdateAction.DEFAULT;
        ChemicalItems.items.add(this);
    }
    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color,ItemType type,IItemEntityUpdateAction action){
        super(name,new Item.Properties().tab(Tabs.CHEMISTRY_TAB));
        this.internalName = name;
        this.atomicNumber = atomicNumber;
        this.abbreviation = abbreviation;
        this.color = color.getRGB();
        this.type = type;
        this.useAction = ItemUseActions.DEFAULT;
        this.entityUpdateAction = action;
        ChemicalItems.items.add(this);
    }
    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color,ItemType type,IItemUseAction action){
        super(name,new Item.Properties().tab(Tabs.CHEMISTRY_TAB));
        this.internalName = name;
        this.atomicNumber = atomicNumber;
        this.abbreviation = abbreviation;
        this.color = color.getRGB();
        this.type = type;
        this.useAction = action;
        this.entityUpdateAction = ItemEntityUpdateAction.DEFAULT;
        ChemicalItems.items.add(this);
    }
    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color,ItemType type,IItemUseAction useAction,IItemEntityUpdateAction entityUpdateAction){
        super(name,new Item.Properties().tab(Tabs.CHEMISTRY_TAB));
        this.internalName = name;
        this.atomicNumber = atomicNumber;
        this.abbreviation = abbreviation;
        this.color = color.getRGB();
        this.type = type;
        this.useAction = useAction;
        this.entityUpdateAction = entityUpdateAction;
        ChemicalItems.items.add(this);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TextComponent(Utils.getAbbr(getAbbreviation())).withStyle(ChatFormatting.GRAY));
        p_41423_.add(new TextComponent("("+atomicNumber+")").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public String getLatinChemicalName() {
        return this.internalName;
    }

    @Override
    public int getAtomicNumber() {
        return this.atomicNumber;
    }

    public int getColor(ItemStack stack,int tintIndex){
        return tintIndex>0?-1:color;
    }

    public ItemType getType(){
        return this.type;
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        return this.entityUpdateAction.onEntityUpdate(stack,entity);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        return this.useAction.onUse(p_41427_);
    }
}
