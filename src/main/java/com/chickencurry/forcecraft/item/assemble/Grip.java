package com.chickencurry.forcecraft.item.assemble;

import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.item.Item;

public class Grip extends Item {
    public Grip() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP).maxStackSize(16));
    }
}
