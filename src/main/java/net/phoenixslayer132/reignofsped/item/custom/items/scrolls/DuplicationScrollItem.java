package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.minecraft.component.Component;
import net.minecraft.component.ComponentMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class DuplicationScrollItem extends Item {
    public DuplicationScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, @NotNull PlayerEntity user, Hand hand) {
        if (!world.isClient()){
            if(isOffHandFull(user.getOffHandStack())){//checks if offhand is empty
                if (isThereOnlyOneDuplicationScroll(user.getMainHandStack(), user.getActiveHand())){//checks if main hand only has 1 duplication scroll
                    user.sendMessage(Text.literal("As you unfurl the scroll you watch it morph into the item you were holding."), true);
                    user.getMainHandStack().decrementUnlessCreative(1, user);
                    ItemStack copiedItem = user.getOffHandStack().copyComponentsToNewStack(user.getOffHandStack().getItem(), 1);
                    user.setStackInHand(Hand.MAIN_HAND, copiedItem);
                }
                else
                    user.sendMessage(Text.literal("These stack of scrolls seem to interfere with each others power."), true);
            }
            else
                user.sendMessage(Text.literal("Upon unfurling the scroll you feel you're left hand's emptiness."), true);
        }
        if (!user.isCreative())
            user.getMainHandStack().decrement(1);
        return super.use(world, user, hand);
    }
    public boolean isOffHandFull(ItemStack itemStack){
        return !itemStack.isEmpty();
    }
    public boolean isThereOnlyOneDuplicationScroll(ItemStack itemStack, Hand hand){
        if (hand.equals(Hand.MAIN_HAND)){
            if(itemStack.getCount() > 1) //checks if main hand only has 1 Duplication scroll
                return false;
            else
                return itemStack.getCount() == 1;
        }
        else return false;
    }
}
