package ru.waysoonprogramms.wallpapersmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Wallpapersmod.MODID)
public class Wallpapersmod {
    
    public static final String MODID = "wallpapersmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Wallpapersmod() {
        MinecraftForge.EVENT_BUS.register(this);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
}
