package com.chickencurry.forcecraft.registry;

import com.chickencurry.forcecraft.ForceCraft;
import com.chickencurry.forcecraft.item.*;
import com.chickencurry.forcecraft.item.assemble.*;
import com.chickencurry.forcecraft.material.ArmorMaterial;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, ForceCraft.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //items
    public static final RegistryObject<Item> KYBER_CRYSTAL = ITEMS.register(
            "kyber_crystal", KyberCrystal::new);
    public static final RegistryObject<Item> EMITTER = ITEMS.register(
            "my_lightsaber_emitter", Emitter::new);
    public static final RegistryObject<Item> SWITCH = ITEMS.register(
            "my_lightsaber_switch", Switch::new);
    public static final RegistryObject<Item> GRIP = ITEMS.register(
            "my_lightsaber_grip", Grip::new);
    public static final RegistryObject<Item> HILT = ITEMS.register(
            "my_lightsaber_off", Hilt::new);
    public static final RegistryObject<Item> ELECTRONICS = ITEMS.register(
            "electronics", Electronics::new);
    public static final RegistryObject<Item> TELEPORTER = ITEMS.register(
            "teleporter", TeleporterItem::new);
    public static final RegistryObject<Item> BLASTER_BOLT = ITEMS.register(
            "blaster_bolt", BlasterBoltItem::new);
    //public static final RegistryObject<Item> DROID_ENTITY_SPAWN_EGG = ItemRegistry.ITEMS.register(
    //        "droid_entity_spawn_egg", () -> new SpawnEggItem(
    //               EntityTypeRegistry.DROID_ENTITY.get(), 0x2f5882, 0x6f1499,
    //                new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));

    //tools
    public static final RegistryObject<Item> DC15_BLASTER = ITEMS.register(
            "dc15_blaster", DC15BlasterItem::new);
    public static final RegistryObject<Item> LIGHTSABER_GREEN = ITEMS.register(
            "lightsaber_green", LightsaberItem::new);
    public static final RegistryObject<Item> LIGHTSABER_RED = ITEMS.register(
            "lightsaber_red", LightsaberItem::new);
    public static final RegistryObject<Item> LIGHTSABER_BLUE = ITEMS.register(
            "lightsaber_blue", LightsaberItem::new);
    public static final RegistryObject<Item> LIGHTSABER_YELLOW = ITEMS.register(
            "lightsaber_yellow", LightsaberItem::new);
    public static final RegistryObject<Item> LIGHTSABER_PURPLE = ITEMS.register(
            "lightsaber_purple", LightsaberItem::new);
    public static final RegistryObject<Item> DARKSABER = ITEMS.register(
            "darksaber", LightsaberItem::new);
    public static final RegistryObject<Item> LIGHTSABER = ITEMS.register(
            "my_lightsaber", LightsaberItem::new);

    //armor
    public static final RegistryObject<Item> JEDI_HOOD = ITEMS.register("jedi_hood",
            () -> new ArmorItem(ArmorMaterial.JEDI_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> JEDI_ROBE = ITEMS.register("jedi_robe",
            () -> new ArmorItem(ArmorMaterial.JEDI_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> JEDI_PANTS = ITEMS.register("jedi_pants",
            () -> new ArmorItem(ArmorMaterial.JEDI_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> JEDI_BOOTS = ITEMS.register("jedi_boots",
            () -> new ArmorItem(ArmorMaterial.JEDI_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> VADER_HELMET = ITEMS.register("vader_helmet",
            () -> new ArmorItem(ArmorMaterial.VADER_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> VADER_CHESTPLATE = ITEMS.register("vader_chestplate",
            () -> new ArmorItem(ArmorMaterial.VADER_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> VADER_LEGGINGS = ITEMS.register("vader_leggings",
            () -> new ArmorItem(ArmorMaterial.VADER_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> VADER_BOOTS = ITEMS.register("vader_boots",
            () -> new ArmorItem(ArmorMaterial.VADER_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> MANDO_HELMET = ITEMS.register("mando_helmet",
            () -> new ArmorItem(ArmorMaterial.MANDO_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> MANDO_CHESTPLATE = ITEMS.register("mando_chestplate",
            () -> new ArmorItem(ArmorMaterial.MANDO_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> MANDO_LEGGINGS = ITEMS.register("mando_leggings",
            () -> new ArmorItem(ArmorMaterial.MANDO_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> MANDO_BOOTS = ITEMS.register("mando_boots",
            () -> new ArmorItem(ArmorMaterial.MANDO_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> TROOPER_HELMET = ITEMS.register("trooper_helmet",
            () -> new ArmorItem(ArmorMaterial.TROOPER_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> TROOPER_CHESTPLATE = ITEMS.register("trooper_chestplate",
            () -> new ArmorItem(ArmorMaterial.TROOPER_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> TROOPER_LEGGINGS = ITEMS.register("trooper_leggings",
            () -> new ArmorItem(ArmorMaterial.TROOPER_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));
    public static final RegistryObject<Item> TROOPER_BOOTS = ITEMS.register("trooper_boots",
            () -> new ArmorItem(ArmorMaterial.TROOPER_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP)));

}

