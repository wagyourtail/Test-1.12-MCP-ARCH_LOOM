package com.example.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class Test {

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onInit(GameConfiguration gameConfig, CallbackInfo ci) {
        System.out.println("HI FROM MIXIN");
    }
}
