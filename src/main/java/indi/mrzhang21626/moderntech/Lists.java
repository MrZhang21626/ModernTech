package indi.mrzhang21626.moderntech;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class Lists {
    public static final List<Block> blockList = new ArrayList<>();
    public static final List<BlockItem> blockItemList = new ArrayList<>();
    public static final List<Item> itemList = new ArrayList<>();

    public static final Map<String, Float> metals = new HashMap<>(){{
        put("zinc",2.5f);
        put("tin",1.5f);
    }};

    public Lists(){}

    public static void init(){}
}
