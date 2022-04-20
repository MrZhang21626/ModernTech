package indi.mrzhang21626.moderntech.items.chemical;

import indi.mrzhang21626.moderntech.items.BaseItem;
import indi.mrzhang21626.moderntech.utils.action.item.use.ItemUseOnActions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChemicalItems {
    public static List<BaseItem> items = new ArrayList<>();

    public static ChemicalItem hydrogenum = new ChemicalItem("hydrogenum",1,"H2",
            new Color(0x00ffffff),ItemType.GAS, ItemUseOnActions.HYDROGENUM_BURN,1);
    public static ChemicalItem helium = new ChemicalItem("helium",2,"He",
            new Color(0x00ffffff),ItemType.GAS,1);

}
