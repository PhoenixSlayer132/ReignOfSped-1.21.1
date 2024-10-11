package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class RestorationScrollItem extends Item {
    public RestorationScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getWorld().isClient()){
            BlockPos blockPos = BlockPos.ofFloored(user.getPos().add(0, -1, 0));


            List<PlayerEntity> list = world.getEntitiesByClass(PlayerEntity.class,
                    new Box(blockPos).expand(10.0, 5.0, 10.0),
                    LivingEntity:: isMobOrPlayer);
            user.sendMessage(Text.literal("You and your teammates feel your cells regenerating at a quick pace after you unfurled and activated the scroll."), true);
            for (PlayerEntity playerEntity : list){
                if (playerEntity.getHealth() <= playerEntity.getMaxHealth()/3){
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 4));
                }
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 4));
            user.getMainHandStack().decrement(1);
        }
        return super.use(world, user, hand);
    }
}
