package com.derf.sum.util;

import net.minecraft.nbt.NBTTagCompound;

public class SimpleTimer {
	private int time;
	private int maxTime;
	
	public SimpleTimer() {
		this.maxTime = 1;
		this.time = this.maxTime;
	}
	
	public SimpleTimer(int maxTime) {
		this.maxTime = maxTime;
		this.time = maxTime;
	}
	
	public SimpleTimer(int time, int maxTime) {
		this.time = time;
		this.maxTime = maxTime;
	}
	
	public void reset() {
		this.time = this.maxTime;
	}
	
	public boolean isTimer() {
		return this.time <=  0;
	}
	
	public void update() {
		--this.time;
	}
	
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		this.time = compound.getInteger("time");
	}

	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger("time", this.time);
	}
	
	public static int toSeconds(int time) {
		return time * 20;
	}
}
