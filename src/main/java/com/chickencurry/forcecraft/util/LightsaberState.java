package com.chickencurry.forcecraft.util;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IStringSerializable;

import java.util.Optional;

public enum LightsaberState implements IStringSerializable {

    OFF(0, "off"),
    ON(1, "on");

    private final byte nbt_id;
    private final String name;

    LightsaberState(int nbt_id, String name) {
        this.nbt_id = (byte) nbt_id;
        this.name = name;
    }

    private static Optional<LightsaberState> getStateFromID(byte id) {
        for (LightsaberState state : LightsaberState.values()) {
            if (state.nbt_id == id) return Optional.of(state);
        }
        return Optional.empty();
    }

    @Override
    public String getString() { return this.name; }

    public float getPropertyOverrideValue() { return this.nbt_id; }

    public void putIntoNBT(CompoundNBT compoundNBT, String tagname) {
        compoundNBT.putByte(tagname, nbt_id);
    }

    public static LightsaberState fromNBT(CompoundNBT compoundNBT, String tagname) {
        byte id = 1;  // default in case of error
        if (compoundNBT != null && compoundNBT.contains(tagname)) {
            id = compoundNBT.getByte(tagname);
        }
        Optional<LightsaberState> state = getStateFromID(id);
        return state.orElse(ON);
    }

    public LightsaberState switchState() {
        if(this.nbt_id == 0) return ON;
        return OFF;
    }

}
