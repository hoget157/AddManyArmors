package mods.enderarmors;
 
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class ItemEmeraldArmor extends ItemArmor 
{
	public static Item emeraldHelmet;
	public static int emeraldHelmetID = 28528;
	public static Item emeraldChestplate;
	public static int emeraldChestplateID = 28529;
	public static Item emeraldLeggings;
	public static int emeraldLeggingsID = 28530;
	public static Item emeraldBoots;
	public static int emeraldBootsID = 28531;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemEmeraldArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
	         int par3, int par4,String type) {
	      super(par1, par2EnumArmorMaterial, par3, par4);
	      this.setTextureName(type,par4);
	   }
	    private void setTextureName(String type,int armorPart)
	     {
	       if(armorType == 0 || armorType == 1 || armorType == 3)
	        {
	        this.texturePath += type + "_layer_1.png";
	        }else{
	        this.texturePath += type + "_layer_2.png";
	       }
	      }
	    
	    public static void addItem(){

	    	LanguageRegistry.addName(emeraldHelmet, "Emerald Helmet");
	    	LanguageRegistry.instance().addNameForObject(emeraldHelmet, "ja_JP", "エメラルドのヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(emeraldHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Item.emerald});
	    	LanguageRegistry.addName(emeraldChestplate, "Emerald Chestplate");
	    	LanguageRegistry.instance().addNameForObject(emeraldChestplate, "ja_JP", "エメラルドのチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(emeraldChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Item.emerald});
	    	LanguageRegistry.addName(emeraldLeggings, "Emerald Leggings");
	    	LanguageRegistry.instance().addNameForObject(emeraldLeggings, "ja_JP", "エメラルドのレギンス");
	    	GameRegistry.addRecipe(new ItemStack(emeraldLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Item.emerald});
	    	LanguageRegistry.addName(emeraldBoots, "Emerald Boots");
	    	LanguageRegistry.instance().addNameForObject(emeraldBoots, "ja_JP", "エメラルドのブーツ");
	    	GameRegistry.addRecipe(new ItemStack(emeraldBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Item.emerald});
	    }
	    
	    public static void addInstance(){
	    	emeraldHelmet = new ItemEmeraldArmor(emeraldHelmetID, sampleArmorEnum, 0, 0, "emerald").setUnlocalizedName("emeraldHelmet").setTextureName("enderarmor:emerald_helmet");
			GameRegistry.registerItem(emeraldHelmet, "emeraldhelmet");
			emeraldChestplate = new ItemEmeraldArmor(emeraldChestplateID, sampleArmorEnum, 0, 1, "emerald").setUnlocalizedName("emeraldChestplate").setTextureName("enderarmor:emerald_chestplate");
			GameRegistry.registerItem(emeraldChestplate, "emeraldchestplate");
			emeraldLeggings = new ItemEmeraldArmor(emeraldLeggingsID, sampleArmorEnum, 0, 2, "emerald").setUnlocalizedName("emeraldLeggings").setTextureName("enderarmor:emerald_leggings");
			GameRegistry.registerItem(emeraldLeggings, "emeraldleggings");
			emeraldBoots = new ItemEmeraldArmor(emeraldBootsID, sampleArmorEnum, 0, 3, "emerald").setUnlocalizedName("emeraldBoots").setTextureName("enderarmor:emerald_boots");
			GameRegistry.registerItem(emeraldBoots, "emeraldboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("EMERALDARMOR",750, new int[]{3, 8, 6, 3}, 9);
	    }
	    
	   @SideOnly(Side.CLIENT)
	    public void registerIcon(IconRegister register)
	    {
	       this.itemIcon = register.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	    }
 
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	      {
	       return this.texturePath;
	      }
}