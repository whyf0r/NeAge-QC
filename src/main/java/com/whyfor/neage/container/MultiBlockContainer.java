package com.whyfor.neage.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;

public class MultiBlockContainer extends Container {

    private final IWorldPosCallable canInteractWithCallable;

    public MultiBlockContainer(int id, PlayerEntity player) {
        super(MyModContainers.MULTIBLOCK_CONTAINER.get(), id);
        this.canInteractWithCallable = IWorldPosCallable.create(player.level, player.blockPosition());
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        // Проверяем, может ли игрок взаимодействовать с блоком
        return stillValid(this.canInteractWithCallable, player, MyModBlocks.MULTIBLOCK_CONTROLLER.get());
    }
}
