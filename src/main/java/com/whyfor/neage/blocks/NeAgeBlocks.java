package com.whyfor.neage.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.HashMap;
import java.util.Map;
import com.whyfor.neage.NeAge;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NeAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeAgeBlocks {
    // Список цветов
    public static final String[] COLORS = {
        "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
        "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
    };

    // DeferredRegister для блоков
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeAge.MOD_ID);

    // DeferredRegister для предметов
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NeAge.MOD_ID);
    
    // Карта для регистрации цветных блоков светокамня
    public static final Map<String, RegistryObject<Block>> COLORED_GLOWSTONE_BLOCKS = new HashMap<>();

    // Регистрация блока кремня
    public static final RegistryObject<Block> FLINT_BLOCK = BLOCKS.register("flint_block", 
        () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.STONE))
    );

    // Регистрация предметов для блоков (включая блоки машин)
    public static final RegistryObject<Item> FLINT_BLOCK_ITEM = ITEMS.register("flint_block", 
        () -> new BlockItem(FLINT_BLOCK.get(), new Item.Properties()));

    // Статический блок для инициализации цветных блоков светокамня
    static {
        for (String color : COLORS) {
            // Регистрация блока
            RegistryObject<Block> block = BLOCKS.register(color + "_glowstone_block",
                    () -> new Block(BlockBehaviour.Properties.of().strength(0.3F).lightLevel((state) -> 15).sound(SoundType.GLASS)));
            COLORED_GLOWSTONE_BLOCKS.put(color, block);
    
            // Регистрация BlockItem для этого блока
            ITEMS.register(color + "_glowstone_block", () -> new BlockItem(block.get(), new Item.Properties()));
        }
    }
}