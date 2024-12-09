package net.phoenixslayer132.reignofsped.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.custom.stuff.GUI.TreasureChest.TreasureChestScreen;

public class ReignOfSpedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ReignOfSped.TREASURE_CHEST_SCREEN_HANDLER, TreasureChestScreen::new);
    }
}
