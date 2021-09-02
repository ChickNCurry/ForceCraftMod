package com.chickencurry.forcecraft.item;

import com.chickencurry.forcecraft.registry.SoundEventRegistry;
import com.chickencurry.forcecraft.material.ToolMaterial;
import com.chickencurry.forcecraft.util.LightsaberState;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class LightsaberItem extends SwordItem {

    public static final String STATE_PROPERTY = "lightsaber_state";

    public LightsaberItem() {
        super(ToolMaterial.LIGHTSABER,5, -1f,
                new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        LightsaberState state = getLightsaberState(stack);
        state = state.switchState();
        setLightsaberState(stack, state);
        if(state.equals(LightsaberState.ON)) {
            player.playSound(SoundEventRegistry.LIGHTSABER_IGNITION.get(), 1, 1);
        }
        else {
            player.playSound(SoundEventRegistry.LIGHTSABER_EXTINGUISHMENT.get(), 1, 1);
        }
        return new ActionResult<>(ActionResultType.PASS, stack);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if(getLightsaberState(stack).equals(LightsaberState.ON)) {
            entity.playSound(SoundEventRegistry.LIGHTSABER_SWING.get(), 1, 1);
        }
        return false;
    }

    public static LightsaberState getLightsaberState(ItemStack stack) {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        return LightsaberState.fromNBT(compoundNBT, STATE_PROPERTY);
    }

    public static void setLightsaberState(ItemStack stack, LightsaberState state)
    {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        state.putIntoNBT(compoundNBT, STATE_PROPERTY);
    }

    public static float getLightsaberStateProperty(ItemStack stack, @Nullable World w, @Nullable LivingEntity e)
    {
        LightsaberState state = getLightsaberState(stack);
        return state.getPropertyOverrideValue();
    }

}
