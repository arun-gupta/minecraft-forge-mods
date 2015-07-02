package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TNTBomber {

	Random random = new Random();

	@SubscribeEvent
	public void checkForTNTButton(PlayerInteractEvent event) {

		if (event.entityPlayer.getHeldItem() == null && 
				event.entityPlayer.getHeldItem().getItem() != Items.stick &&
				event.world.isRemote) {
			return;
		}

//		System.out.println("checkForTNTButton: " + MainMod.getTNTCount());
		for (int tnt = 0; tnt < MainMod.getTNTCount(); tnt++) {
			EntityTNTPrimed entityTnt = new EntityTNTPrimed(event.world);
			entityTnt.setLocationAndAngles(
					event.entityPlayer.posX + randomFloat(MainMod.getTNTSpreadX()), 
					event.entityPlayer.posY + randomFloat(MainMod.getTNTSpreadY()), 
					event.entityPlayer.posZ + randomFloat(MainMod.getTNTSpreadZ()),
					0,
					0);
			entityTnt.fuse = random.nextInt(21) + 70;
			event.world.spawnEntityInWorld(entityTnt);
		}
	}

	public float randomFloat(float max) {
		return (random.nextFloat() * max * 2) - max;
	}
}
