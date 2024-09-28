package com.whyfor.neage;

import net.minecraftforge.common.ForgeConfigSpec;

public class NeAgeConfig {
    public static final ForgeConfigSpec COMMON_CONFIG;
    public static final ForgeConfigSpec.BooleanValue ENABLE_DOMEN_BLAST_FURNACE;
    public static final ForgeConfigSpec.BooleanValue ENABLE_COMMAND_OPEN_MENU;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Blocks");
        ENABLE_DOMEN_BLAST_FURNACE = builder
                .comment("Включить доменную печь?")
                .define("enableDomenBlastFurnace", false);
        builder.pop();

        builder.push("Commands");
        ENABLE_COMMAND_OPEN_MENU = builder
                .comment("Включить команду openmenu?")
                .define("enableOpenMenuCommand", false);
        builder.pop();

        COMMON_CONFIG = builder.build();
    }
}