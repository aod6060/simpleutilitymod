package com.derf.sum;

import com.derf.sum.proxy.IProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Loader.MODID, name=Loader.NAME, version=Loader.VERSION)
public class Loader {
	public static final String MODID = "sum";
	public static final String NAME = "Simple Utility Mod";
	public static final String VERSION = "0.0.1";
	
	@Instance
	public static Loader instance = new Loader();
	
	@SidedProxy(clientSide="com.derf.sum.proxy.ClientProxy", serverSide="com.derf.sum.proxy.ServerProxy")
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
