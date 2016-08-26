package com.derf.sum.block.tileentity;

import java.util.Random;

import com.derf.sum.entity.EntitySpawnerFactory;
import com.derf.sum.util.SimpleTimer;
import com.derf.sum.util.SpawnerType;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntitySpawner extends TileEntity implements ITickable {

	protected int width = 5;
	protected int halfWidth = width / 2;
	protected int height = 5;
	protected int halfHeight = height / 2;
	protected Random rand = new Random();
	protected SpawnerType spawnerType;
	/*
	protected int maxTime = 20;
	protected int time = maxTime;
	*/
	protected SimpleTimer timer = new SimpleTimer(SimpleTimer.toSeconds(1));
			
	@Override
	public void update() {
		
		if(!worldObj.isRemote) {
			if(spawnerType != SpawnerType.SPAWNCAGE && spawnerType != null) {
				if(timer.isTimer()) {
					// Time to spawn the entity in a 
					int tx = rand.nextInt(width);
					int tz = rand.nextInt(height);
					
					double x = (tx - halfWidth) + pos.getX();
					double y = pos.getY() + 1;
					double z = (tz - halfHeight) + pos.getZ();
					
					
					Entity entity = EntitySpawnerFactory.create(this.spawnerType, worldObj);
					
					if(entity != null) {
						entity.setPosition(x, y, z);
						
						worldObj.spawnEntityInWorld(entity);
					}
					
					timer.reset();
				} else {
					timer.update();
				}
			}
		}
	}

	public SpawnerType getSpawnerType() {
		return spawnerType;
	}

	public void setSpawnerType(SpawnerType spawnerType) {
		this.spawnerType = spawnerType;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.spawnerType = SpawnerType.values()[compound.getInteger("spawner_type")];
		this.timer.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger("spawner_type", spawnerType.ordinal());
		this.timer.writeToNBT(compound);
		return super.writeToNBT(compound);
	}
	
	
}
