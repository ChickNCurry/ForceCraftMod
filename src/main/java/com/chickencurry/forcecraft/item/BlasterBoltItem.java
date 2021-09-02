package com.chickencurry.forcecraft.item;

import com.chickencurry.forcecraft.entity.BlasterBoltEntity;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlasterBoltItem extends ArrowItem {

    private final float damage = 1.0f;

    public BlasterBoltItem() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP));
    }

    @Override
    public BlasterBoltEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        BlasterBoltEntity entity = new BlasterBoltEntity(shooter, world);
        entity.setDamage(damage);
        return entity;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, PlayerEntity player) {
        return true;
    }

}
