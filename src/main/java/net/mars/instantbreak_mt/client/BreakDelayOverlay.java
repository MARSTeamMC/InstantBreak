package net.mars.instantbreak_mt.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mars.instantbreak_mt.InstantBreak;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;

public class BreakDelayOverlay implements HudRenderCallback {
    private static final Identifier BREAK_DELAY_ICON = new Identifier(InstantBreak.MOD_ID, "textures/hud/break_delay.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float v) {
        if (InstantBreakClient.breakDelayEnabled) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client != null) {
                PlayerEntity playerEntity = client.player;
                if (playerEntity != null && !playerEntity.isSpectator() && !client.options.hudHidden) {
                    Arm arm = playerEntity.getMainArm().getOpposite();
                    boolean ItemInOffHand = !playerEntity.getInventory().offHand.get(0).getItem().equals(Items.AIR);
                    int h = 0;
                    if (ItemInOffHand) {
                        h = 29;
                    }
                    int i = client.getWindow().getScaledWidth() / 2;
                    int n = client.getWindow().getScaledHeight() - 24;
                    int o = i - 91 - 32 - h;
                    if (arm == Arm.RIGHT) {
                        o = i + 91 + 6 + h;
                    }

                    RenderSystem.setShaderTexture(0, BREAK_DELAY_ICON);
                    DrawableHelper.drawTexture(matrixStack, o, n, 26, 22, 26, 22, 26, 22);
                }
            }
        }
    }
}
