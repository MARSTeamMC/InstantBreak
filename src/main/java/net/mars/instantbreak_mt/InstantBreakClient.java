package net.mars.instantbreak_mt;

import net.mars.instantbreak_mt.client.BreakDelayIndicator;
import net.mars.instantbreak_mt.event.KeyMappingsRegistry;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@Mod(value = InstantBreak.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = InstantBreak.MOD_ID, value = Dist.CLIENT)
public class InstantBreakClient {
    public InstantBreakClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    public static boolean breakDelayEnabled = false;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(KeyMappingsRegistry.breakDelayKey);
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.CHAT, Identifier.fromNamespaceAndPath(InstantBreak.MOD_ID,
                "break_delay"), BreakDelayIndicator::render);
    }
}
