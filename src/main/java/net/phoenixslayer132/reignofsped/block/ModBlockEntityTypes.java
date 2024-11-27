package net.phoenixslayer132.reignofsped.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.block.custom.DuplicatorBlockEntity;
import net.phoenixslayer132.reignofsped.block.custom.TreasureChestBlock;
import net.phoenixslayer132.reignofsped.block.custom.TreasureChestBlockEntity;

public class ModBlockEntityTypes {
  public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("reignofsped", path), blockEntityType);
  }

  public static final BlockEntityType<DuplicatorBlockEntity> DUPLICATOR_BLOCK_ENTITY_TYPE = register(
      "duplicator_block",
      BlockEntityType.Builder.create(DuplicatorBlockEntity::new, ModBlocks.DUPLICATOR_BLOCK).build()
  );
  public static final BlockEntityType<TreasureChestBlockEntity> TREASURE_CHEST_BLOCK_ENTITY_TYPE = register(
          "treasure_chest_block",
          BlockEntityType.Builder.create(TreasureChestBlockEntity::new, ModBlocks.TREASURE_CHEST_BLOCK).build()
  );

  
  public static void registerModBlockEntityTypes() {
  }
}