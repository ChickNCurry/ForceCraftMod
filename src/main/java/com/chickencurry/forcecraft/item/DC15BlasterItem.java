package com.chickencurry.forcecraft.item;

import com.chickencurry.forcecraft.entity.BlasterBoltEntity;
import com.chickencurry.forcecraft.registry.ItemRegistry;
import com.chickencurry.forcecraft.registry.SoundEventRegistry;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class DC15BlasterItem extends BowItem {

    public DC15BlasterItem() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP));
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return stack -> {
            if(stack.getItem().equals(ItemRegistry.BLASTER_BOLT.get())) return true;
            return false;
        };
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity) entityLiving;
            boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = playerentity.findAmmo(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ItemRegistry.BLASTER_BOLT.get());
                }

                float f = 1.5f;
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    if (!worldIn.isRemote) {
                        BlasterBoltItem arrowitem = (BlasterBoltItem)(itemstack.getItem() instanceof BlasterBoltItem ? itemstack.getItem() : ItemRegistry.BLASTER_BOLT.get());
                        BlasterBoltEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
                        abstractarrowentity =  (BlasterBoltEntity) customArrow(abstractarrowentity);
                        abstractarrowentity.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractarrowentity.setIsCritical(true);
                        }

                        stack.damageItem(1, playerentity, (player) -> {
                            player.sendBreakAnimation(playerentity.getActiveHand());
                        });

                        worldIn.addEntity(abstractarrowentity);
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEventRegistry.BLASTER_BLAST.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

}
