package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

import java.util.List;


public class AttackSpeedScrollItem extends Item {
    public AttackSpeedScrollItem(Settings settings) {
        super(settings);
    }

    public int tickCounter = 0;
    private static final Identifier boostIden = Identifier.tryParse("reignofsped", "attackspeedboost");


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!user.getWorld().isClient() && !user.isSneaking()) {
            BlockPos blockPos = BlockPos.ofFloored(user.getPos().add(0, -1, 0));

            List<PlayerEntity> list = world.getEntitiesByClass(PlayerEntity.class,
                    new Box(blockPos).expand(10.0, 5.0, 10.0),
                    LivingEntity::isPlayer);

            user.sendMessage(Text.literal("As you unfurled and activate the scroll, you and your teammates feel greater control over your muscles."), true);
            for (PlayerEntity playerEntity : list) {

                ServerTickEvents.START_SERVER_TICK.register(server -> {
                    tickCounter++;
                    var atkSpdAttr = playerEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);

                    if (atkSpdAttr != null){
                        if (atkSpdAttr.getModifier(boostIden) == null && tickCounter == 1)
                            atkSpdAttr.addTemporaryModifier(new EntityAttributeModifier(boostIden, 2.0, EntityAttributeModifier.Operation.ADD_VALUE));

                        if (atkSpdAttr.getModifier(boostIden) != null && tickCounter == 20)
                            atkSpdAttr.updateModifier(new EntityAttributeModifier(boostIden, 3.0, EntityAttributeModifier.Operation.ADD_VALUE));

                        if (atkSpdAttr.getModifier(boostIden) != null && tickCounter == 40)
                            atkSpdAttr.updateModifier(new EntityAttributeModifier(boostIden, 4.0, EntityAttributeModifier.Operation.ADD_VALUE));

                        if (atkSpdAttr.getModifier(boostIden) != null && tickCounter == 60)
                            atkSpdAttr.updateModifier(new EntityAttributeModifier(boostIden, 5.0, EntityAttributeModifier.Operation.ADD_VALUE));

                        if (atkSpdAttr.getModifier(boostIden) != null && tickCounter == 1800)
                            atkSpdAttr.removeModifier(boostIden);
                    }

                });
            }
            tickCounter = 0;

            user.getMainHandStack().decrementUnlessCreative(1, user);
        }
        return super.use(world, user, hand);
    }
}
