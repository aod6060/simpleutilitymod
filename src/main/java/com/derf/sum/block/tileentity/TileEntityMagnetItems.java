package com.derf.sum.block.tileentity;

import net.minecraft.entity.item.EntityItem;

public class TileEntityMagnetItems extends TileEntityMagnet {

	@Override
	protected void onUpdate() {
		// TODO Auto-generated method stub
		this.handleMagnet(EntityItem.class);
	}

}
