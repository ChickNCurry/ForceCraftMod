package com.chickencurry.forcecraft.registry;

import com.chickencurry.forcecraft.ForceCraft;
import com.chickencurry.forcecraft.entity.DroidEntity;
import com.chickencurry.forcecraft.entity.TrooperEntity;
import com.chickencurry.forcecraft.entity.BlasterBoltEntity;
import com.chickencurry.forcecraft.entity.WookieEntity;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EntityTypeRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ForceCraft.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static final RegistryObject<EntityType<BlasterBoltEntity>> BLASTER_BOLT_ENTITY =
            ENTITY_TYPES.register("blaster_bolt_entity",
            () -> EntityType.Builder.<BlasterBoltEntity>create(BlasterBoltEntity::new,
            EntityClassification.MISC).size(1.0f, 1.0f)
            .build(new ResourceLocation(ForceCraft.MOD_ID, "blaster_bolt_entity").toString()));

    public static final RegistryObject<EntityType<TrooperEntity>> TROPPER_ENTITY =
            ENTITY_TYPES.register("trooper_entity",
            () -> EntityType.Builder.create(TrooperEntity::new,
            EntityClassification.MONSTER).size(1.0f, 1.0f)
            .build(new ResourceLocation(ForceCraft.MOD_ID, "trooper_entity").toString()));

    public static final RegistryObject<EntityType<DroidEntity>> DROID_ENTITY =
            ENTITY_TYPES.register("droid_entity",
            () -> EntityType.Builder.create(DroidEntity::new,
            EntityClassification.MONSTER).size(1.0f, 1.0f)
            .build(new ResourceLocation(ForceCraft.MOD_ID, "droid_entity").toString()));

    public static final RegistryObject<EntityType<WookieEntity>> WOOKIE_ENTITY =
            ENTITY_TYPES.register("wookie_entity",
            () -> EntityType.Builder.create(WookieEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f).build(new ResourceLocation(ForceCraft.MOD_ID,
                            "wookie_entity").toString()));

}
