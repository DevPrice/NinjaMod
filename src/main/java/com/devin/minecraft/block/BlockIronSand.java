package com.devin.minecraft.block;

import com.devin.minecraft.lib.StringLibrary;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockIronSand extends Block
{
	public BlockIronSand()
	{
		super(Material.sand);
		
		this.setBlockName("IronSand");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(0.6f);
		this.setResistance(3.0f);
		this.setBlockTextureName(StringLibrary.modId + ":ironsand");
	}
}
