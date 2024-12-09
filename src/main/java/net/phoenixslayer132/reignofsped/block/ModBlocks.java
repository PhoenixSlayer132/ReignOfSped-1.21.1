package net.phoenixslayer132.reignofsped.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.block.custom.DuplicatorBlock;
import net.phoenixslayer132.reignofsped.block.custom.TreasureChestBlock;


public class ModBlocks {
    public static final Block RAW_PHOEN_BLOCK = registerBlock("raw_phoen_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block RAW_SUPERN_BLOCK = registerBlock("raw_supern_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block RAW_BLQ_BLOCK = registerBlock("raw_blq_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block RAW_DAR_BLOCK = registerBlock("raw_dar_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().luminance((state) -> 1)));


    public static final Block PHOEN_ORE = registerBlock("phoen_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().luminance((state) -> 3)
                            .allowsSpawning(((state, world, pos, type) -> type.isFireImmune()))
                            .postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final Block SUPERN_ORE = registerBlock("supern_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().luminance((state) -> 3)
                            .allowsSpawning((state, world, pos, entityType) -> entityType.isSpawnableFarFromPlayer())
                            .postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final Block BLQ_ORE = registerBlock("blq_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().luminance((state) -> 3)
                            .allowsSpawning((state, world, pos, entityType) -> entityType.isSpawnableFarFromPlayer())
                            .postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final Block DAR_ORE = registerBlock("dar_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().luminance((state) -> 3)
                            .allowsSpawning((state, world, pos, entityType) -> entityType.isSpawnableFarFromPlayer())
                            .postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final DuplicatorBlock DUPLICATOR_BLOCK = (DuplicatorBlock) ModBlocks.registerBlock("duplicator_block",
            new DuplicatorBlock(AbstractBlock.Settings.create().requiresTool().strength(4f)));

    public static final TreasureChestBlock TREASURE_CHEST_BLOCK = (TreasureChestBlock) ModBlocks.registerBlock("treasure_chest_block",
            new TreasureChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ReignOfSped.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ReignOfSped.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        ReignOfSped.LOGGER.info("Registering ModBlocks for " + ReignOfSped.MOD_ID);
    }
}
