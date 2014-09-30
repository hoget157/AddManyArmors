package mods.enderarmors;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
 
@Mod(modid="enderArmor", name="enderArmor", version="1.0.0")
public class Main{
	public static final String modid ="enderarmor";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new ForgeEventClass());
		KeyBindingRegistry.registerKeyBinding(new MyKeyHandler());
		ItemEnderArmor.addItem();
		ItemEmeraldArmor.addItem();
		ItemWoodArmor.addItem();
		ItemNetherstarArmor.addItem();
		ItemStoneArmor.addItem();
		ItemGhastArmor.addItem();
		ItemFeatherArmor.addItem();
	}
 
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ItemEnderArmor.addInstance();
		ItemEmeraldArmor.addInstance();
		ItemWoodArmor.addInstance();
		ItemNetherstarArmor.addInstance();
		ItemStoneArmor.addInstance();
		ItemGhastArmor.addInstance();
		ItemFeatherArmor.addInstance();
	}
	static
	{
		ItemEnderArmor.setMaterial();
		ItemEmeraldArmor.setMaterial();
		ItemWoodArmor.setMaterial();
		ItemNetherstarArmor.setMaterial();
		ItemStoneArmor.setMaterial();
		ItemGhastArmor.setMaterial();
		ItemFeatherArmor.setMaterial();
	}

	
 
}