package com.example.examplemod;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

public class MixinLoader implements IFMLLoadingPlugin {
    public static final Logger LOGGER  = LogManager.getLogger("JsMacros EarlyRiser");

    public MixinLoader() {
        connect();
    }

    public void connect() {
        MixinBootstrap.init();
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
        LOGGER.log(Level.INFO, "[ExampleMod] Loading Mixins.");
        Mixins.addConfiguration("example.mixins.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    public boolean hasClass(String cname) {
        try {
            Class.forName(cname);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}