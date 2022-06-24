package indi.mrzhang21626.moderntech.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        event.getGenerator().addProvider(new ItemModelGenerator(event.getGenerator(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(new BlockModelGenerator(event.getGenerator(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(new BlockStateGenerator(event.getGenerator(), event.getExistingFileHelper()));
    }
}
