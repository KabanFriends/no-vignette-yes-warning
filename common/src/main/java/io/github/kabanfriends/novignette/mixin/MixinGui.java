package io.github.kabanfriends.novignette.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Gui.class)
public class MixinGui {

    @Inject(method = "renderVignette", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;disableDepthTest()V"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void novignette$cancelRenderVignette(GuiGraphics guiGraphics, Entity entity, CallbackInfo ci, float f) {
        if (f == 0.0F) {
            ci.cancel();
        }
    }
}
