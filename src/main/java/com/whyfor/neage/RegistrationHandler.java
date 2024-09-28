package com.whyfor.neage;

import com.whyfor.neage.blocks.NeAgeBlocks;
import com.whyfor.neage.command.OpenMenuCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegistrationHandler {

    public static void registerAll() {
        // Проверка и регистрация доменной печи
        if (NeAgeConfig.ENABLE_DOMEN_BLAST_FURNACE.get()) {
            NeAgeBlocks.registerDomenBlastFurnace();
        }

        // Проверка и регистрация команды openmenu
        if (NeAgeConfig.ENABLE_COMMAND_OPEN_MENU.get()) {
            MinecraftForge.EVENT_BUS.addListener(RegistrationHandler::onRegisterCommands);
        }
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        OpenMenuCommand.register(event.getDispatcher());
    }
}