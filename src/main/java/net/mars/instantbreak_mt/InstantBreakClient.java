package net.mars.instantbreak_mt;

import net.fabricmc.api.ClientModInitializer;
import net.mars.instantbreak_mt.client.BreakDelayOverlay;
import net.mars.instantbreak_mt.event.KeyInputHandler;

public class InstantBreakClient implements ClientModInitializer {
    public static boolean breakDelayEnabled = false;

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        BreakDelayOverlay.EVENT.register(new BreakDelayOverlay());
    }
}
