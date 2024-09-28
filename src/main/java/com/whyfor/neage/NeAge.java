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
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Уникальный идентификатор мода должен совпадать с modId в файле mods.toml
@Mod("neage")
public class NeAge {

    public static final String MOD_ID = "neage";

    // Конструктор мода
    @SuppressWarnings("removal")
    public NeAge() {

        // Регистрация событий для Forge
        MinecraftForge.EVENT_BUS.register(this);

        // Регистрация предметов, блоков и т.д.
        NeAgeItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeTileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeMenuTypes.MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Добавление слушателя событий
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Регистрация файла конфигурации
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NeAgeConfig.COMMON_CONFIG);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Проверка и регистрация доменной печи
        if (NeAgeConfig.ENABLE_DOMEN_BLAST_FURNACE.get()) {
            NeAgeBlocks.registerDomenBlastFurnace();
        }

        // Проверка и регистрация команды openmenu
        if (NeAgeConfig.ENABLE_COMMAND_OPEN_MENU.get()) {
            MinecraftForge.EVENT_BUS.addListener(this::registerCommands);
        }
    }

    // Метод для регистрации команды openmenu
    private void registerCommands(RegisterCommandsEvent event) {
        OpenMenuCommand.register(event.getDispatcher());
    }

    // События для сервера
    @Mod.EventBusSubscriber(modid = NeAge.MOD_ID)
    public static class ModEvents {

        @SubscribeEvent
        public static void onRegisterCommands(RegisterCommandsEvent event) {
            OpenMenuCommand.register(event.getDispatcher());
        }

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            // Другие настройки
        }
    }
}
