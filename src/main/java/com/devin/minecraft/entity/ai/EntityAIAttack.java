package com.devin.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIAttack extends EntityAIBase
{
	EntityMob attacker;
	EntityPlayer player;
	
	public EntityAIAttack(EntityMob n)
	{
		attacker = n;
		player = null;
	}

	@Override
	public boolean shouldExecute()
	{
		player = attacker.worldObj.getClosestVulnerablePlayerToEntity(attacker, 1.5);
		
		if (player != null)
		{
			return isFacingAway();
		}

		return false;
	}
	
	public void updateTask()
	{
		if (player == null)
			return;

		System.out.println("Attacking.");
		attacker.setAttackTarget(player);
        attacker.attackEntityAsMob(player);
	}
	
	public void resetTask()
    {
        player = null;
        attacker.setAttackTarget(null);
    }
	
	private boolean isFacingAway()
	{
		float facing = player.getRotationYawHead();
		
		if (facing < 0)
			facing += 360;
		
		facing *= Math.PI / 180; // convert to radians
		
		double angle = Math.atan2(attacker.posZ - player.posZ, attacker.posX - player.posX);
		
		if (angle < 0)
			angle += 2 * Math.PI;
		
		if (angle < facing)
			angle += Math.PI * 2;
		
		return Math.abs(angle - facing - Math.PI / 2) > Math.PI / 2;
	}

}
