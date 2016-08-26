package com.derf.sum.block.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityServoItems extends TileEntity implements ITickable {
	private int size = 7;
	private int halfSize = size / 2;
	
	@Override
	public void update() {
		
		
		if(!worldObj.isRemote) {
			
			TileEntity tileEntity = worldObj.getTileEntity(pos.add(0, 1, 0));
			
			if(tileEntity instanceof IInventory) {
				IInventory inventory = (IInventory)tileEntity;
				AxisAlignedBB box = createAABB(pos);
				
				List<Entity> el = this.getEntitiesWithAABB(worldObj, EntityItem.class, box);
				
				for(Entity e : el) {
					EntityItem item = (EntityItem)e;
					
					ItemStack stack = item.getEntityItem();
					
					if(addToInventory(inventory, stack)) {
						e.setDead();
					}
					
				}
				
				el.clear();
			}
		}
	}

	
	private boolean addToInventory(IInventory inventory, ItemStack stack) {
		boolean b = false;
		for(int i = 0; i < inventory.getSizeInventory(); i++) {
			if(inventory.getStackInSlot(i) == null) {
				inventory.setInventorySlotContents(i, stack.copy());
				b = true;
				break;
			}
			
			if(inventory.getStackInSlot(i).getItem() == stack.getItem() &&
			   inventory.getStackInSlot(i).stackSize < inventory.getInventoryStackLimit() &&
			   inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()) {
				int delta = inventory.getStackInSlot(i).getMaxStackSize() - inventory.getStackInSlot(i).stackSize;
				
				if(delta >= stack.stackSize) {
					inventory.getStackInSlot(i).stackSize += stack.stackSize;
					b = true;
					break;
				} else if(delta < stack.stackSize) {
					stack.stackSize -= delta;
					inventory.getStackInSlot(i).stackSize += delta;
					continue;
				}
			}
		}
		
		return b;
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
