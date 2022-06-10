package me.youded.neverhurtcam.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import me.youded.neverhurtcam.config.Config;

@Pseudo
@SuppressWarnings("UnresolvedMixinReference")
@Mixin(targets = "net.minecraft.client.renderer.EntityRenderer")
public class ForgeMixinOld {
    @ModifyConstant(method = "Lnet/minecraft/client/renderer/EntityRenderer;func_78482_e(F)V", constant = @Constant(floatValue = 14.0F))
    private float shakeValue(float original) {
        if (!Config.checked){
            Config.checkProperty();
        }
        return Config.hurtfloat;
    }
}