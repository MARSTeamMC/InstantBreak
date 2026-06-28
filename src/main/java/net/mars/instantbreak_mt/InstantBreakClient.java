package net.mars.instantbreak_mt;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.mars.instantbreak_mt.client.BreakDelayIndicator;
import net.mars.instantbreak_mt.event.KeyInputHandler;
import net.minecraft.resources.Identifier;

public class InstantBreakClient implements ClientModInitializer {
    public static boolean breakDelayEnabled = false;

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(InstantBreak.MOD_ID,
                "break_delay"), BreakDelayIndicator::render);
    }
}
