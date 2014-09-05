package com.devin.minecraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockManager
{
	public static Block ironSand;
	
	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
		
		GameRegistry.registerWorldGenerator(new BlockGenerator(ironSand, 60, 72, 8, 24, 50), 1);
	}
	 
	public static void initializeBlock()
	{
		ironSand = new BlockIronSand();
	}
	 
	public static void registerBlock()
	{
		GameRegistry.registerBlock(ironSand, ironSand.getUnlocalizedName());
	}
}
