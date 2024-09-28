package com.whyfor.neage.blocks;

import com.whyfor.neage.entity.DomenBlastFurnaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.BlockHitResult;
import javax.annotation.Nullable;


// Класс блока для доменной печи
public class DomenBlastFurnaceBlock extends Block {

    public DomenBlastFurnaceBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MenuProvider) {
                MenuProvider menuProvider = (MenuProvider) blockEntity;
                player.openMenu(menuProvider);  // Открываем меню через встроенный метод Player
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DomenBlastFurnaceTileEntity(pos, state);
    }
}
