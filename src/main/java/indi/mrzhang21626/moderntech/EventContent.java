package indi.mrzhang21626.moderntech;

import indi.mrzhang21626.moderntech.register.BlockRegister;
import indi.mrzhang21626.moderntech.register.ItemRegister;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModernTech.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventContent {
    public static void construction() {
        ItemRegister.init();
        BlockRegister.init();
    }
}
