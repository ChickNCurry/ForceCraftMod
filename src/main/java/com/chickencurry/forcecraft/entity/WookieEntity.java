package com.chickencurry.forcecraft.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class WookieEntity extends CreatureEntity {

    public WookieEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
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

}
