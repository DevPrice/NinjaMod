package com.devin.minecraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BlockGenerator implements IWorldGenerator
{
	protected Block customBlock;
	protected int _minY;
	protected int _maxY;
	protected int _minVeinSize;
	protected int _maxVeinSize;
	protected int _chancesToSpawn;
	protected Block _replaced;

	public BlockGenerator(Block b, int minimumY, int maximumY, int minimumVeinSize, int maximumVeinSize, int spawnRate)
	{
		this(b, minimumY, maximumY, minimumVeinSize, maximumVeinSize, spawnRate, Blocks.stone);
	}
	
	public BlockGenerator(Block b, int minimumY, int maximumY, int minimumVeinSize, int maximumVeinSize, int spawnRate, Block replaced)
	{
		customBlock = b;
		_minY = minimumY;
		_maxY = maximumY;
		_minVeinSize = minimumVeinSize;
		_maxVeinSize = maximumVeinSize;
		_chancesToSpawn = spawnRate;
		_replaced = replaced;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOverworld(world, random, chunkX * 16, chunkZ * 16);
	}

	private void generateOverworld(World world, Random random, int x, int z)
	{
		assert _minVeinSize >= 0 : "The minimum vein size must be at least 0";
		assert _maxVeinSize >= _minVeinSize : "The maximum vein size must be greater than or equal to the minimum vein size";
		int maxX = 16; // minX is one, so setting this to 16 says all of the x
						// ranges can be used
		int maxZ = 16; // minY is one, so setting this to 16 says all of the y
						// ranges can be used
		int maxVeinSize = _minVeinSize + random.nextInt(_maxVeinSize - _minVeinSize);
		int chancesToSpawn = _chancesToSpawn; // How many times our ore can
												// spawn in one
		// chunk
		int minY = _minY; // how low the ore can spawn
		int maxY = _maxY; // how high the ore can spawn
		this.addOreSpawn(customBlock, world, random, x, z, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);
	}

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize, _replaced)).generate(world, random, posX, posY, posZ);
			// System.out.println("We just spawned a MY_BLOCK! [" + posX + ", " + posZ + "]");
		}
	}
}