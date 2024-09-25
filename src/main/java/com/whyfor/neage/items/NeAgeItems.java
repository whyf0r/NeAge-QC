package com.whyfor.neage.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.HashMap;
import java.util.Map;

import com.whyfor.neage.NeAge;

@Mod.EventBusSubscriber(modid = NeAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeAgeItems {
    // Список цветов для предметов
    public static final String[] COLORS = {
        "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
        "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
    };

    // DeferredRegister для предметов
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NeAge.MOD_ID);

    // Регистрация цветной пыли светокамня
    public static final Map<String, RegistryObject<Item>> COLORED_GLOWSTONE_DUST = new HashMap<>();


    static {
        for (String color : COLORS) {
            RegistryObject<Item> item = ITEMS.register(color + "_glowstone_dust",
                    () -> new Item(new Item.Properties()));
            COLORED_GLOWSTONE_DUST.put(color, item);
        
        }
    }
}