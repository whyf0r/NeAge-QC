package com.whyfor.neage;

import com.whyfor.neage.entity.NeAgeTileEntities;
import com.whyfor.neage.blocks.NeAgeBlocks;
import com.whyfor.neage.items.NeAgeItems;
import com.whyfor.neage.menus.NeAgeMenuTypes;
import com.whyfor.neage.command.OpenMenuCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(NeAge.MOD_ID)
public class NeAge {

    public static final String MOD_ID = "neage";

    // Конструктор мода
    @SuppressWarnings("removal")
    public NeAge() {
        // Регистрация файла конфигурации
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NeAgeConfig.COMMON_CONFIG);
        // Регистрация событий
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        // Регистрация предметов, блоков и т.д.
        NeAgeItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeTileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeMenuTypes.MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(this::onConfigLoad);
    }

    private void onConfigLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == NeAgeConfig.COMMON_CONFIG) {
            // Использование значений конфигурации
            if (NeAgeConfig.ENABLE_DOMEN_BLAST_FURNACE.get()) {
                NeAgeBlocks.registerDomenBlastFurnace();
            }
            if (NeAgeConfig.ENABLE_COMMAND_OPEN_MENU.get()) {
                MinecraftForge.EVENT_BUS.addListener(RegistrationHandler::onRegisterCommands);
            }
        }
    }
}



