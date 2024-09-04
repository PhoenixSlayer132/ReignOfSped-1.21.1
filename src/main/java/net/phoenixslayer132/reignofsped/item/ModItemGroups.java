package net.phoenixslayer132.reignofsped.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;

public class ModItemGroups {
    public static final ItemGroup RIEGN_OF_SPED = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReignOfSped.MOD_ID, "reign_of_sped"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.reignofsped"))
                    .icon(() -> new ItemStack(ModItems.RAW_PHOEN)).entries((displayContext, entries) -> {
                        //Raw ores
                        entries.add(ModItems.RAW_PHOEN);
                        entries.add(ModItems.RAW_SUPERN);
                        entries.add(ModItems.RAW_BLQ);
                        entries.add(ModItems.RAW_DAR);


                        //Raw Blocks


                        //Ores


                        //Ingots
                        entries.add(ModItems.PHOEN_INGOT);
                        entries.add(ModItems.SUPERN_INGOT);
                        entries.add(ModItems.BLQ_INGOT);
                        entries.add(ModItems.DAR_INGOT);

                    }).build());


    public static void registerItemGroups() {
        ReignOfSped.LOGGER.info("Registering Item Groups for " + ReignOfSped.MOD_ID);
    }
}