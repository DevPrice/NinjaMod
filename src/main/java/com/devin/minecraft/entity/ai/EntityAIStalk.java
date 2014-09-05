package com.devin.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

import com.devin.minecraft.entity.EntityNinja;

public class EntityAIStalk extends EntityAIBase
{
	EntityMob stalker;
	EntityPlayer player;
	
	public EntityAIStalk(EntityMob n)
	{
		stalker = n;
		player = null;
	}

	@Override
	public boolean shouldExecute()
	{
		player = stalker.worldObj.getClosestVulnerablePlayerToEntity(stalker, 32.0);
		
		if (player != null)
		{
			return isFacingAway() || !player.canEntityBeSeen(stalker);
		}
		
		return false;
	}
	
	private boolean isFacingAway()
	{
		float facing = player.getRotationYawHead();
		
		if (facing < 0)
			facing += 360;
		
		facing *= Math.PI / 180; // convert to radians
		
		double angle = Math.atan2(stalker.posZ - player.posZ, stalker.posX - player.posX);
		
		if (angle < 0)
			angle += 2 * Math.PI;
		
		if (angle < facing)
			angle += Math.PI * 2;
		
		return Math.abs(angle - facing - Math.PI / 2) > Math.PI / 2;
	}
	
	public void updateTask()
	{
		if (player == null)
			return;
		
		stalker.getNavigator().tryMoveToEntityLiving(player, 1.6);//ninja.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
		
		if (stalker instanceof EntityNinja && Math.random() < .1)
		{
			EntityNinja ninja = (EntityNinja)stalker;
			
			if (player.getHealth() <= 5)
				ninja.attackEntityWithRangedAttack(player, 1);
		}
	}
	
	@Override
	public void startExecuting()
	{
		stalker.setSneaking(true);
	}
	
	public void resetTask()
    {
        player = null;
        stalker.getNavigator().clearPathEntity();
        stalker.setSneaking(false);
    }
	
}
