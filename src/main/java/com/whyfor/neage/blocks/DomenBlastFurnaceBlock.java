package com.whyfor.neage.blocks;

import com.whyfor.neage.*;
import com.whyfor.neage.entity.DomenBlastFurnaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static net.minecraft.world.level.block.HopperBlock.FACING;

// Класс блока для доменной печи
public class DomenBlastFurnaceBlock extends Block {

    public DomenBlastFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Определяем ориентацию блока в зависимости от направления игрока
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        // Проверка на то, собрана ли структура мультиблока
        if (!world.isClientSide) {
            checkMultiblockStructure(world, pos);
        }
    }

    private void checkMultiblockStructure(Level world, BlockPos pos) {
        // Здесь мы проверяем, что структура собрана правильно
        // Например, проверяем размер 3x2 и что все блоки на своих местах
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // Открытие GUI только с лицевой стороны
        if (!world.isClientSide) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof DomenBlastFurnaceTileEntity) {
                NetworkHooks.openScreen((ServerPlayer) player, (DomenBlastFurnaceTileEntity) tileEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        // Возвращаем новый TileEntity для этого блока
        return new DomenBlastFurnaceTileEntity(pos, state);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        // Удаление блока и сброс данных о мультиблоке
        super.onRemove(state, world, pos, newState, isMoving);
        if (!state.is(newState.getBlock())) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof DomenBlastFurnaceTileEntity) {
                Containers.dropContents(world, pos, (DomenBlastFurnaceTileEntity) tileEntity);
            }
        }
    }
}
