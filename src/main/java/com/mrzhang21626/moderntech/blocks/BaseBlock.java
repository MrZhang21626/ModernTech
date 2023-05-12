package com.mrzhang21626.moderntech.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {
    public BaseBlock(Properties properties) {
        super(properties);
    }

    public BaseBlock(Material material, SoundType sound, float strength) {
        this(Properties.of(material).sound(sound).strength(strength));
    }
}
