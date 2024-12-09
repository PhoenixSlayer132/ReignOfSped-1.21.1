package net.phoenixslayer132.reignofsped;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.block.ModBlockEntityTypes;
import net.phoenixslayer132.reignofsped.block.ModBlocks;
import net.phoenixslayer132.reignofsped.custom.stuff.GUI.TreasureChest.TreasureChestScreen;
import net.phoenixslayer132.reignofsped.custom.stuff.GUI.TreasureChest.TreasureChestScreenHandler;
import net.phoenixslayer132.reignofsped.item.ModItemGroups;
import net.phoenixslayer132.reignofsped.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReignOfSped implements ModInitializer {

    public static final String MOD_ID = "reignofsped";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ScreenHandlerType<TreasureChestScreenHandler> TREASURE_CHEST_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
            Identifier.of("reignofsped", "treasure_chest_block"), new ScreenHandlerType<>(TreasureChestScreenHandler::new, FeatureSet.empty()));


    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModBlockEntityTypes.registerModBlockEntityTypes();
        ModBlocks.registerModBlocks();

    }
}
