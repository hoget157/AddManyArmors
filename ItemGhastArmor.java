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
 
public class ItemGhastArmor extends ItemArmor 
{
	public static Item ghastHelmet;
	public static int ghastHelmetID = 28544;
	public static Item ghastChestplate;
	public static int ghastChestplateID = 28545;
	public static Item ghastLeggings;
	public static int ghastLeggingsID = 28546;
	public static Item ghastBoots;
	public static int ghastBootsID = 28547;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemGhastArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(ghastHelmet, "Ghast Helmet");
	    	LanguageRegistry.instance().addNameForObject(ghastHelmet, "ja_JP", "ガストヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(ghastHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Item.ghastTear});
	    	LanguageRegistry.addName(ghastChestplate, "Ghast Chestplate");
	    	LanguageRegistry.instance().addNameForObject(ghastChestplate, "ja_JP", "ガストチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(ghastChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Item.ghastTear});
	    	LanguageRegistry.addName(ghastLeggings, "Ghast Leggings");
	    	LanguageRegistry.instance().addNameForObject(ghastLeggings, "ja_JP", "ガストレギンス");
	    	GameRegistry.addRecipe(new ItemStack(ghastLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Item.ghastTear});
	    	LanguageRegistry.addName(ghastBoots, "Ghast Boots");
	    	LanguageRegistry.instance().addNameForObject(ghastBoots, "ja_JP", "ガストブーツ");
	    	GameRegistry.addRecipe(new ItemStack(ghastBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Item.ghastTear});
	    }
	    
	    public static void addInstance(){
	    	ghastHelmet = new ItemGhastArmor(ghastHelmetID, sampleArmorEnum, 0, 0, "ghast").setUnlocalizedName("ghastHelmet").setTextureName("enderarmor:ghast_helmet");
			GameRegistry.registerItem(ghastHelmet, "ghasthelmet");
			ghastChestplate = new ItemGhastArmor(ghastChestplateID, sampleArmorEnum, 0, 1, "ghast").setUnlocalizedName("ghastChestplate").setTextureName("enderarmor:ghast_chestplate");
			GameRegistry.registerItem(ghastChestplate, "ghastchestplate");
			ghastLeggings = new ItemGhastArmor(ghastLeggingsID, sampleArmorEnum, 0, 2, "ghast").setUnlocalizedName("ghastLeggings").setTextureName("enderarmor:ghast_leggings");
			GameRegistry.registerItem(ghastLeggings, "ghastleggings");
			ghastBoots = new ItemGhastArmor(ghastBootsID, sampleArmorEnum, 0, 3, "ghast").setUnlocalizedName("ghastBoots").setTextureName("enderarmor:ghast_boots");
			GameRegistry.registerItem(ghastBoots, "ghastboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("GHASTARMOR",750, new int[]{3, 8, 6, 3}, 9);
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