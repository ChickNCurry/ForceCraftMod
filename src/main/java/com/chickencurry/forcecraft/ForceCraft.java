package com.chickencurry.forcecraft;

import com.chickencurry.forcecraft.entity.DroidEntity;
import com.chickencurry.forcecraft.entity.TrooperEntity;
import com.chickencurry.forcecraft.entity.WookieEntity;
import com.chickencurry.forcecraft.registry.BlockRegistry;
import com.chickencurry.forcecraft.registry.EntityTypeRegistry;
import com.chickencurry.forcecraft.registry.SoundEventRegistry;
import com.chickencurry.forcecraft.registry.ItemRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ForceCraft.MOD_ID)
public class ForceCraft
{
    public static final String MOD_ID = "forcecraft";

    public ForceCraft() {

        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::onCommonSetup);

        EntityTypeRegistry.register(eventBus);
        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);
        SoundEventRegistry.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    public void onCommonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeRegistry.DROID_ENTITY.get(),
                    DroidEntity.setAttributes().create());
            GlobalEntityTypeAttributes.put(EntityTypeRegistry.TROPPER_ENTITY.get(),
                    TrooperEntity.setAttributes().create());
            GlobalEntityTypeAttributes.put(EntityTypeRegistry.WOOKIE_ENTITY.get(),
                    WookieEntity.setAttributes().create());
        });
    }

}
