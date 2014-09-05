package com.devin.minecraft.item;

import com.devin.minecraft.lib.StringLibrary;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTamahagane extends Item
{
	public ItemTamahagane()
	{
		this.setUnlocalizedName("Tamahagane");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(StringLibrary.modId + ":tamahagane");
	}
}
