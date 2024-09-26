package com.whyfor.neage.entity;

import com.whyfor.neage.blocks.NeAgeBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class MultiBlockTileEntity extends BlockEntity {

    public MultiBlockTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean isStructureValid(Level world, BlockPos pos) {
        // Проверка соседних блоков для правильной структуры
        BlockPos northPos = pos.north();
        BlockPos southPos = pos.south();
        BlockPos eastPos = pos.east();
        BlockPos westPos = pos.west();

        // Проверяем, что соседние блоки те, что нам нужны
        return world.getBlockState(northPos).getBlock() == NeAgeBlocks.MULTIBLOCK_PART.get()
                && world.getBlockState(southPos).getBlock() == NeAgeBlocks.MULTIBLOCK_PART.get()
                && world.getBlockState(eastPos).getBlock() == NeAgeBlocks.MULTIBLOCK_PART.get()
                && world.getBlockState(westPos).getBlock() == NeAgeBlocks.MULTIBLOCK_PART.get();
    }
}


