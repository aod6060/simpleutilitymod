package com.derf.sum.block;

import com.derf.sum.block.tileentity.TileEntityMagnetCreatures;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagnetCreatures extends BlockMagnet {

	public BlockMagnetCreatures() {
		super("magnet_creatures");
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityMagnetCreatures();
	}

}
