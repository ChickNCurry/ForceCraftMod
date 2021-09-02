package com.chickencurry.forcecraft.entity.render;

import com.chickencurry.forcecraft.ForceCraft;
import com.chickencurry.forcecraft.entity.TrooperEntity;
import com.chickencurry.forcecraft.entity.model.TrooperEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class TrooperEntityRenderer extends MobRenderer<TrooperEntity, TrooperEntityModel<TrooperEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ForceCraft.MOD_ID, "textures/entity/trooper.png");

    public TrooperEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TrooperEntityModel<>(), 0.7f);
        this.addLayer(new BipedArmorLayer<>(this,
                new BipedModel<>(0.5f), new BipedModel<>(1.0f)));
        this.addLayer(new HeldItemLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(TrooperEntity entity) {
        return TEXTURE;
    }

}
