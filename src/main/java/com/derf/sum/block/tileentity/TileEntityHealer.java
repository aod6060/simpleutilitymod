package com.derf.sum.block.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityHealer extends TileEntity implements ITickable {
	private int size = 3;
	private int halfSize = size / 2;
	
	@Override
	public void update() {
		if(!worldObj.isRemote) {
			AxisAlignedBB box = this.createAABB(pos.add(0, 2, 0));
			
			List<Entity> list = this.getEntitiesWithAABB(worldObj, EntityPlayer.class, box);
			
			
			for(Entity e : list) {
				EntityPlayer player = (EntityPlayer)e;
				
				float maxHealth = player.getMaxHealth();
				
				if(maxHealth > player.getHealth()) {
					float delta = 1.0f / maxHealth;
					player.setHealth(player.getHealth() + delta);
				}
			}
		}
	}

	private AxisAlignedBB createAABB(BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(
				pos.getX() - halfSize,
				pos.getY() - halfSize,
				pos.getZ() - halfSize,
				pos.getX() + halfSize,
				pos.getY() + halfSize,
				pos.getZ() + halfSize
		);
		return box;
	}
	
	private List<Entity> getEntitiesWithAABB(World world, Class<? extends Entity> clz, AxisAlignedBB box) {
		List<Entity> temp;
		temp = world.getEntitiesWithinAABB(clz, box);
		return temp;
	}
}
