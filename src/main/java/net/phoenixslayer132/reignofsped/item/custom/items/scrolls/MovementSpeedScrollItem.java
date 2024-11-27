package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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

import java.util.List;


public class MovementSpeedScrollItem extends Item {
    public MovementSpeedScrollItem(Settings settings) {
        super(settings);
    }

    public int tickCounter = 0;
    private static final Identifier boostIden = Identifier.tryParse("reignofsped", "speedboost");

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            BlockPos blockPos = BlockPos.ofFloored(user.getPos().add(0, -1, 0));
            List<PlayerEntity> list = world.getEntitiesByClass(PlayerEntity.class,
                    new Box(blockPos).expand(10.0, 5.0, 10.0),
                    LivingEntity::isPlayer);
            user.sendMessage(Text.literal("As you unfurled and activate the scroll, you and your teammates feel greater control over your speed."), true);
            for (PlayerEntity playerEntity : list) {

                ServerTickEvents.START_SERVER_TICK.register(server -> {
                    var mvmtSpdAttr = playerEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                    tickCounter++;

                    if (mvmtSpdAttr != null){
                        if (mvmtSpdAttr.getModifier(boostIden) == null && tickCounter == 1)
                            mvmtSpdAttr.addTemporaryModifier(new EntityAttributeModifier(boostIden, 0.2, EntityAttributeModifier.Operation.ADD_VALUE));

                        if (mvmtSpdAttr.getModifier(boostIden) != null && tickCounter == 1800)
                            mvmtSpdAttr.removeModifier(boostIden);
                    }
                });
                tickCounter = 0;
            }

            user.getMainHandStack().decrementUnlessCreative(1, user);
        }
        return super.use(world, user, hand);
    }
}
