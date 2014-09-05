package com.devin.minecraft.entity;

import com.devin.minecraft.ModNinja;
import com.devin.minecraft.lib.StringLibrary;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager
{
	public static void mainRegistry()
	{
		registerEntities();
	}
	
	public static void registerEntities()
	{
		registerEntity(EntityNinja.class, "Ninja", 0x111111, 0x444444);
		registerEntity(EntityShuriken.class, "Shuriken");
		//registerEntity(EntityHotAirBalloon.class, "HotAirBalloon", 0xFF0000, 0x00FF00);
		
		spawnEverywhere(EntityNinja.class, 20, 1, 3, EnumCreatureType.creature);
	    spawnEverywhere(EntityNinja.class, 20, 1, 3, EnumCreatureType.monster);
	}
	
	private static void registerEntity(Class entityClass, String entityName)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
	    EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId);
	    EntityRegistry.registerModEntity(entityClass, entityName, entityId, StringLibrary.modId, 80, 3, true);
	}
	
	private static void registerEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
	    EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId, solidColor, spotColor);
	    EntityRegistry.registerModEntity(entityClass, entityName, entityId, StringLibrary.modId, 80, 3, true);
	}
	
	private static void spawnEverywhere(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature)
	{
		BiomeGenBase[] biomes = BiomeGenBase.getBiomeGenArray();
		for (int i = 0; i < biomes.length; i++)
		{
			if (biomes[i] != null)
			{
				EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes[i]);
			}
		}
	}
}
