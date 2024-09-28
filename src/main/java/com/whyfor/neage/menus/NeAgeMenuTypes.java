package com.whyfor.neage.menus;

import com.whyfor.neage.NeAge;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = NeAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeAgeMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NeAge.MOD_ID);

    public static final RegistryObject<MenuType<DomenBlastFurnaceMenu>> DOMEN_BLAST_FURNACE = MENUS.register("domen_blast_furnace",
            () -> IForgeMenuType.create((id, inv, data) -> new DomenBlastFurnaceMenu(id, inv, ContainerLevelAccess.create(inv.player.level(), inv.player.blockPosition()))));
}
