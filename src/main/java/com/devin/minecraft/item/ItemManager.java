package com.devin.minecraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemManager
{
	public static Item katana;
	public static Item shuriken;
	public static Item tamahagane;
	
	public static void mainRegistry()
	{
		EnumHelper.addToolMaterial("Tamahagane", 2, 2048, 4.0f, 3.0f, 14);
		
		initializeItems();
		registerItems();
	}
	 
	public static void initializeItems()
	{
		katana = new ItemKatana();
		shuriken = new ItemShuriken();
		tamahagane = new ItemTamahagane();
	}
	 
	public static void registerItems()
	{
		GameRegistry.registerItem(katana, katana.getUnlocalizedName());
		GameRegistry.registerItem(shuriken, shuriken.getUnlocalizedName());
		GameRegistry.registerItem(tamahagane, tamahagane.getUnlocalizedName());
	}
}
