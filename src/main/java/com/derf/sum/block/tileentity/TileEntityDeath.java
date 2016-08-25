package com.derf.sum.block.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityDeath extends TileEntity implements ITickable {

	protected int width = 7;
	protected int halfWidth = width / 2;
	protected int height = 7;
	protected int halfHeight = height / 2;
	protected int depth = 7;
	protected int halfDepth = depth / 2;
	protected int maxTime = 20;
	protected int time = maxTime;
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
		if(!worldObj.isRemote) {
			if(time <= 0) {
				AxisAlignedBB box = createAABB(this.pos);
				List<Entity> creatures = this.getEntitiesWithAABB(worldObj, EntityCreature.class, box);
				
				
				for(Entity entity : creatures) {
					entity.attackEntityFrom(DamageSource.generic, 2000.0f);
				}
				
				time = maxTime;
			} else {
				--time;
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.time = compound.getInteger("time");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger("time", this.time);
		return super.writeToNBT(compound);
	}
	
	private AxisAlignedBB createAABB(BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(
				pos.getX() - halfWidth,
				pos.getY() - halfHeight,
				pos.getZ() - halfDepth,
				pos.getX() + halfWidth,
				pos.getY() + halfHeight,
				pos.getZ() + halfDepth
		);
		return box;
	}
	
	private List<Entity> getEntitiesWithAABB(World world, Class<? extends Entity> clz, AxisAlignedBB box) {
		List<Entity> temp;
		temp = world.getEntitiesWithinAABB(clz, box);
		return temp;
	}
}
