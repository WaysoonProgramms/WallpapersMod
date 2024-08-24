package ru.waysoonprogramms.wallpapersmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.waysoonprogramms.wallpapersmod.block.entity.WallpaperEntity;

public class Wallpaper extends BaseEntityBlock {
    public static final MapCodec<Wallpaper> CODEC = simpleCodec(Wallpaper::new);
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 1, 16, 16);

    public Wallpaper(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return SHAPE;
    }

    @NotNull
    public RenderShape getRenderShape( @NotNull BlockState pState) {
        return RenderShape.MODEL;
    }
    
    public BlockEntity newBlockEntity( @NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new WallpaperEntity(pPos, pState);
    }

    
}
