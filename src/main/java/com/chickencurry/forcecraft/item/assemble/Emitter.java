package com.chickencurry.forcecraft.item.assemble;

import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.item.Item;

public class Emitter extends Item {
    public Emitter() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP).maxStackSize(16));
    }
}
