package net.mars.instantbreak_mt.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_ENABLE_BREAK_DELAY = "key.enable_break_delay";

    public static KeyMapping breakDelayKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (breakDelayKey.consumeClick()) {
                InstantBreakClient.breakDelayEnabled = !InstantBreakClient.breakDelayEnabled;
                System.out.println(InstantBreakClient.breakDelayEnabled);
            }
        });
    }

    public static void register() {
        breakDelayKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                KEY_ENABLE_BREAK_DELAY,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KeyMapping.Category.GAMEPLAY
        ));

        registerKeyInputs();
    }
}
