package com.whyfor.neage;

import com.whyfor.neage.command.OpenMenuCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NeAge.MOD_ID)
public class NeAgeEvents {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        OpenMenuCommand.register(event.getDispatcher());
    }
}
