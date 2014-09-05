package com.devin.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityShuriken extends EntityThrowable
{
	public EntityShuriken(World par1World)
    {
        super(par1World);
    }

	public EntityShuriken(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}
	
	public EntityShuriken(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

	@Override
	protected void onImpact(MovingObjectPosition var1)
	{
		if (var1.entityHit != null)
        {
			float damage = 5;
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        }
		
		for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}

}
