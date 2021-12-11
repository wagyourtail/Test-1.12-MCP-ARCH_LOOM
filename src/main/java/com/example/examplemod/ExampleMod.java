package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "examplemod")
public class ExampleMod {

    public static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    private void commonSetup(final FMLPreInitializationEvent event) {
        LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
        LOGGER.info(String.format("Look, I found a %s!", Items.DIAMOND.getUnlocalizedName()));
    }

    @Mod.EventHandler
    private void clientSetup(final FMLPostInitializationEvent event) {
        LOGGER.info(String.format("Hey, we're on Minecraft version %s!", Minecraft.getMinecraft().getVersion()));
    }

    @SubscribeEvent
    public void kaboom(ExplosionEvent.Detonate event) {
        LOGGER.info(String.format("Kaboom! Something just blew up in %s!", event.getWorld()));
    }
}
