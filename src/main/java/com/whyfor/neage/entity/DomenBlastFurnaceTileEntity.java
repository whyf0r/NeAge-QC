package com.whyfor.neage.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// TileEntity для доменной печи
public class DomenBlastFurnaceTileEntity extends BlockEntity implements MenuProvider, ITickableBlockEntity {

    // Поля для хранения инвентаря и прогресса
    private NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    private int craftingProgress = 0;
    private int craftingSpeed = 100; // Стандартная скорость крафта

    public DomenBlastFurnaceTileEntity(BlockPos pos, BlockState state) {
        super(ModTileEntities.DOMEN_BLAST_FURNACE_TILE_ENTITY.get(), pos, state);
    }

    @Override
    public void tick() {
        // Логика работы доменной печи на каждом тике
        if (!this.level.isClientSide) {
            ItemStack input = inventory.get(0);
            ItemStack fuel = inventory.get(1);

            if (!input.isEmpty() && !fuel.isEmpty()) {
                // Начало процесса крафта, если есть входные материалы
                if (craftingProgress < craftingSpeed) {
                    craftingProgress++;
                } else {
                    // Завершение крафта, получение результата
                    ItemStack result = getCraftingResult(input);
                    if (!result.isEmpty()) {
                        inventory.set(2, result);
                        craftingProgress = 0;
                    }
                }
            }
        }
    }

    private ItemStack getCraftingResult(ItemStack input) {
        // Определение результата крафта на основе входного предмета
        // Нужно будет настроить рецепты
        return new ItemStack(Items.IRON_INGOT); // Для примера
    }

    @Override
    public Component getDisplayName() {
        // Имя для GUI
        return new TextComponent("Domen Blast Furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        // Создание меню для взаимодействия
        return new DomenBlastFurnaceMenu(id, playerInventory, this);
    }

    public NonNullList<ItemStack> getInventory() {
        // Возвращает инвентарь для работы с трубами и воронками
        return this.inventory;
    }
}

