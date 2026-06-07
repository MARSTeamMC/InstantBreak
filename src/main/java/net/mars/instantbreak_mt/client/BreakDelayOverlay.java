package net.mars.instantbreak_mt.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mars.instantbreak_mt.InstantBreak;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;

public class BreakDelayOverlay implements HudRenderCallback {
    private static final Identifier BREAK_DELAY_ICON = Identifier.of(InstantBreak.MOD_ID, "textures/hud/break_delay.png");

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        if (InstantBreakClient.breakDelayEnabled) {
            PlayerEntity playerEntity = MinecraftClient.getInstance().player;
            if (playerEntity != null) {
                Arm arm = playerEntity.getMainArm().getOpposite();
                boolean ItemInOffHand = !playerEntity.getInventory().offHand.getFirst().getItem().equals(Items.AIR);
                int h = 0;
                if (ItemInOffHand) {
                    h = 29;
                }
                int i = drawContext.getScaledWindowWidth() / 2;
                int n = drawContext.getScaledWindowHeight() - 24;
                int o = i - 91 - 32 - h;
                if (arm == Arm.RIGHT) {
                    o = i + 91 + 6 + h;
                }

                drawContext.drawTexture(RenderLayer::getGuiTextured, BREAK_DELAY_ICON, o, n, 26, 22, 26, 22, 26, 22);
            }
        }
    }
}
