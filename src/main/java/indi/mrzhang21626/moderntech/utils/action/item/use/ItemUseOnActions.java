package indi.mrzhang21626.moderntech.utils.action.item.use;

import indi.mrzhang21626.moderntech.items.chemical.ChemicalItems;
import indi.mrzhang21626.moderntech.utils.Utils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Random;

public class ItemUseOnActions {
    public static final IItemUseOnAction HYDROGENUM_BURN = pContext -> {
        Player player = pContext.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        Random random = player.getRandom();
        int damage;
        if (mainHand.is(Items.FLINT_AND_STEEL) && offHand.is(ChemicalItems.hydrogenum)) {
            damage = mainHand.getDamageValue();
            mainHand.setDamageValue(damage + 1);
            offHand.shrink(1);
            if (random.nextInt(40) == 1) {
                Utils.playSound(player.getLevel(), player.getOnPos(), SoundEvents.GLASS_BREAK);
            } else {
                player.addItem(new ItemStack(Items.GLASS_BOTTLE));
            }
        } else if (mainHand.is(ChemicalItems.hydrogenum) && offHand.is(Items.FLINT_AND_STEEL)) {
            damage = offHand.getDamageValue();
            offHand.setDamageValue(damage + 1);
            mainHand.shrink(1);
            if (random.nextInt(40) == 1) {
                Utils.playSound(player.getLevel(), player.getOnPos(), SoundEvents.GLASS_BREAK);
            } else {
                player.addItem(new ItemStack(Items.GLASS_BOTTLE));
            }
        } else {
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    };

    public static final IItemUseOnAction DEFAULT = pContext -> InteractionResult.PASS;
}
