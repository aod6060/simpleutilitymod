package com.derf.sum.block.tileentity;

import java.util.List;

import com.derf.sum.util.Vec3;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class TileEntityMagnet extends TileEntity implements ITickable {
	protected int size = 64;
	protected int halfSize = size / 2;
	protected double strength = 0.5;
	
	@Override
	public void update() {
		
		if(!worldObj.isRemote) {
			onUpdate();
		}
	}
	
	// Abstract Methods
	
	protected abstract void onUpdate();
	
	protected void handleMagnet(Class<? extends Entity> clz) {
		Vec3 location = new Vec3(this.pos);
		AxisAlignedBB box = this.createAABB(this.pos);
		List<Entity> list = this.getEntitiesWithAABB(worldObj, clz, box);
		for(Entity e : list) {
			Vec3 ev = new Vec3(e.posX, e.posY, e.posZ);
			Vec3 s = Vec3.sub(location, ev);
			s = Vec3.unit(s);
			s = Vec3.mul(s, this.strength);
			//e.moveEntity(s.getX(), s.getY(), s.getZ());
			e.motionX += s.getX();
			e.motionY += s.getY();
			e.motionZ += s.getZ();
		}
	}
	
	protected AxisAlignedBB createAABB(BlockPos pos) {
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
	
	protected List<Entity> getEntitiesWithAABB(World world, Class<? extends Entity> clz, AxisAlignedBB box) {
		List<Entity> temp;
		temp = world.getEntitiesWithinAABB(clz, box);
		return temp;
	}
}
