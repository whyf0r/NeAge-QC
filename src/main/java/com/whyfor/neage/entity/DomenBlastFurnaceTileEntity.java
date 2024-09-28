package com.whyfor.neage.entity;

import com.whyfor.neage.menus.DomenBlastFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;

public class DomenBlastFurnaceTileEntity extends BlockEntity implements MenuProvider {

    public DomenBlastFurnaceTileEntity(BlockPos pos, BlockState state) {
        super(NeAgeTileEntities.DOMEN_BLAST_FURNACE_TILE_ENTITY.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Domen Blast Furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return new DomenBlastFurnaceMenu(id, playerInventory, ContainerLevelAccess.create(this.level, this.worldPosition));
    }
}