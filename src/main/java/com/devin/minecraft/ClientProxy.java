package com.devin.minecraft;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

import com.devin.minecraft.entity.EntityShuriken;
import com.devin.minecraft.entity.EntityNinja;
import com.devin.minecraft.item.ItemManager;
import com.devin.minecraft.render.RenderNinja;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNinja.class, new RenderNinja());
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new RenderSnowball(ItemManager.shuriken));
	}
}
