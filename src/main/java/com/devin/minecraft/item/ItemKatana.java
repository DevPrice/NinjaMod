package com.devin.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import com.devin.minecraft.lib.StringLibrary;

public class ItemKatana extends ItemSword
{
	public ItemKatana()
	{
		super(ToolMaterial.valueOf("Tamahagane"));
		this.setUnlocalizedName("Katana");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
		this.setTextureName(StringLibrary.modId + ":katana");
	}
}
