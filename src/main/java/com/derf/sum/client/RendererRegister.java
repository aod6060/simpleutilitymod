package com.derf.sum.client;

import com.derf.sum.Loader;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class RendererRegister {
	
	public static void register(Block block, String name) {
		register(block, 0, name);
	}
	
	public static void register(Item item, String name) {
		register(item, 0, name);
	}
	
	public static void register(Block block, int meta, String name) {
		register(Item.getItemFromBlock(block), meta, name);
	}
	
	public static void register(Item item, int meta, String name) {
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
}
