package net.mars.instantbreak_mt.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.mars.instantbreak_mt.InstantBreak;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.lwjgl.glfw.GLFW;

public class KeyMappingsRegistry {
    public static final String KEY_ENABLE_BREAK_DELAY = "key.enable_break_delay";

    public static final KeyMapping breakDelayKey = new KeyMapping(
            KEY_ENABLE_BREAK_DELAY,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            KeyMapping.Category.GAMEPLAY
    );

    @EventBusSubscriber(modid = InstantBreak.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            if (breakDelayKey.consumeClick()) {
                InstantBreakClient.breakDelayEnabled = !InstantBreakClient.breakDelayEnabled;
            }
        }
    }
}