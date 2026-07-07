package net.mars.instantbreak_mt.client;

import net.mars.instantbreak_mt.InstantBreak;
import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class BreakDelayIndicator {
    private static final ResourceLocation BREAK_DELAY_ICON = ResourceLocation.fromNamespaceAndPath(InstantBreak.MOD_ID, "textures/hud/break_delay.png");

    public static void render(GuiGraphics graphics, DeltaTracker deltaTracker) {
        if (InstantBreakClient.breakDelayEnabled) {
            Minecraft client = Minecraft.getInstance();
            if (client != null) {
                Player playerEntity = client.player;
                if (playerEntity != null && !playerEntity.isSpectator() && !client.options.hideGui) {
                    HumanoidArm arm = playerEntity.getMainArm().getOpposite();
                    boolean ItemInOffHand = !playerEntity.getInventory().getItem(40).getItem().equals(Items.AIR);

                    int h = 0;
                    if (ItemInOffHand) {
                        h = 29;
                    }
                    int i = graphics.guiWidth() / 2;
                    int n = graphics.guiHeight() - 24;
                    int o = i - 91 - 32 - h;
                    if (arm == HumanoidArm.RIGHT) {
                        o = i + 91 + 6 + h;
                    }

                    graphics.blit(RenderPipelines.GUI_TEXTURED, BREAK_DELAY_ICON, o, n, 26, 22, 26, 22, 26, 22);
                }
            }
        }
    }
}