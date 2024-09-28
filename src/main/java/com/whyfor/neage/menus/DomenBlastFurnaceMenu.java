package com.whyfor.neage.menus;

import com.whyfor.neage.blocks.NeAgeBlocks;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;


public class DomenBlastFurnaceMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerLevelAccess access;

    public DomenBlastFurnaceMenu(int id, Inventory inv, ContainerLevelAccess access) {
        super(NeAgeMenuTypes.DOMEN_BLAST_FURNACE.get(), id);
        this.container = inv; // Присваиваем контейнеру значение инвентаря
        this.access = access;

        // Левые слоты (для крафта)
        this.addSlot(new Slot(this.container, 0, 30, 17)); // Левый верхний слот
        this.addSlot(new Slot(this.container, 1, 30, 35)); // Средний слот
        this.addSlot(new Slot(this.container, 2, 30, 53)); // Нижний слот

        // Правые слоты (для крафта)
        this.addSlot(new Slot(this.container, 3, 90, 17)); // Правый верхний слот
        this.addSlot(new Slot(this.container, 4, 90, 35)); // Средний слот
        this.addSlot(new Slot(this.container, 5, 90, 53)); // Нижний слот

        // Слот для угля
        this.addSlot(new Slot(this.container, 6, 60, 71)); // Слот для угля

        // Добавляем инвентарь игрока (стандартные 36 слотов)
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
}
/*
    // Логика крафта: если уголь и железо, производим сталь
    public void slotsChanged(Container container) {
        // Логика проверки: если уголь в нижнем слоте и железо в верхних слотах, то произвести сталь
        if (this.canSmelt()) {
            this.smeltItem();
        }
    }

    private boolean canSmelt() {
        ItemStack coal = this.slots.get(6).getItem();  // Проверяем слот для угля
        ItemStack inputLeft = this.slots.get(0).getItem();  // Проверяем входные ресурсы
        ItemStack inputRight = this.slots.get(3).getItem();

        return !coal.isEmpty() && inputLeft.getItem() == Items.IRON_INGOT && inputRight.getItem() == Items.COAL;
    }

    private void smeltItem() {
        // Логика крафта: заменяем материалы на сталь и уменьшаем количество угля
        this.slots.get(0).shrink(1);  // Уменьшаем железо
        this.slots.get(3).shrink(1);  // Уменьшаем уголь
        this.slots.get(6).shrink(1);  // Уменьшаем уголь в нижнем слоте

        // Добавляем сталь в слот
        ItemStack output = new ItemStack(Items.IRON_INGOT, 1);  // Замените на сталь, когда будет добавлена
        this.slots.get(7).set(output);  // Предполагается, что у вас есть слот для результата
    }
}*/

