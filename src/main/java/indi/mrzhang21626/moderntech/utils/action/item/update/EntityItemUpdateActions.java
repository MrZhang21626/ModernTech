package indi.mrzhang21626.moderntech.utils.action.item.update;

import indi.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import indi.mrzhang21626.moderntech.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityItemUpdateActions {
    public static final IEntityItemUpdateAction LITHIUM_WITH_WATER = (stack, entity) -> {
        Level level = entity.getLevel();
        BlockPos pos = entity.getOnPos();
        BlockState stateOn = level.getBlockState(pos);
        if (Utils.isFluid(stateOn.getFluidState(), FluidTags.WATER)) {
            entity.setNeverPickUp();
            Utils.playSound(level, pos, SoundEvents.FISHING_BOBBER_RETRIEVE);
            Utils.addParticle(level, pos, ParticleTypes.BUBBLE_COLUMN_UP);
            if (entity.getItem().is(ChemicalItems.lithium)) {
                if (entity.getAge() >= 900) {
                    entity.kill();
                } else if (entity.getAge() >= 50) {
                    Utils.addParticle(level, pos, ParticleTypes.BUBBLE_COLUMN_UP);
                }
            } else {
                if (entity.getAge() >= 100) {
                    entity.kill();
                } else if (entity.getAge() >= 50) {
                    Utils.addParticle(level, pos, ParticleTypes.BUBBLE_COLUMN_UP);
                }
            }
        }
    };

    public static final IEntityItemUpdateAction DEFAULT = (stack, entity) -> {};
}
