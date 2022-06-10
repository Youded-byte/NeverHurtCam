package me.youded.neverhurtcam.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import me.youded.neverhurtcam.config.Config;

@Pseudo
@SuppressWarnings("UnresolvedMixinReference")
@Mixin(targets = "net.minecraft.class_757")
public class FabricMixin {
    @ModifyConstant(method = "method_3198", constant = @Constant(floatValue = 14.0F))
    private float shakeValue(float original) {
        if (!Config.checked){
            Config.checkProperty();
        }
        return Config.hurtfloat;
    }
}