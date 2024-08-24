package ru.waysoonprogramms.wallpapersmod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ru.waysoonprogramms.wallpapersmod.block.ModBlocks;
import ru.waysoonprogramms.wallpapersmod.block.entity.ModBlockEntities;
import ru.waysoonprogramms.wallpapersmod.item.ModItems;


@Mod(Wallpapersmod.MODID)
public class Wallpapersmod {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    
    public static final String MODID = "wallpapersmod";

    public Wallpapersmod() {
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
        modEventBus.addListener(this::addToCreativeTab);
    }
    
    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(ModBlocks.WHITE_WALLPAPER);
        }
    }
}
