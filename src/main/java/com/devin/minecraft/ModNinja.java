package com.devin.minecraft;

import net.minecraftforge.common.util.EnumHelper;

import com.devin.minecraft.block.BlockManager;
import com.devin.minecraft.entity.EntityManager;
import com.devin.minecraft.item.ItemManager;
import com.devin.minecraft.lib.StringLibrary;
import com.devin.minecraft.recipe.RecipeManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StringLibrary.modId, name = StringLibrary.modName, version = StringLibrary.modVersion)
public class ModNinja
{
	@SidedProxy(clientSide = "com.devin.minecraft.ClientProxy", serverSide = "com.devin.minecraft.ServerProxy")
	public static ClientProxy proxy;

	@EventHandler
	public static void Load(FMLInitializationEvent Event)
	{
		EntityManager.mainRegistry();
		ItemManager.mainRegistry();
		BlockManager.mainRegistry();
		RecipeManager.mainRegistry();
		proxy.registerRenderThings();
	}
}
