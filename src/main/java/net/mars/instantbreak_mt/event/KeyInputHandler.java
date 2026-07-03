package net.mars.instantbreak_mt.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.mars.instantbreak_mt.InstantBreak;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_ENABLE_BREAK_DELAY = "key.instantbreak_mt.enable_break_delay";

    public static KeyBinding breakDelayKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (breakDelayKey.wasPressed()) {
                InstantBreakClient.breakDelayEnabled = !InstantBreakClient.breakDelayEnabled;
            }
        });
    }

    public static void register() {
        KeyBinding.Category instantBreakCategory = KeyBinding.Category.create(Identifier.of(InstantBreak.MOD_ID, "instantbreak"));

        breakDelayKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ENABLE_BREAK_DELAY,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                instantBreakCategory
        ));

        registerKeyInputs();
    }
}
