package ru.waysoonprogramms.wallpapersmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.waysoonprogramms.wallpapersmod.block.entity.WallpaperEntity;

public class Wallpaper extends BaseEntityBlock {
    
    public static final MapCodec<Wallpaper> CODEC = simpleCodec(Wallpaper::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static VoxelShape EAST_AABB = Block.box(0, 0, 0, 1, 16, 16);
    public static VoxelShape WEST_AABB = Block.box(15, 0, 0, 16, 16, 16);
    public static VoxelShape SOUTH_AABB = Block.box(0, 0, 0, 16, 16, 1);
    public static VoxelShape NORTH_AABB = Block.box(0, 0, 15, 16, 16, 16);

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
        return switch (pState.getValue(FACING)) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            default -> EAST_AABB;
        };
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pPlacementContext) {
        try {
            return this.defaultBlockState()
                    .setValue(FACING, pPlacementContext.getClickedFace());
        } catch (Exception Ignored) {
            return this.defaultBlockState();
        }
    }

    @NotNull
    public RenderShape getRenderShape( @NotNull BlockState pState) {
        return RenderShape.MODEL;
    }
    
    public BlockEntity newBlockEntity( @NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new WallpaperEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
