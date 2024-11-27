package net.phoenixslayer132.reignofsped.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.phoenixslayer132.reignofsped.ReignOfSped;

import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.item.custom.items.scrolls.*;

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

    public static final Item RESTORATION_SCROLL_ITEM = registerItem("restoration_scroll_item",
            new RestorationScrollItem(new Item.Settings().maxCount(8)));
    public static final Item STRENGTH_SCROLL_ITEM = registerItem("strength_scroll_item",
            new StrengthScrollItem(new Item.Settings().maxCount(8)));
    public static final Item REPAIR_SCROLL_ITEM = registerItem("repair_scroll_item",
            new RepairScrollItem(new Item.Settings().maxCount(8)));
    public static final Item ATTACK_SPEED_SCROLL_ITEM = registerItem("attack_speed_scroll_item",
            new AttackSpeedScrollItem(new Item.Settings().maxCount(8)));
    public static final Item DUPLICATION_SCROLL_ITEM = registerItem("duplication_scroll_item",
            new DuplicationScrollItem(new Item.Settings().maxCount(8)));
    public static final Item MOVEMENT_SPEED_SCROLL_ITEM = registerItem("movement_speed_scroll_item",
            new MovementSpeedScrollItem(new Item.Settings().maxCount(8)));

    public static Item registerItem (String name, Item item){
    return Registry.register(Registries.ITEM, Identifier.of(ReignOfSped.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ReignOfSped.LOGGER.info("Registering Mod Items for " + ReignOfSped.MOD_ID);
    }
}
