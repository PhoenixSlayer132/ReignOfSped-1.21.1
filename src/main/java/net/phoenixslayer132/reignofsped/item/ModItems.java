package net.phoenixslayer132.reignofsped.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.phoenixslayer132.reignofsped.ReignOfSped;

import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_PHOEN = registerItem("raw_phoen",
            new Item(new Item.Settings()));
    public static final Item RAW_SUPERN = registerItem("raw_supern",
            new Item(new Item.Settings()));
    public static final Item RAW_BLQ = registerItem("raw_blq",
            new Item(new Item.Settings()));
    public static final Item RAW_DAR = registerItem("raw_dar",
            new Item(new Item.Settings()));


    public static final Item PHOEN_INGOT = registerItem("phoen_ingot",
            new Item(new Item.Settings()));
    public static final Item SUPERN_INGOT = registerItem("supern_ingot",
            new Item(new Item.Settings()));
    public static final Item BLQ_INGOT = registerItem("blq_ingot",
            new Item(new Item.Settings()));
    public static final Item DAR_INGOT = registerItem("dar_ingot",
            new Item(new Item.Settings()));

    public static Item registerItem (String name, Item item){
    return Registry.register(Registries.ITEM, Identifier.of(ReignOfSped.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ReignOfSped.LOGGER.info("Registering Mod Items for " + ReignOfSped.MOD_ID);
    }
}
