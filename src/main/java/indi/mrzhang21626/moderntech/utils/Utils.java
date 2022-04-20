package indi.mrzhang21626.moderntech.utils;

import net.minecraft.resources.ResourceLocation;

public class Utils {
    public static final String MODID = "moderntech";

    public static String getAbbr(String s){
        StringBuilder ans = new StringBuilder();
        boolean flag=false;
        for(char c : s.toCharArray()){
            if(!(c<='9'&&c>='0'))flag=true;
            if(!flag){
                if(c<='9'&&c>='0'){
                    ans.append(c);
                }else{
                    flag=true;
                }
            }else{
                if(c<='9'&&c>='0'){
                    ans.append((char)(c - '0' + 0x2080));
                }else{
                    ans.append(c);
                }
            }
        }return ans.toString();
    }

    public static ResourceLocation mtLoc(String loc){
        return new ResourceLocation(Utils.MODID,loc);
    }
}
