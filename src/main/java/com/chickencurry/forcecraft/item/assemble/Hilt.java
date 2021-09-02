package com.chickencurry.forcecraft.item.assemble;

import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.item.Item;

public class Hilt extends Item {

    /*
    private Emitter emitter;
    private Switch switchModule;
    private Grip grip;
    private KyberCrystal kyberCrystal;
    private Electronics electronics;

    public Hilt(Emitter e, Switch s, Grip g, KyberCrystal c, Electronics el) {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP));
        emitter = e;
        switchModule = s;
        grip = g;
        kyberCrystal = c;
        electronics = el;
    }
     */

    public Hilt() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP).maxStackSize(16));
    }


}
