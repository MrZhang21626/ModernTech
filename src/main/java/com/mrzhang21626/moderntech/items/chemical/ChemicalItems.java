package com.mrzhang21626.moderntech.items.chemical;

import com.mrzhang21626.moderntech.items.BaseItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChemicalItems {
    public static List<BaseItem> items = new ArrayList<>();

    public static ChemicalItem hydrogenum = new ChemicalItem("hydrogenum",1,"H2",new Color(0x00ffffff),ItemType.GAS);
    public static ChemicalItem helium = new ChemicalItem("helium",2,"He",new Color(0xFFFFFF),ItemType.GAS);

}
