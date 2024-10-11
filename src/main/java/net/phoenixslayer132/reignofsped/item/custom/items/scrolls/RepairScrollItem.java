package net.phoenixslayer132.reignofsped.item.custom.items.scrolls;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class RepairScrollItem extends Item {
    public RepairScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, @NotNull PlayerEntity user, Hand hand) {
        if (!world.isClient())
                repairItems(user.getInventory());

        if (!user.isCreative())
            user.getMainHandStack().decrement(1);

        return super.use(world, user, hand);
    }

    public boolean repairable(ItemStack itemStack){
        if(itemStack.isEmpty() || !itemStack.isDamageable()) //checks if slots in inventory are empty or not damageable
            return false;
        else
            return itemStack.getMaxDamage() > 0;
    }

    private void repairItems(Inventory inventory){
        for (int slot = 0; slot < inventory.size(); slot++){//get inventory slot
            ItemStack itemStack = inventory.getStack(slot);//get item
            if(repairable(itemStack)){
                itemStack.setDamage(0);//repair item
            }
        }
    }
}
