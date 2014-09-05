package com.devin.minecraft.entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.devin.minecraft.entity.ai.EntityAIAttack;
import com.devin.minecraft.entity.ai.EntityAIStalk;
import com.devin.minecraft.item.ItemManager;

public class EntityNinja extends EntityMob implements IRangedAttackMob
{

	public EntityNinja(World par1World)
	{
		super(par1World);
		tasks.addTask(0, new EntityAIAttack(this));
		//tasks.addTask(0, new EntityAIArrowAttack(this, .5, 10, 10));
		tasks.addTask(1, new EntityAIStalk(this));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 32));
		tasks.addTask(3, new EntityAISwimming(this));
		//targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        //targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		this.setCurrentItemOrArmor(0, new ItemStack(ItemManager.katana));
	}

	public int getAttackStrength()
	{
		return 13;
	}

	protected boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1);
	}

	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public void dropFewItems(boolean recentlyHit, int lootLevel)
	{
		if (Math.random() < 0.2)
			this.dropItem(ItemManager.katana, 1);

		if (Math.random() < 0.5)
			this.dropItem(ItemManager.shuriken, (int) (Math.random() * 2 + 1));
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2)
	{
		EntityShuriken entityShuriken = new EntityShuriken(this.worldObj, this);

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityShuriken);
	}
}
