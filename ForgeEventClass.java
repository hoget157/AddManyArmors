package mods.enderarmors;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class ForgeEventClass {
	public static EntityPlayer player;
	public static InventoryPlayer invent;
	public static World world;
	
	@ForgeSubscribe
    public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
    		player = (EntityPlayer) event.entityLiving;
    		invent = player.inventory;
    		world = player.worldObj;
        	ItemEnderArmor.EnderTick();
        	ItemFeatherArmor.FeatherTick();
    	}

    }
	
}
