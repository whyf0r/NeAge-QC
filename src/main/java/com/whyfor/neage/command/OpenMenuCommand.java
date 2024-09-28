package com.whyfor.neage.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ForgeRegistries;
import com.whyfor.neage.NeAgeConfig;

public class OpenMenuCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        if (NeAgeConfig.ENABLE_COMMAND_OPEN_MENU.get()) {
            dispatcher.register(Commands.literal("openmenu")
                    .then(Commands.argument("menu", ResourceLocationArgument.id())
                            .executes(context -> {
                                ServerPlayer player = context.getSource().getPlayerOrException();
                                ResourceLocation menuLocation = ResourceLocationArgument.getId(context, "menu");

                                MenuType<?> menuType = ForgeRegistries.MENU_TYPES.getValue(menuLocation);
                                if (menuType != null) {
                                    // Проверка, существует ли меню с таким идентификатором
                                    player.openMenu(new SimpleMenuProvider(
                                            (windowId, inv, playerEntity) -> menuType.create(windowId, inv),
                                            Component.literal("Menu: " + menuLocation)
                                    ));
                                    player.sendSystemMessage(Component.literal("Menu has open: " + menuLocation));
                                } else {
                                    player.sendSystemMessage(Component.literal("Menu doesn't exit: " + menuLocation));
                                }

                                return 1;
                            })));
        }
    }
}
