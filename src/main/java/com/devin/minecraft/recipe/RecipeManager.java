package com.devin.minecraft.recipe;

import com.devin.minecraft.block.BlockManager;
import com.devin.minecraft.item.ItemManager;
import com.devin.minecraft.item.ItemKatana;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager
{
	public static void mainRegistry()
	{
		addCraftingRecipes();
		addSmeltingRecipes();
	}
	
	public static void addCraftingRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.katana), "a", "a", "b", 'a', ItemManager.tamahagane, 'b', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.shuriken, 4), " a ", "a a", " a ", 'a', ItemManager.tamahagane);
	}
	 
	public static void addSmeltingRecipes()
	{
		GameRegistry.addSmelting(new ItemStack(BlockManager.ironSand), new ItemStack(ItemManager.tamahagane), 0.3f);
	}
}
