package net.phoenixslayer132.reignofsped.block.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.block.ModBlockEntityTypes;
import net.phoenixslayer132.reignofsped.block.ModBlocks;

public class DuplicatorBlockEntity extends BlockEntity {
//
    public DuplicatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DUPLICATOR_BLOCK_ENTITY_TYPE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, DuplicatorBlockEntity blockEntity) {
        if (!world.isClient()){
            ServerTickEvents.START_SERVER_TICK.register(server -> {
                int rng = (int) (Math.random() * (10000000 - 1 + 1)) + 1; //int between 1-10,000,000
                int rng2 = (int) (Math.random() * (10000000 - 1 + 1)) + 1; //int between 1-10,000,000
                int rng3 = (int) (Math.random() * (9 - 1 + 1)) + 1;//int between 1-8
                int rng4 = (int) (Math.random() * (9 - 1 + 1)) + 1;//int between 1-8

                BlockPos northWest = pos.north(1).offset(Direction.WEST, 1);//1    //        North
                BlockPos north = pos.north(1);//2                                     //      [1, 2, 3]
                BlockPos northEast = pos.north(1).offset(Direction.EAST, 1);//3    //  West [8, _, 4] East
                BlockPos east = pos.east(1);//4                                       //      [7, 6, 5]
                BlockPos southEast = pos.south(1).offset(Direction.EAST, 1);//5    //        South
                BlockPos south = pos.south(1);//6
                BlockPos southWest = pos.south(1).offset(Direction.WEST, 1);//7
                BlockPos west = pos.west(1);//8

                if (((rng3 <= 8) && (rng4 <= 8)) && (rng3 != rng4) && (rng >= 9990000 && rng2 >= 9990000)){
                    switch (rng3) {
                        case 1: {
                            checkBlock1(world, northWest, rng4, north, rng, rng2, northEast, east, southEast, south, southWest, west);
                            break;
                        }
                        case 2: {
                            checkBlock2(world, north, rng4, northWest, rng, rng2, northEast, east, southEast, south, southWest, west);
                            break;
                        }
                        case 3: {
                            checkBlock3(world, northEast, rng4, northWest, rng, rng2, north, east, southEast, south, southWest, west);
                            break;
                        }
                        case 4: {
                            checkBlock4(world, east, rng4, northWest, rng, rng2, north, northEast, southEast, south, southWest, west);
                            break;
                        }
                        case 5: {
                            checkBlock5(world, southEast, rng4, northWest, rng, rng2, north, northEast, east, south, southWest, west);
                            break;
                        }
                        case 6: {
                            checkBlock6(world, south, rng4, northWest, rng, rng2, north, northEast, east, southEast, southWest, west);
                            break;
                        }
                        case 7: {
                            checkBlock7(world, southWest, rng4, northWest, rng, rng2, north, northEast, east, southEast, south, west);
                            break;
                        }
                        case 8: {
                            checkBlock8(world, west, rng4, northWest, rng, rng2, north, northEast, east, southEast, south, southWest);
                            break;
                        }
                    }
                }


            });
        }
    }

    private static void checkBlock8(World world, BlockPos west, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos northEast, BlockPos east, BlockPos southEast, BlockPos south, BlockPos southWest) {
        BlockState blockState = world.getBlockState(west);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                //skip 8
            }
        }
    }

    private static void checkBlock7(World world, BlockPos southWest, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos northEast, BlockPos east, BlockPos southEast, BlockPos south, BlockPos west) {
        BlockState blockState = world.getBlockState(southWest);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                //skip 7
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock6(World world, BlockPos south, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos northEast, BlockPos east, BlockPos southEast, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(south);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                //skip 6
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock5(World world, BlockPos southEast, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos northEast, BlockPos east, BlockPos south, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(southEast);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                //skip 5
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock4(World world, BlockPos east, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos northEast, BlockPos southEast, BlockPos south, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(east);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                //skip 4
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock3(World world, BlockPos northEast, int rng4, BlockPos northWest, int rng, int rng2, BlockPos north, BlockPos east, BlockPos southEast, BlockPos south, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(northEast);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                //skip 3
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock2(World world, BlockPos north, int rng4, BlockPos northWest, int rng, int rng2, BlockPos northEast, BlockPos east, BlockPos southEast, BlockPos south, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(north);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                case 1: {
                    tryAddingBlock(world, northWest, rng, rng2, blockState);
                    break;
                }
                //skip 2
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void checkBlock1(World world, BlockPos northWest, int rng4, BlockPos north, int rng, int rng2, BlockPos northEast, BlockPos east, BlockPos southEast, BlockPos south, BlockPos southWest, BlockPos west) {
        BlockState blockState = world.getBlockState(northWest);
        if (!blockState.isAir() && !blockState.isOf(ModBlocks.DUPLICATOR_BLOCK)){
            switch (rng4){
                //skip 1
                case 2: {
                    tryAddingBlock(world, north, rng, rng2, blockState);
                    break;
                }
                case 3: {
                    tryAddingBlock(world, northEast, rng, rng2, blockState);
                    break;
                }
                case 4: {
                    tryAddingBlock(world, east, rng, rng2, blockState);
                    break;
                }
                case 5: {
                    tryAddingBlock(world, southEast, rng, rng2, blockState);
                    break;
                }
                case 6: {
                    tryAddingBlock(world, south, rng, rng2, blockState);
                    break;
                }
                case 7: {
                    tryAddingBlock(world, southWest, rng, rng2, blockState);
                    break;
                }
                case 8: {
                    tryAddingBlock(world, west, rng, rng2, blockState);
                    break;
                }
            }
        }
    }

    private static void tryAddingBlock(World world, BlockPos pos, int rng, int rng2, BlockState blockState) {
        BlockState blockState2 = world.getBlockState(pos);
        if (blockState2.isAir() && (rng == rng2)){
            world.setBlockState(pos, blockState);
        }
    }
}