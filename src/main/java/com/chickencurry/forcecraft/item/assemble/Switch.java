package com.chickencurry.forcecraft.item.assemble;

import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.item.Item;

public class Switch extends Item {
    public Switch() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP).maxStackSize(16));
    }
}
