package com.derf.sum.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Vec3 {
	private double x;
	private double y;
	private double z;
	
	public Vec3() {
		this(0, 0, 0);
	}
	
	public Vec3(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec3(Vec3d v) {
		this(v.xCoord, v.yCoord, v.zCoord);
	}
	
	public Vec3(Vec3i v) {
		this(v.getX(), v.getY(), v.getZ());
	}
	
	public Vec3(BlockPos pos) {
		this(pos.getX(), pos.getY(), pos.getZ());
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vec3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	//-- Static Methods
	
	public static Vec3 add(Vec3 a, Vec3 b) {
		return new Vec3(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
	}
	
	public static Vec3 sub(Vec3 a, Vec3 b) {
		return new Vec3(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
	}
	
	public static Vec3 mul(Vec3 a, double b) {
		return new Vec3(a.getX() * b, a.getY() * b, a.getZ() * b);
	}
	
	public static Vec3 div(Vec3 a, double b) {
		return new Vec3(a.getX() / b, a.getY() / b, a.getZ() / b);
	}
	
	public static Vec3 negate(Vec3 a) {
		return new Vec3(-a.getX(), -a.getY(), -a.getZ());
	}
	
	public static Vec3 oneMinus(Vec3 a) {
		return new Vec3(1-a.getX(), 1-a.getY(), 1-a.getZ());
	}
	
	public static double length(Vec3 a) {
		return Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY() + a.getZ() * a.getZ());
	}
	
	public static double length2(Vec3 a) {
		return a.getX() * a.getX() + a.getY() * a.getY() + a.getZ() * a.getZ();
	}
	
	public static Vec3 unit(Vec3 a) {
		double l = length(a);
		return div(a, l);
	}
	
	public static double dot(Vec3 a, Vec3 b) {
		return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
	}
	
	public static double angle(Vec3 a, Vec3 b) {
		double al = length(a);
		double bl = length(b);
		double d = dot(a, b);
		return Math.acos(d / (al * bl));
	}
	
	public static Vec3 cross(Vec3 a, Vec3 b) {
		return new Vec3(
				a.getY() * b.getZ() - a.getZ() * b.getY(),
				a.getZ() * b.getX() - a.getX() * b.getZ(),
				a.getX() * b.getY() - a.getY() * b.getX()
		);
	}
}
