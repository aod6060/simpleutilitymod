package com.derf.sum;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SumRegistry {
	
	public static void registerRender(Block block, String name) {
		registerRender(block, 0, name);
	}
	
	public static void registerRender(Item item, String name) {
		registerRender(item, 0, name);
	}
	
	public static void registerRender(Block block, int meta, String name) {
		registerRender(Item.getItemFromBlock(block), meta, name);
	}
	
	public static void registerRender(Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Loader.MODID + ":" + name, "inventory"));
	}
	
	public static void addVariants(Block block, String...args) {	
		addVariants(Item.getItemFromBlock(block), args);
	}
	
	public static void addVariants(Item item, String... args) {
		ResourceLocation[] rl = new ResourceLocation[args.length];
		
		for(int i = 0; i < rl.length; i++) {
			rl[i] = new ResourceLocation(Loader.MODID + ":" + args[i]);
		}
		
		if(rl.length > 0) {
			ModelBakery.registerItemVariants(item, rl);
		}
	}
	
	public static void registerBlock(Block block, String name) {
		registerBlock(block, new ItemBlock(block), name);
	}
	
	public static void registerBlock(Block block, ItemBlock item, String name) {
		if(block != null) {
			block.setRegistryName(name);
			GameRegistry.register(block);
			item.setRegistryName(name);
			GameRegistry.register(item);
		} else {
			throw new RuntimeException("SumRegistry.registerBlock, was passed a null block for "+name);
		}
	}
	
	public static void registerItem(Item item, String name) {
		if(item != null) {
			item.setRegistryName(name);
			GameRegistry.register(item);
		} else {
			throw new RuntimeException("SumRegistry.registerItem, was passed a null item for "+name);
		}
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> clz, String name) {
		GameRegistry.registerTileEntity(clz, name);
	}
	
	public static void registerWorldGenerator(IWorldGenerator generator, int weight) {
		GameRegistry.registerWorldGenerator(generator, weight);
	}
	
	public static void registerFuelHandler(IFuelHandler fuil) {
		GameRegistry.registerFuelHandler(fuil);
	}
	/*
	 * This is were recipes are  
	 */
	public static void addShapedCraftingRecipe(Block block, Object... args) {
		addShapedCraftingRecipe(Item.getItemFromBlock(block), args);
	}
	
	public static void addShapedCraftingRecipe(Item item, Object... args) {
		addShapedCraftingRecipe(new ItemStack(item, 1), args);
	}
	
	public static void addShapedCraftingRecipe(ItemStack stack, Object... args) {
		GameRegistry.addShapedRecipe(stack, args);
	}
	
	public static void addShapelessCraftingRecipe(Block block, Object... args) {
		addShapelessCraftingRecipe(Item.getItemFromBlock(block), args);
	}
	
	public static void addShapelessCraftingRecipe(Item item, Object... args) {
		addShapelessCraftingRecipe(new ItemStack(item, 1), args);
	}
	
	public static void addShapelessCraftingRecipe(ItemStack stack, Object... args) {
		GameRegistry.addShapedRecipe(stack, args);
	}
	
	public static void addSmeltingRecipe(Block block, ItemStack output, float xp) {
		addSmeltingRecipe(Item.getItemFromBlock(block), output, xp);
	}
	
	public static void addSmeltingRecipe(Item item, ItemStack output, float xp) {
		addSmeltingRecipe(new ItemStack(item, 1), output, xp);
	}
	
	public static void addSmeltingRecipe(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
}
