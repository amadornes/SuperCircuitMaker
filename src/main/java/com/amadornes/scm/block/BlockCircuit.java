package com.amadornes.scm.block;

import com.amadornes.scm.tile.TileCircuit;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class BlockCircuit extends Block {

    public BlockCircuit() {
        super(Block.Properties.create(Material.CIRCUITS));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
        return new TileCircuit();
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.create(0, 0, 0, 1, 0.125, 1);
    }

    @Override // TODO: Come back to this later. Method names for this stuff are kind of ambiguous
    public boolean doesSideBlockRendering(IBlockState state, IWorldReader world, BlockPos pos, EnumFacing face) {
        if (face == EnumFacing.UP) return false;
        if (face == EnumFacing.DOWN) return true;
        return world.getBlockState(pos.offset(face)).getBlock() == this;
    }

}
