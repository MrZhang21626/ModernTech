package indi.mrzhang21626.moderntech.multiblock;

import indi.mrzhang21626.moderntech.multiblock.multiblocks.MultiBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;

public class MultiBlock {
    private final Block[][][] multiBlocks;
    private final BlockPos point;
    private final String name;

    public static Block AIR = Blocks.AIR;

    public MultiBlock(Block[][][] multiBlocks, BlockPos point, String name) {
        this.multiBlocks = multiBlocks;
        this.point = point;
        this.name = name;
        MultiBlocks.MULTI_BLOCKS.add(this);
    }

    public boolean isOK(float rot, BlockPos pos, Level level) {
        for (int t = 0; t < 4; t++) {
            boolean isOK = true;
            int sx, sy, sz;
            sx = sy = sz = 0;
            if (rot == 0) {
                sx = pos.getX() + point.getX();
                sy = pos.getY() - point.getY();
                sz = pos.getZ() - point.getZ();
            } else if (rot == 90) {
                sx = pos.getX() - point.getZ();
                sy = pos.getY() - point.getY();
                sz = pos.getZ() + point.getX();
            } else if (rot == 180) {
                sx = pos.getX() - point.getX();
                sy = pos.getY() - point.getY();
                sz = pos.getZ() + point.getZ();
            } else if (rot == 270) {
                sx = pos.getX() - point.getZ();
                sy = pos.getY() - point.getY();
                sz = pos.getZ() - point.getX();
            }
            compare:
            for (int j = 0; j < multiBlocks.length; j++) {
                for (int i = 0; i < multiBlocks[j].length; i++) {
                    for (int k = 0; k < multiBlocks[j][i].length; k++) {
                        int x = sx, y = sy, z = sz;
                        Block block = multiBlocks[j][i][k];
                        if (rot == 0) {
                            x = sx - i;
                            y = sy + j;
                            z = sz + k;
                        } else if (rot == 90) {
                            x = sx - k;
                            y = sy + j;
                            z = sz - i;
                        } else if (rot == 180) {
                            x = sx + i;
                            y = sy + j;
                            z = sz - k;
                        } else if (rot == 270) {
                            x = sx + k;
                            y = sy + j;
                            z = sz + i;
                        }
                        BlockPos blockPos = new BlockPos(x, y, z);
                        Block levelBlock = level.getBlockState(blockPos).getBlock();
                        if (!(levelBlock.equals(block))) {
                            if (!(block.equals(AIR) &&
                                    (levelBlock.equals(Blocks.CAVE_AIR) ||
                                            levelBlock.equals(Blocks.VOID_AIR)))) {
                                isOK = false;
                                break compare;
                            }
                        }
                    }
                }
            }rot = (rot + 90) % 360;
            if (isOK) return true;
        }
        return false;
    }

    @Nullable
    public static MultiBlock getMultiBlock(float rot, BlockPos pos, Level level) {
        MultiBlocks.init();
        for (MultiBlock multiBlock : MultiBlocks.MULTI_BLOCKS) {
            if (multiBlock.isOK(rot, pos, level)) return multiBlock;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
