package com.chickencurry.forcecraft.entity.model;


import com.chickencurry.forcecraft.entity.DroidEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DroidEntityModel<T extends DroidEntity> extends EntityModel<T> {

	private final ModelRenderer wheels;
	private final ModelRenderer body;

	public DroidEntityModel() {
		textureWidth = 16;
		textureHeight = 16;

		wheels = new ModelRenderer(this);
		wheels.setRotationPoint(0.0F, 24.0F, 0.0F);
		wheels.setTextureOffset(0, 0).addBox(1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		wheels.setTextureOffset(0, 0).addBox(1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		wheels.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		wheels.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 2.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
								  float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
					   float green, float blue, float alpha){
		wheels.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}