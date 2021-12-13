package com.example.examplemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "examplemod")
public class ExampleMod {

    public static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    private void commonSetup(final FMLPostInitializationEvent event) {
        LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
        LOGGER.info("Look, I found a {}!", Items.diamond.getUnlocalizedName());
    }

    @Mod.EventHandler
    private void clientSetup(final FMLInitializationEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", "1.7.10");
    }

    @SubscribeEvent
    public void kaboom(ExplosionEvent.Detonate event) {
        LOGGER.info("Kaboom! Something just blew up in {}!", event.world);
    }
}
