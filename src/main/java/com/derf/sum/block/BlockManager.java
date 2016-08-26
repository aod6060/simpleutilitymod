package com.derf.sum.block;

import com.derf.sum.SumRegistry;
import com.derf.sum.block.tileentity.TileEntityDeath;
import com.derf.sum.block.tileentity.TileEntityHealer;
import com.derf.sum.block.tileentity.TileEntityHunger;
import com.derf.sum.block.tileentity.TileEntityMagnetCreatures;
import com.derf.sum.block.tileentity.TileEntityMagnetItems;
import com.derf.sum.block.tileentity.TileEntityMinner;
import com.derf.sum.block.tileentity.TileEntityServoItems;
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
	public static Block death; // This kills any creature 
	// Magnets Block
	public static Block magnetItems; // This will draw an item in 
	public static Block magnetCreatures; // This will draw in an creature entity to it
	// Servo
	public static Block servoItems; // This will place items an adjacent inventory
	// Healer
	public static Block healer; // Heals the players health
	// Hunger
	public static Block hunger; // Heals the players hungar + saturation
	// Ore Spawner
	public static Block oreSpawner; // This will periodically spawn ore for you
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
		// Magnets
		magnetItems = new BlockMagnetItems();
		magnetCreatures = new BlockMagnetCreatures();
		// Servo
		servoItems = new BlockServoItems();
		// Health
		healer = new BlockHealer();
		// Hungar
		hunger = new BlockHunger();
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
		// Magnets
		SumRegistry.registerBlock(magnetItems, "magnet_items");
		SumRegistry.registerBlock(magnetCreatures, "magnet_creatures");
		// Servo
		SumRegistry.registerBlock(servoItems, "servo_items");
		// Healer
		SumRegistry.registerBlock(healer, "healer");
		// Hunger
		SumRegistry.registerBlock(hunger, "hunger");
	}
	
	public static void registerTileEntities() {
		// Minner
		SumRegistry.registerTileEntity(TileEntityMinner.class, "minner");
		// Spawner
		SumRegistry.registerTileEntity(TileEntitySpawner.class, "spawner");
		// Death
		SumRegistry.registerTileEntity(TileEntityDeath.class, "death");
		// Magnets
		SumRegistry.registerTileEntity(TileEntityMagnetItems.class, "magnet_items");
		SumRegistry.registerTileEntity(TileEntityMagnetCreatures.class, "magnet_creatures");
		// Servo
		SumRegistry.registerTileEntity(TileEntityServoItems.class, "servo_items");
		// Healer
		SumRegistry.registerTileEntity(TileEntityHealer.class, "healer");
		// Hunger
		SumRegistry.registerTileEntity(TileEntityHunger.class, "hunger");
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
		// Magnets
		magnetItems.setCreativeTab(CreativeTabsManager.tabsSUM);
		magnetCreatures.setCreativeTab(CreativeTabsManager.tabsSUM);
		// Servo
		servoItems.setCreativeTab(CreativeTabsManager.tabsSUM);
		// Healer
		healer.setCreativeTab(CreativeTabsManager.tabsSUM);
		// Hunger
		hunger.setCreativeTab(CreativeTabsManager.tabsSUM);
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
		// Magnets
		SumRegistry.registerRender(magnetItems, "magnet_items");
		SumRegistry.registerRender(magnetCreatures, "magnet_creatures");
		// Servo
		SumRegistry.registerRender(servoItems, "servo_items");
		// Healer
		SumRegistry.registerRender(healer, "healer");
		// Hunger
		SumRegistry.registerRender(hunger, "hunger");
	}
}
