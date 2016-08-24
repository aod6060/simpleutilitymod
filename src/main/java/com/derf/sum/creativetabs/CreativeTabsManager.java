package com.derf.sum.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public final class CreativeTabsManager {
	public static CreativeTabs tabsSUM;
	
	public static void create() {
		tabsSUM = new CreativeTabs("tabSUM") {

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return Items.BEETROOT;
			}
			
		};
	}
}
