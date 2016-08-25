package com.derf.sum.block;

import com.derf.sum.block.tileentity.TileEntitySpawner;
import com.derf.sum.util.SpawnerType;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockSpawner extends BlockContainer {
	
	private SpawnerType spawnerType = null;
	
	public BlockSpawner(String name, SpawnerType type) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setHardness(2.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.spawnerType = type;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		TileEntitySpawner te = new TileEntitySpawner();
		te.setSpawnerType(spawnerType);
		return te;
	}

	public SpawnerType getSpawnerType() {
		return spawnerType;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
}
