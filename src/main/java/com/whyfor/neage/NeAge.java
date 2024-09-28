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

        // Регистрация событий для Forge и FML
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Регистрация предметов, блоков и т.д.
        NeAgeItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeBlocks.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeTileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        NeAgeMenuTypes.MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Слушатель загрузки конфигурации
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onConfigLoaded);

        // Регистрация событий Forge
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Код настройки мода
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Клиентские настройки (если требуются)
    }

    private void onConfigLoaded(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == NeAgeConfig.COMMON_CONFIG) {
            // Регистрация всех объектов в зависимости от конфигурации
            RegistrationHandler.registerAll();
        }

        }

    @Mod.EventBusSubscriber(modid = NeAge.MOD_ID)
    public static class ModEvents {
        @SubscribeEvent
        public static void onRegisterCommands(RegisterCommandsEvent event) {
            OpenMenuCommand.register(event.getDispatcher());
        }}


