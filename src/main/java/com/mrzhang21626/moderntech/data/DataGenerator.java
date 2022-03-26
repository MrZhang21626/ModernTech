package com.mrzhang21626.moderntech.data;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event){
        event.getGenerator().addProvider(new ModelGen(event.getGenerator(),event.getExistingFileHelper()));
    }
}
