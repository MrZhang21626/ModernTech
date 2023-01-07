package indi.mrzhang21626.moderntech;

import net.minecraft.resources.ResourceLocation;

public class Utils {
    public static String toCapture(String str) {
        char[] c = str.toCharArray();
        c[0] -= 32;
        return String.valueOf(c);
    }

    public static ResourceLocation modLoc(String name) {
        return new ResourceLocation(Main.MODID, name);
    }
}
