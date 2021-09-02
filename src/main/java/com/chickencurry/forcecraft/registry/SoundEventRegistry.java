package com.chickencurry.forcecraft.registry;

import com.chickencurry.forcecraft.ForceCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventRegistry {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ForceCraft.MOD_ID);

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    public static final RegistryObject<SoundEvent> LIGHTSABER_SWING =
            SOUND_EVENTS.register("lightsaber_swing",
            () -> new SoundEvent(new ResourceLocation(ForceCraft.MOD_ID, "lightsaber_swing")));

    public static final RegistryObject<SoundEvent> LIGHTSABER_IGNITION =
            SOUND_EVENTS.register("lightsaber_ignition",
            () -> new SoundEvent(new ResourceLocation(ForceCraft.MOD_ID, "lightsaber_ignition")));

    public static final RegistryObject<SoundEvent> BLASTER_BLAST =
            SOUND_EVENTS.register("blaster_blast",
            () -> new SoundEvent(new ResourceLocation(ForceCraft.MOD_ID, "blaster_blast")));

    public static final RegistryObject<SoundEvent> LIGHTSABER_EXTINGUISHMENT =
            SOUND_EVENTS.register("lightsaber_extinguishment",
            () -> new SoundEvent(new ResourceLocation(ForceCraft.MOD_ID, "lightsaber_extinguishment")));

}
