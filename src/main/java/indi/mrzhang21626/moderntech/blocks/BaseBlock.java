package indi.mrzhang21626.moderntech.blocks;

import indi.mrzhang21626.moderntech.Lists;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BaseBlock extends Block {
    public BaseBlock(Material material, MaterialColor materialColor, float strength, SoundType soundType) {
        this(BlockBehaviour.Properties.of(material, materialColor).strength(strength).sound(soundType).requiresCorrectToolForDrops());
    }

    public BaseBlock(Properties properties) {
        super(properties);

    }

    public BaseBlock withGen(){
        Lists.blockList.add(this);
        return this;
    }
}
