package org.redfrog404.mods.magicalness;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class StaffEntropicDestruction extends Item {

	public StaffEntropicDestruction() {
		super();
		this.setUnlocalizedName("StaffEntropicDestruction");
		this.setCreativeTab(Main.MagicalnessTab);
		this.setMaxDamage(75);
		this.setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (stack.getItemDamage() == 75) {
			return stack;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntropicDestructionBullet(world,
					player));
		}

		stack.damageItem(1, player);
		return stack;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		IBlockState block = world.getBlockState(pos);

		if (block.getBlock() == Blocks.tnt) {
			if (world.isRemote) {
				return true;
			} else {
				world.setBlockState(pos, Blocks.air.getBlockState()
						.getBaseState());
				stack.setItemDamage(0);
				return true;
			}
		} else {
			return false;
		}
	}
}
