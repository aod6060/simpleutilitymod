package com.derf.sum.block.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityMinner extends TileEntity implements ITickable {
	private static List<Block> blocks = new ArrayList<Block>();
	private int width;
	private int height;
	private float halfWidth;
	private float halfHeight;
	private int yoffset;
	private BlockPos outputLocation;
	private boolean done = false;
	private int fortune = 0;
	
	public TileEntityMinner() {
		super();
		this.width = 15;
		this.height = 15;
		this.halfWidth = width * 0.5f;
		this.halfHeight = height * 0.5f;
	}
	
	
	@Override
	public void setPos(BlockPos posIn) {
		// TODO Auto-generated method stub
		super.setPos(posIn);
		this.yoffset = pos.getY() - 1;
		outputLocation = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
	}


	@Override
	public void update() {
		// Does nothing for now
		
		if(!worldObj.isRemote) {
			if(yoffset <= 0) {
				done = true;
			}
			
			
			if(!done) {
				
				for(int z = 0; z < this.height; z++) {
					for(int x = 0; x < this.width; x++) {
						int nx = (int) ((x - halfWidth)) + pos.getX();
						int nz = (int) ((z - halfHeight)) + pos.getZ();
						this.destroyBlock(this.worldObj, new BlockPos(nx, this.yoffset, nz));
					}
				}
				--this.yoffset;
			}
		}
	}
	
	// statics for this class, I'll add other stuff for mining later
	public static void registerMinedBlock(Block block) {
		blocks.add(block);
	}
	
	public void destroyBlock(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		boolean isBreakable = false;
		
		for(Block b : blocks) {
			if(b == state.getBlock()) {
				isBreakable = true;
				break;
			}
		}
		
		if(isBreakable) {
			List<ItemStack> list = state.getBlock().getDrops(world, pos, state, this.fortune);
			
			for(ItemStack stack : list) {
				world.spawnEntityInWorld(new EntityItem(world, outputLocation.getX(), outputLocation.getY(), outputLocation.getZ(), stack));
			}
			
			world.setBlockToAir(pos);
		}
	}
}
