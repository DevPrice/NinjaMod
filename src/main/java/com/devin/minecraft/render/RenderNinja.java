package com.devin.minecraft.render;

import com.devin.minecraft.lib.StringLibrary;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNinja extends RenderBiped
{

	public RenderNinja()
	{
		super(new ModelBiped(), 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1)
	{
		return new ResourceLocation(StringLibrary.modId + ":textures/entity/ninja.png");
	}

}
