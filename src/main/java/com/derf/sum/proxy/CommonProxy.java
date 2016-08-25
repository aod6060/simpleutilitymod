package com.derf.sum.proxy;

import com.derf.sum.block.BlockManager;
import com.derf.sum.block.tileentity.TileEntityMinner;
import com.derf.sum.creativetabs.CreativeTabsManager;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		BlockManager.create();
		BlockManager.register();
		BlockManager.registerTileEntities();
		
		CreativeTabsManager.create();
		
		BlockManager.creativeTabs();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		BlockManager.crafting();
		TileEntityMinner.registerMinedBlock(Blocks.COAL_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.IRON_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.LAPIS_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.DIAMOND_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.REDSTONE_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.GOLD_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.EMERALD_ORE);
		TileEntityMinner.registerMinedBlock(Blocks.QUARTZ_ORE);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
	}

}
