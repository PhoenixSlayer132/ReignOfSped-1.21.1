package net.phoenixslayer132.reignofsped.block.custom;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.block.ModBlockEntityTypes;
import net.phoenixslayer132.reignofsped.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import static net.phoenixslayer132.reignofsped.block.ModBlocks.DUPLICATOR_BLOCK;

public class DuplicatorBlock extends BlockWithEntity {
    public DuplicatorBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends DuplicatorBlock> getCodec() {
        return createCodec(DuplicatorBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DuplicatorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        // Make sure to check world.isClient if you only want to tick only on serverside.
        return validateTicker(type, ModBlockEntityTypes.DUPLICATOR_BLOCK_ENTITY_TYPE, DuplicatorBlockEntity::tick);
    }
}
