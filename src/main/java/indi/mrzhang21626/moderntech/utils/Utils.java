package indi.mrzhang21626.moderntech.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;

import java.util.Random;

public class Utils {
    public static final String MODID = "moderntech";

    public static String getAbbr(String s) {
        StringBuilder ans = new StringBuilder();
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (!(c <= '9' && c >= '0')) flag = true;
            if (!flag) {
                if (c <= '9' && c >= '0') {
                    ans.append(c);
                } else {
                    flag = true;
                }
            } else {
                if (c <= '9' && c >= '0') {
                    ans.append((char) (c - '0' + 0x2080));
                } else {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }

    public static ResourceLocation mtLoc(String loc) {
        return new ResourceLocation(Utils.MODID, loc);
    }

    public static void playSound(Level level, BlockPos pos, SoundEvent sound)
    {
        Random rand = level.getRandom();
        level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() + 0.7F + 0.3F);
    }
}
