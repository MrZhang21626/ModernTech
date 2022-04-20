package indi.mrzhang21626.moderntech.items.chemical;

import indi.mrzhang21626.moderntech.Tabs;
import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.utils.Utils;
import indi.mrzhang21626.moderntech.utils.action.item.update.EntityItemUpdateActions;
import indi.mrzhang21626.moderntech.utils.action.item.update.IEntityItemUpdateAction;
import indi.mrzhang21626.moderntech.utils.action.item.use.IItemUseOnAction;
import indi.mrzhang21626.moderntech.utils.action.item.use.ItemUseOnActions;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class ChemicalItem extends BaseItem implements IElement {
    private final int atomicNumber;
    private final String abbreviation;
    private final String internalName;
    public int color;
    private ItemType type;

    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color, ItemType type, IItemUseOnAction itemUseOnAction, IEntityItemUpdateAction entityItemUpdateAction,int max_stack) {
        super(name, new Properties().tab(Tabs.CHEMISTRY_TAB).stacksTo(max_stack));
        super.setEntityItemUpdateAction(entityItemUpdateAction);
        super.setItemUseOnAction(itemUseOnAction);
        this.internalName = name;
        this.atomicNumber = atomicNumber;
        this.abbreviation = abbreviation;
        this.color = color.getRGB();
        this.type = type;
        ChemicalItems.items.add(this);
    }

    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color, ItemType type, IItemUseOnAction itemUseOnAction,int max_stack) {
        this(name, atomicNumber, abbreviation, color, type, itemUseOnAction, EntityItemUpdateActions.DEFAULT,max_stack);
    }

    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color, ItemType type, IEntityItemUpdateAction entityItemUpdateAction,int max_stack) {
        this(name, atomicNumber, abbreviation, color, type, ItemUseOnActions.DEFAULT, entityItemUpdateAction,max_stack);
    }

    public ChemicalItem(String name, int atomicNumber, String abbreviation, Color color, ItemType type,int max_stack) {
        this(name, atomicNumber, abbreviation, color, type, ItemUseOnActions.DEFAULT, EntityItemUpdateActions.DEFAULT,max_stack);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TextComponent(Utils.getAbbr(getAbbreviation())).withStyle(ChatFormatting.GRAY));
        p_41423_.add(new TextComponent("(" + atomicNumber + ")").withStyle(ChatFormatting.GRAY));
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

    public int getColor(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : color;
    }

    public ItemType getType() {
        return this.type;
    }

}
