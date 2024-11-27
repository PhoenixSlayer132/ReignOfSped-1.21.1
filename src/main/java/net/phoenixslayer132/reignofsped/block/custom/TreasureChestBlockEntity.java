package net.phoenixslayer132.reignofsped.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.block.ModBlockEntityTypes;

public class TreasureChestBlockEntity extends BlockEntity {

    public TreasureChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TREASURE_CHEST_BLOCK_ENTITY_TYPE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, TreasureChestBlockEntity blockEntity) {
        if (!world.isClient()) {

        }
    }

}