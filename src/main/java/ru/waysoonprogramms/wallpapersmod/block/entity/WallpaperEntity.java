package ru.waysoonprogramms.wallpapersmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WallpaperEntity extends BlockEntity {
    public WallpaperEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WALLPAPER_ENTITY.get(), pPos, pBlockState);
    }
}
