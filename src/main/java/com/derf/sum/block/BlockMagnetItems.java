package com.derf.sum.block;

import com.derf.sum.block.tileentity.TileEntityMagnetItems;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagnetItems extends BlockMagnet {

	public BlockMagnetItems() {
		super("magnet_item");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityMagnetItems();
	}

}
