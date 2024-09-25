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

    public static final Map<String, Integer> GLOWSTONE_LIGHT_LEVELS = new HashMap<>();

    // Регистрация блока кремня
    public static final RegistryObject<Block> FLINT_BLOCK = BLOCKS.register("flint_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.STONE))
    );

    // Регистрация предметов для блоков (включая блоки машин)
    public static final RegistryObject<Item> FLINT_BLOCK_ITEM = ITEMS.register("flint_block",
            () -> new BlockItem(FLINT_BLOCK.get(), new Item.Properties()));

    static {{
        GLOWSTONE_LIGHT_LEVELS.put("white", 15);
        GLOWSTONE_LIGHT_LEVELS.put("orange", 14);
        GLOWSTONE_LIGHT_LEVELS.put("magenta", 14);
        GLOWSTONE_LIGHT_LEVELS.put("light_blue", 13);
        GLOWSTONE_LIGHT_LEVELS.put("yellow", 15);
        GLOWSTONE_LIGHT_LEVELS.put("lime", 14);
        GLOWSTONE_LIGHT_LEVELS.put("pink", 13);
        GLOWSTONE_LIGHT_LEVELS.put("gray", 10);
        GLOWSTONE_LIGHT_LEVELS.put("light_gray", 14);
        GLOWSTONE_LIGHT_LEVELS.put("cyan", 10);
        GLOWSTONE_LIGHT_LEVELS.put("purple", 10);
        GLOWSTONE_LIGHT_LEVELS.put("blue", 8);
        GLOWSTONE_LIGHT_LEVELS.put("brown", 10);
        GLOWSTONE_LIGHT_LEVELS.put("green", 6);
        GLOWSTONE_LIGHT_LEVELS.put("red", 9);
        GLOWSTONE_LIGHT_LEVELS.put("black", 5);
    }

    // Регистрация блоков в цикле с различным уровнем свечения
    for(String color : COLORS)

    {
        int lightLevel = GLOWSTONE_LIGHT_LEVELS.getOrDefault(color, 15);  // Получаем уровень свечения для каждого цвета

        // Регистрация блока
        RegistryObject<Block> block = BLOCKS.register(color + "_glowstone_block",
                () -> new Block(BlockBehaviour.Properties.of().strength(0.3F).lightLevel((state) -> lightLevel).sound(SoundType.GLASS))
        );

        COLORED_GLOWSTONE_BLOCKS.put(color, block);

        // Регистрация BlockItem для этого блока
        ITEMS.register(color + "_glowstone_block", () -> new BlockItem(block.get(), new Item.Properties()));
    }
}

}