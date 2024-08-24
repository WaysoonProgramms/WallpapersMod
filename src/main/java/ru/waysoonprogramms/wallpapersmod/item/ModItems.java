package ru.waysoonprogramms.wallpapersmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.waysoonprogramms.wallpapersmod.Wallpapersmod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Wallpapersmod.MODID);
    
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
