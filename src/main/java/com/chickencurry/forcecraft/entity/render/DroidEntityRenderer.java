package com.chickencurry.forcecraft.entity.render;

import com.chickencurry.forcecraft.ForceCraft;
import com.chickencurry.forcecraft.entity.DroidEntity;
import com.chickencurry.forcecraft.entity.model.DroidEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DroidEntityRenderer extends MobRenderer<DroidEntity, DroidEntityModel<DroidEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ForceCraft.MOD_ID, "textures/entity/droid.png");

    public DroidEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DroidEntityModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(DroidEntity entity) {
        return TEXTURE;
    }

}
