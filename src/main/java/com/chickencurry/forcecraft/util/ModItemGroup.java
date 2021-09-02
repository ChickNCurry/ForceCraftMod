package com.chickencurry.forcecraft.util;

import com.chickencurry.forcecraft.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup FORCECRAFT_GROUP = new ItemGroup("forcecraft_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.KYBER_CRYSTAL.get());
        }
    };

}
