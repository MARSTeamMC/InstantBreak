package net.mars.instantbreak_mt.mixin;

import net.mars.instantbreak_mt.InstantBreakClient;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class MultiPlayerGameModeMixin {
    @Shadow
    private int destroyDelay;

    @Inject(method = "destroyBlock", at = @At("RETURN"))
    private void addDelay(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (InstantBreakClient.breakDelayEnabled) {
            this.destroyDelay = 5;
        }
    }
}
