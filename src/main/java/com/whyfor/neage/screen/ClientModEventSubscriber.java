package com.whyfor.neage.screen;

import com.whyfor.neage.NeAge;
import com.whyfor.neage.menus.NeAgeMenuTypes;
import com.whyfor.neage.screen.DomenBlastFurnaceScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NeAge.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(NeAgeMenuTypes.DOMEN_BLAST_FURNACE.get(), DomenBlastFurnaceScreen::new);
    }
}