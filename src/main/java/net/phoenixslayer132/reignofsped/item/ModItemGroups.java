package net.phoenixslayer132.reignofsped.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RIEGNOFSPED = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReignOfSped.MOD_ID, "reignofsped"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.reignofsped"))
                    .icon(() -> new ItemStack(ModItems.RAW_PHOEN)).entries((displayContext, entries) -> {
                        //Raw ores
                        entries.add(ModItems.RAW_PHOEN);
                        entries.add(ModItems.RAW_SUPERN);
                        entries.add(ModItems.RAW_BLQ);
                        entries.add(ModItems.RAW_DAR);


                        //Raw Blocks
                        entries.add(ModBlocks.RAW_PHOEN_BLOCK);
                        entries.add(ModBlocks.RAW_SUPERN_BLOCK);
                        entries.add(ModBlocks.RAW_BLQ_BLOCK);
                        entries.add(ModBlocks.RAW_DAR_BLOCK);

                        //Ores
                        entries.add(ModBlocks.PHOEN_ORE);
                        entries.add(ModBlocks.SUPERN_ORE);
                        entries.add(ModBlocks.BLQ_ORE);
                        entries.add(ModBlocks.DAR_ORE);

                        //Ingots
                        entries.add(ModItems.PHOEN_INGOT);
                        entries.add(ModItems.SUPERN_INGOT);
                        entries.add(ModItems.BLQ_INGOT);
                        entries.add(ModItems.DAR_INGOT);

                        //Scrolls
                        entries.add(ModItems.RESTORATION_SCROLL_ITEM);
                        entries.add(ModItems.STRENGTH_SCROLL_ITEM);
                        entries.add(ModItems.REPAIR_SCROLL_ITEM);
                        entries.add(ModItems.ATTACK_SPEED_SCROLL_ITEM);
                        entries.add(ModItems.MOVEMENT_SPEED_SCROLL_ITEM);
                        entries.add(ModItems.DUPLICATION_SCROLL_ITEM);

                        //Custom Blocks
                        entries.add(ModBlocks.DUPLICATOR_BLOCK);

                    }).build());


    public static void registerItemGroups() {
        ReignOfSped.LOGGER.info("Registering Item Groups for " + ReignOfSped.MOD_ID);
    }
}