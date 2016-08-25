package com.derf.sum.block;

import com.derf.sum.SumRegistry;
import com.derf.sum.block.tileentity.TileEntityDeath;
import com.derf.sum.block.tileentity.TileEntityMinner;
import com.derf.sum.block.tileentity.TileEntitySpawner;
import com.derf.sum.creativetabs.CreativeTabsManager;
import com.derf.sum.util.SpawnerType;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class BlockManager {
	// Machine Block
	// Minner
	public static Block minner;
	// Spawner
	public static Block spawnCage;
	public static Block spawnCagePig;
	public static Block spawnCageCow;
	public static Block spawnCageChicken;
	public static Block spawnCageSheep;
	public static Block spawnCageBat;
	public static Block spawnCageMooshroom;
	// Death (This kills any entity within a 5x5x5 cube).
	public static Block death;
	// Magnets Block
	// Healer
	// Hunger
	// ChunkLoader
	public static void create() {
		// Minner
		minner = new BlockMinner();
		// Spawners
		spawnCage = new BlockSpawner("spawner", SpawnerType.SPAWNCAGE);
		spawnCagePig = new BlockSpawner("spawner_pig", SpawnerType.PIG);
		spawnCageCow = new BlockSpawner("spawner_cow", SpawnerType.COW);
		spawnCageChicken = new BlockSpawner("spawner_chicken", SpawnerType.CHICKEN);
		spawnCageSheep = new BlockSpawner("spawner_sheep", SpawnerType.SHEEP);
		spawnCageBat = new BlockSpawner("spawner_bat", SpawnerType.BAT);
		spawnCageMooshroom = new BlockSpawner("spawner_mooshroom", SpawnerType.MOOSHROOM);
		// Death
		death = new BlockDeath();
	}
	
	public static void register() {
		// Minner
		SumRegistry.registerBlock(minner, "minner");
		// Spawners
		SumRegistry.registerBlock(spawnCage, "spawner");
		SumRegistry.registerBlock(spawnCagePig, "spawner_pig");
		SumRegistry.registerBlock(spawnCageCow, "spawner_cow");
		SumRegistry.registerBlock(spawnCageChicken, "spawner_chicken");
		SumRegistry.registerBlock(spawnCageSheep, "spawner_sheep");
		SumRegistry.registerBlock(spawnCageBat, "spawner_bat");
		SumRegistry.registerBlock(spawnCageMooshroom, "spawner_mooshroom");
		// Death
		SumRegistry.registerBlock(death, "death");
	}
	
	public static void registerTileEntities() {
		SumRegistry.registerTileEntity(TileEntityMinner.class, "minner");
		SumRegistry.registerTileEntity(TileEntitySpawner.class, "spawner");
		SumRegistry.registerTileEntity(TileEntityDeath.class, "death");
	}
	
	public static void creativeTabs() {
		// Minner
		minner.setCreativeTab(CreativeTabsManager.tabsSUM);
		// Spawners
		spawnCage.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCagePig.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCageCow.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCageChicken.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCageSheep.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCageBat.setCreativeTab(CreativeTabsManager.tabsSUM);
		spawnCageMooshroom.setCreativeTab(CreativeTabsManager.tabsSUM);
		// Death
		death.setCreativeTab(CreativeTabsManager.tabsSUM);
	}
	
	public static void crafting() {
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerVarients() {
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderer() {
		// Minner
		SumRegistry.registerRender(minner, "minner");
		// Spawner
		SumRegistry.registerRender(spawnCage, "spawner");
		SumRegistry.registerRender(spawnCagePig, "spawner_pig");
		SumRegistry.registerRender(spawnCageCow, "spawner_cow");
		SumRegistry.registerRender(spawnCageChicken, "spawner_chicken");
		SumRegistry.registerRender(spawnCageSheep, "spawner_sheep");
		SumRegistry.registerRender(spawnCageBat, "spawner_bat");
		SumRegistry.registerRender(spawnCageMooshroom, "spawner_mooshroom");
		// Death
		SumRegistry.registerRender(death, "death");
	}
}
