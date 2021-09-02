package com.chickencurry.forcecraft.item;

import com.chickencurry.forcecraft.registry.DimensionRegistry;
import com.chickencurry.forcecraft.util.ModItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TeleporterItem extends Item {

    public TeleporterItem() {
        super(new Item.Properties().group(ModItemGroup.FORCECRAFT_GROUP));
    }

    /*
    @Override
    public ActionResult<ItemStack> onItemRightClick(World w, PlayerEntity p, Hand h) {
        if (p.canChangeDimension()) {
            RegistryKey<World> registrykey = w.getDimensionKey() == DimensionRegistry.TATOOINE_WORLD
                    ? World.OVERWORLD : DimensionRegistry.TATOOINE_WORLD;
            ServerWorld serverworld = w.getServer().getWorld(registrykey);
            if (serverworld != null) {
                p.changeDimension(serverworld, serverworld.getDefaultTeleporter());
                return ActionResult.resultSuccess(p.getHeldItem(h));
            }

        }
        return ActionResult.resultFail(p.getHeldItem(h));
    }
     */

}
