package com.whyfor.neage;

import com.whyfor.neage.blocks.NeAgeBlocks;
import com.whyfor.neage.container.MultiBlockContainer;
import com.whyfor.neage.items.NeAgeItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Уникальный идентификатор мода должен совпадать с modId в файле mods.toml
@Mod("neage")
public class NeAge{
    // Логгер для вывода сообщений в консоль
    public static final String MOD_ID = "neage";

    // Конструктор мода
    @SuppressWarnings("removal")

    public NeAge() {
          // Регистрируем предметы и блоки
          NeAgeItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
          NeAgeBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
          NeAgeBlocks.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    // Регистрируем событие для Forge
    MinecraftForge.EVENT_BUS.register(this);
    }
    public static final RegistryObject<ContainerType<MultiBlockContainer>> MULTIBLOCK_CONTAINER =
            CONTAINERS.register("multiblock_container",
                    () -> IForgeContainerType.create(MultiBlockContainer::new));

    // Пример события на сервере
    @Mod.EventBusSubscriber(modid = NeAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            // Здесь можно добавить сетевые пакеты или другие общие настройки
        }
    }
} 