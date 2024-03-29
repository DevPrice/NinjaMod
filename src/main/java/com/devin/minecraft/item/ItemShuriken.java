package com.devin.minecraft.item;

import com.devin.minecraft.entity.EntityShuriken;
import com.devin.minecraft.lib.StringLibrary;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShuriken extends Item
{
	public ItemShuriken()
	{
		this.setUnlocalizedName("Shuriken");
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(StringLibrary.modId + ":shuriken");
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			par1ItemStack.stackSize--;
		}

		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.8F + 0.4F));

		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityShuriken(par2World, par3EntityPlayer));
		}

		return par1ItemStack;
	}
}
