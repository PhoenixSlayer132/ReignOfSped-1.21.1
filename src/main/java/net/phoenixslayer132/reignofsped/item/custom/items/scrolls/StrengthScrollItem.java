package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

import java.util.List;
import java.util.Objects;


public class StrengthScrollItem extends Item {
    public StrengthScrollItem(Settings settings) {
        super(settings);
    }

    public int tickCounter = 0;


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.getWorld().isClient() && !user.isSneaking()) {
            BlockPos blockPos = BlockPos.ofFloored(user.getPos().add(0, -1, 0));

            List<PlayerEntity> list = world.getEntitiesByClass(PlayerEntity.class,
                    new Box(blockPos).expand(10.0, 5.0, 10.0),
                    LivingEntity::isPlayer);
            user.sendMessage(Text.literal("You and your teammates feel your muscles strengthening as time goes on after you unfurled and activated the scroll."), true);
            for (PlayerEntity playerEntity : list) {

                Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                        .addTemporaryModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE));

                ServerTickEvents.START_SERVER_TICK.register(server -> {
                    tickCounter++;
                    if (tickCounter == 40) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 3.0, EntityAttributeModifier.Operation.ADD_VALUE));
                    }

                    if (tickCounter == 80) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.0, EntityAttributeModifier.Operation.ADD_VALUE));
                    }

                    if (tickCounter == 120) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 11.0, EntityAttributeModifier.Operation.ADD_VALUE));
                    }

                    if (tickCounter == 160) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 14.0, EntityAttributeModifier.Operation.ADD_VALUE));

                    }

                    if (tickCounter == 1400) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 0.5, EntityAttributeModifier.Operation.ADD_VALUE));
                    }
                    if (tickCounter == 1800) {
                        Objects.requireNonNull(playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE))
                                .updateModifier(new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE));

                    }
                });
            }
            tickCounter = 0;
            if (!user.isCreative())
                user.getMainHandStack().decrement(1);
        }

        /*
        if (!user.getWorld().isClient() && user.isSneaking())
            user.sendMessage(Text.of(String.valueOf(user.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE))));//DELETE
         */

        return super.use(world, user, hand);
    }





}
