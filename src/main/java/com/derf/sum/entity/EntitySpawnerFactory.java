package com.derf.sum.entity;

import java.util.Random;

import com.derf.sum.util.SpawnerType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;

public class EntitySpawnerFactory {
	private static EnumDyeColor[] colors = EnumDyeColor.values();
	private static Random rand = new Random();
	
	public static Entity create(SpawnerType type, World world) {
		Entity entity = null;
		
		
		switch(type) {
		case PIG:
			entity = new EntityPig(world);
			break;
		case COW:
			entity = new EntityCow(world);
			break;
		case CHICKEN:
			entity = new EntityChicken(world);
			break;
		case SHEEP:
			entity = new EntitySheep(world);
			((EntitySheep)entity).setFleeceColor(colors[rand.nextInt(colors.length)]);
			break;
		case MOOSHROOM:
			entity = new EntityMooshroom(world);
			break;
		case BAT:
			entity = new EntityBat(world);
			break;
		default:
			break;
		}
		
		return entity;
	}
	
	
}
