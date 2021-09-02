package com.chickencurry.forcecraft.entity;

import com.chickencurry.forcecraft.registry.EntityTypeRegistry;
import com.chickencurry.forcecraft.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class BlasterBoltEntity extends AbstractArrowEntity {

    public BlasterBoltEntity(EntityType<? extends AbstractArrowEntity> type, World world) {
        super(type, world);
    }

    public BlasterBoltEntity(LivingEntity shooter, World world) {
        super(EntityTypeRegistry.BLASTER_BOLT_ENTITY.get(), shooter, world);
        this.setHitSound(null);
        this.setDamage(0.0f);
        pickupStatus = PickupStatus.DISALLOWED;
    }

    @Override
    public void setShooter(@Nullable Entity entity) {
        super.setShooter(entity);
        pickupStatus = PickupStatus.DISALLOWED;
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemRegistry.BLASTER_BOLT.get());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void setIsCritical(boolean bool) {
        super.setIsCritical(false);
    }

}
