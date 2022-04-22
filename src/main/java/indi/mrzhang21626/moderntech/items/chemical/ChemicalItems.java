package indi.mrzhang21626.moderntech.items.chemical;

import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.utils.action.item.update.EntityItemUpdateActions;
import indi.mrzhang21626.moderntech.utils.action.item.use.ItemUseOnActions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChemicalItems {
    public static List<BaseItem> items = new ArrayList<>();

    public static ChemicalItem hydrogenum = new ChemicalItem("hydrogenum", 1, "H2",
            new Color(0x00FFFFFF), ItemType.GAS, ItemUseOnActions.HYDROGENUM_BURN, 1);
    public static ChemicalItem helium = new ChemicalItem("helium", 2, "He",
            new Color(0x00FFFFFF), ItemType.GAS, 1);
    public static ChemicalItem lithium = new ChemicalItem("lithium", 3, "Li",
            new Color(0xFFBBA8BB, true), ItemType.INGOT, EntityItemUpdateActions.LITHIUM_WITH_WATER, 16);

}
