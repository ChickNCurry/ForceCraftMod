package com.chickencurry.forcecraft.entity;

import com.chickencurry.forcecraft.registry.ItemRegistry;
import com.chickencurry.forcecraft.registry.SoundEventRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TrooperEntity extends MonsterEntity implements IRangedAttackMob {

    public TrooperEntity(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this,
                PlayerEntity.class, true));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0f,
                30, 3.0f) {
            @Override
            public void resetTask() {
                super.resetTask();
                TrooperEntity.this.setAggroed(false);
            }
            @Override
            public void startExecuting() {
                super.startExecuting();
                TrooperEntity.this.setAggroed(true);
            }
        });
        this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 1.0f, 10.0f));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0d));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0f)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 1.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0f);
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
                                            @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        return spawnDataIn;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(ItemRegistry.TROOPER_HELMET.get()));
        this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(ItemRegistry.TROOPER_CHESTPLATE.get()));
        this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(ItemRegistry.TROOPER_LEGGINGS.get()));
        this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(ItemRegistry.TROOPER_BOOTS.get()));
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemRegistry.DC15_BLASTER.get()));
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        AbstractArrowEntity abstractarrowentity = new BlasterBoltEntity(this, this.world);
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        abstractarrowentity.shoot(d0, d1 + d3 * (double)0.2F, d2, 4.5F,
                (float)(14 - this.world.getDifficulty().getId() * 4));
        this.world.addEntity(abstractarrowentity);
        this.world.playSound(null, target.getPosX(), target.getPosY(), target.getPosZ(),
                SoundEventRegistry.BLASTER_BLAST.get(), SoundCategory.PLAYERS, 1.0F, 1.0F );
    }

}
