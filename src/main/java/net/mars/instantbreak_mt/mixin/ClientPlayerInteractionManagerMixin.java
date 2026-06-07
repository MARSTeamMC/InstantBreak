package net.mars.instantbreak_mt.mixin;

import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow
    private int blockBreakingCooldown;

    @Inject(method = "breakBlock", at = @At("RETURN"))
    private void addDelay(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (InstantBreakClient.breakDelayEnabled) {
            this.blockBreakingCooldown = 5;
        }
    }
}
