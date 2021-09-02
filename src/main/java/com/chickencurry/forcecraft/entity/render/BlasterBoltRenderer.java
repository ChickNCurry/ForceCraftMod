package com.chickencurry.forcecraft.entity.render;

import com.chickencurry.forcecraft.ForceCraft;
import com.chickencurry.forcecraft.registry.EntityTypeRegistry;
import com.chickencurry.forcecraft.entity.BlasterBoltEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BlasterBoltRenderer extends ArrowRenderer<BlasterBoltEntity> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ForceCraft.MOD_ID, "textures/entity/projectiles/blaster_bolt_red.png");

    public BlasterBoltRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getEntityTexture(BlasterBoltEntity entity) {
        return TEXTURE;
    }

}
