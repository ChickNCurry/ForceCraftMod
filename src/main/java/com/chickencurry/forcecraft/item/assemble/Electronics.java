package com.chickencurry.forcecraft.item.assemble;

import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.item.Item;

public class Electronics extends Item {
    public Electronics() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP).maxStackSize(16));
    }
}