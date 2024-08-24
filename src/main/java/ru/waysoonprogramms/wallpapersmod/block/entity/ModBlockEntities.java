package ru.waysoonprogramms.wallpapersmod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.waysoonprogramms.wallpapersmod.Wallpapersmod;
import ru.waysoonprogramms.wallpapersmod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Wallpapersmod.MODID);
    
    public static final RegistryObject<BlockEntityType<WallpaperEntity>> WALLPAPER_ENTITY =
            BLOCK_ENTITIES.register("wallpaper_entity", () ->
                    BlockEntityType.Builder.of(WallpaperEntity::new, ModBlocks.WHITE_WALLPAPER.get()).build(null));
    
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
