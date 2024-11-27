package net.phoenixslayer132.reignofsped.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.block.ModBlockEntityTypes;

public class TreasureChestBlock extends BlockWithEntity {
    public TreasureChestBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends TreasureChestBlock> getCodec() {
        return createCodec(TreasureChestBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TreasureChestBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        // Make sure to check world.isClient if you only want to tick only on serverside.
        return validateTicker(type, ModBlockEntityTypes.TREASURE_CHEST_BLOCK_ENTITY_TYPE, TreasureChestBlockEntity::tick);
    }
}
