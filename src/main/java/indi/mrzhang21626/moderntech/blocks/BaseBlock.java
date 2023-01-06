package indi.mrzhang21626.moderntech.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {

    public BaseBlock(Material material, float hardness) {
        this(Properties.of(material).strength(hardness));
    }

    public BaseBlock(Properties properties) {
        super(properties);
    }
}
