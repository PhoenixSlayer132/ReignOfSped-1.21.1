package net.phoenixslayer132.reignofsped.mixin.scrolls;


import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.item.ModItems;
import net.phoenixslayer132.reignofsped.item.custom.items.scrolls.SpeedScrollItem;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Item.class)
public class SpeedScrollMixin {

    @Inject(method = "use", at = @At("HEAD"))
    public void onUse(World world, @NotNull PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> info){
        if (player.getMainHandStack() == ModItems.SPEED_SCROLL_ITEM.getDefaultStack()){
            player.sendMessage(Text.literal(String.valueOf(player.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED))));
            player.setMovementSpeed(50.0f);
            player.sendMessage(Text.literal(String.valueOf(player.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED))));
        }
    }
}
