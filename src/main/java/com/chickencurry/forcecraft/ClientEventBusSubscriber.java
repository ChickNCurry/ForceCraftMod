package com.chickencurry.forcecraft;

import com.chickencurry.forcecraft.entity.WookieEntity;
import com.chickencurry.forcecraft.entity.render.BlasterBoltRenderer;
import com.chickencurry.forcecraft.entity.render.DroidEntityRenderer;
import com.chickencurry.forcecraft.entity.render.TrooperEntityRenderer;
import com.chickencurry.forcecraft.entity.render.WookieEntityRenderer;
import com.chickencurry.forcecraft.item.LightsaberItem;
import com.chickencurry.forcecraft.registry.EntityTypeRegistry;
import com.chickencurry.forcecraft.registry.ItemRegistry;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.BLASTER_BOLT_ENTITY.get(),
                BlasterBoltRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.DROID_ENTITY.get(),
                DroidEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.TROPPER_ENTITY.get(),
                TrooperEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.WOOKIE_ENTITY.get(),
                WookieEntityRenderer::new);
        event.enqueueWork(() -> registerPropertyOverride());
    }

    public static void registerPropertyOverride() {
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER_GREEN.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER_BLUE.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER_PURPLE.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER_RED.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER_YELLOW.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.DARKSABER.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
        ItemModelsProperties.registerProperty(
                ItemRegistry.LIGHTSABER.get(), new ResourceLocation(ForceCraft.MOD_ID,
                        LightsaberItem.STATE_PROPERTY), LightsaberItem::getLightsaberStateProperty);
    }

}
