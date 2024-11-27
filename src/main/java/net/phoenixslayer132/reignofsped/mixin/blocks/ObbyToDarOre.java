package net.phoenixslayer132.reignofsped.mixin.blocks;


import net.minecraft.block.Blocks;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(DragonFireballEntity.class)
public class ObbyToDarOre {

    @Inject(method = "onCollision", at = @At("HEAD"))
    private void onBlockHitMixin(HitResult hitResult, CallbackInfo ci) {
        double rng = Math.random();//random number between 0-1
        double rng2 = Math.random();//random number between 0-1
        var pos = BlockPos.ofFloored(hitResult.getPos());

        var fireball = (DragonFireballEntity)(Object)this;
        World world = fireball.getWorld();

        if (world.getBlockState(pos).isOf(Blocks.OBSIDIAN) && (rng == rng2))//gets collision block and checks if rng and rn2 are the same
            world.setBlockState(pos, ModBlocks.DAR_ORE.getDefaultState());
    }
}
