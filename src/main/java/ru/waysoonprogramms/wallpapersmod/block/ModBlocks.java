package ru.waysoonprogramms.wallpapersmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.waysoonprogramms.wallpapersmod.Wallpapersmod;
import ru.waysoonprogramms.wallpapersmod.block.custom.Wallpaper;
import ru.waysoonprogramms.wallpapersmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Wallpapersmod.MODID);
    
    public static final RegistryObject<Block> WHITE_WALLPAPER = registerBlock("white_wallpaper",
            () -> new Wallpaper(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                    .noOcclusion()
                    .replaceable()));
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    private static <T extends Block> void registerBlockItem(String name, final RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
