package com.derf.sum.block;

import com.derf.sum.block.tileentity.TileEntityDeath;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockDeath extends BlockContainer {
	
	public BlockDeath() {
		super(Material.ROCK);
		this.setUnlocalizedName("death");
		this.setHardness(2.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityDeath();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
}
