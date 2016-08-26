package com.derf.sum.block.tileentity;

import net.minecraft.entity.EntityCreature;

public class TileEntityMagnetCreatures extends TileEntityMagnet {

	@Override
	protected void onUpdate() {
		// TODO Auto-generated method stub
		this.handleMagnet(EntityCreature.class);
	}

}
