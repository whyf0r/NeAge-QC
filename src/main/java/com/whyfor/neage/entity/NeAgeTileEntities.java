package com.whyfor.neage.entity;

import com.whyfor.neage.blocks.NeAgeBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class NeAgeTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "neage");

    public static final RegistryObject<BlockEntityType<DomenBlastFurnaceTileEntity>> DOMEN_BLAST_FURNACE_TILE_ENTITY =
            TILE_ENTITIES.register("domen_blast_furnace_tile_entity", () ->
                    BlockEntityType.Builder.of(DomenBlastFurnaceTileEntity::new, NeAgeBlocks.DOMEN_BLAST_FURNACE.get()).build(null));
}
