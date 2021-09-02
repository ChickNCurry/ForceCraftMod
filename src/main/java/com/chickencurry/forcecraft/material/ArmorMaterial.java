package com.chickencurry.forcecraft.material;

import com.chickencurry.forcecraft.registry.ItemRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum ArmorMaterial implements IArmorMaterial {

    JEDI_ARMOR("jedi", 10, new int[]{4, 7, 9, 4}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, 0.2f,
            () -> Ingredient.fromItems(ItemRegistry.KYBER_CRYSTAL.get())),
    VADER_ARMOR("vader", 10, new int[]{4, 7, 9, 4}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, 0.2f,
            () -> Ingredient.fromItems(ItemRegistry.KYBER_CRYSTAL.get())),
    MANDO_ARMOR("mando", 10, new int[]{4, 7, 9, 4}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, 0.2f,
            () -> Ingredient.fromItems(ItemRegistry.KYBER_CRYSTAL.get())),
    TROOPER_ARMOR("trooper", 10, new int[]{4, 7, 9, 4}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, 0.2f,
            () -> Ingredient.fromItems(ItemRegistry.KYBER_CRYSTAL.get()));

    private static final int[] baseDurability = { 128, 144, 160, 112};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private Ingredient repairIngredient;

    ArmorMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability,
                  SoundEvent equipSound, float toughness, float knockbackResistance,
                  Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient.get();
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return this.baseDurability[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.armorVal[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
