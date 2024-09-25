package com.whyfor.neage;

import com.whyfor.neage.blocks.NeAgeBlocks;
import com.whyfor.neage.items.NeAgeItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = NeAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabEvents {
    
    // Список цветов для сортировки в порядке
    public static final String[] COLOR_ORDER = {
        "white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan",
        "light_blue", "blue", "purple", "magenta", "pink"
    };

    @SubscribeEvent
    public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        // Добавляем блок кремния во вкладку строительных блоков
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(new ItemStack(NeAgeBlocks.FLINT_BLOCK.get()));
        }
        // Добавляем цветную пыль светокамня в ингредиенты
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            for (String color : COLOR_ORDER) {
                RegistryObject<Item> item = NeAgeItems.COLORED_GLOWSTONE_DUST.get(color);
                if (item != null) {
                    event.accept(new ItemStack(item.get(), 1));
                }
            }
        }

        // Добавляем цветные блоки светокамня в цветные блоки
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            for (String color : COLOR_ORDER) {
                RegistryObject<Block> block = NeAgeBlocks.COLORED_GLOWSTONE_BLOCKS.get(color);
                if (block != null) {
                    event.accept(new ItemStack(block.get(), 1));
                }
            }
        }
    }
}




