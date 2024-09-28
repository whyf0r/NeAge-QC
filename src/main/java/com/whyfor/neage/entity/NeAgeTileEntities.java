package com.whyfor.neage.entity;

import com.whyfor.neage.NeAgeConfig;
import com.whyfor.neage.blocks.NeAgeBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.whyfor.neage.NeAge;

public class NeAgeTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NeAge.MOD_ID);

    // Проверка включена ли доменная печь через конфигурацию
    public static final RegistryObject<BlockEntityType<DomenBlastFurnaceTileEntity>> DOMEN_BLAST_FURNACE_TILE_ENTITY;

    static {
        if (NeAgeConfig.ENABLE_DOMEN_BLAST_FURNACE.get()) {
            DOMEN_BLAST_FURNACE_TILE_ENTITY = TILE_ENTITIES.register("domen_blast_furnace_tile_entity",
                    () -> BlockEntityType.Builder.of(DomenBlastFurnaceTileEntity::new, NeAgeBlocks.DOMEN_BLAST_FURNACE.get()).build(null));
        } else {
            DOMEN_BLAST_FURNACE_TILE_ENTITY = null;
        }
    }
}

