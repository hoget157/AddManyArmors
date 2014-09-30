package mods.enderarmors;
 
import net.minecraft.block.Block;
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
 
public class ItemWoodArmor extends ItemArmor 
{
	public static Item woodHelmet;
	public static int woodHelmetID = 28532;
	public static Item woodChestplate;
	public static int woodChestplateID = 28533;
	public static Item woodLeggings;
	public static int woodLeggingsID = 28534;
	public static Item woodBoots;
	public static int woodBootsID = 28535;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemWoodArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(woodHelmet, "Wood Helmet");
	    	LanguageRegistry.instance().addNameForObject(woodHelmet, "ja_JP", "木のヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(woodHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Block.planks});
	    	LanguageRegistry.addName(woodChestplate, "Wood Chestplate");
	    	LanguageRegistry.instance().addNameForObject(woodChestplate, "ja_JP", "木のチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(woodChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Block.planks});
	    	LanguageRegistry.addName(woodLeggings, "Wood Leggings");
	    	LanguageRegistry.instance().addNameForObject(woodLeggings, "ja_JP", "木のレギンス");
	    	GameRegistry.addRecipe(new ItemStack(woodLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Block.planks});
	    	LanguageRegistry.addName(woodBoots, "Wood Boots");
	    	LanguageRegistry.instance().addNameForObject(woodBoots, "ja_JP", "木のブーツ");
	    	GameRegistry.addRecipe(new ItemStack(woodBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Block.planks});
	    }
	    
	    public static void addInstance(){
	    	woodHelmet = new ItemWoodArmor(woodHelmetID, sampleArmorEnum, 0, 0, "wood").setUnlocalizedName("woodHelmet").setTextureName("enderarmor:wood_helmet");
			GameRegistry.registerItem(woodHelmet, "woodhelmet");
			woodChestplate = new ItemWoodArmor(woodChestplateID, sampleArmorEnum, 0, 1, "wood").setUnlocalizedName("woodChestplate").setTextureName("enderarmor:wood_chestplate");
			GameRegistry.registerItem(woodChestplate, "woodchestplate");
			woodLeggings = new ItemWoodArmor(woodLeggingsID, sampleArmorEnum, 0, 2, "wood").setUnlocalizedName("woodLeggings").setTextureName("enderarmor:wood_leggings");
			GameRegistry.registerItem(woodLeggings, "woodleggings");
			woodBoots = new ItemWoodArmor(woodBootsID, sampleArmorEnum, 0, 3, "wood").setUnlocalizedName("woodBoots").setTextureName("enderarmor:wood_boots");
			GameRegistry.registerItem(woodBoots, "woodboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("WOODARMOR",750, new int[]{3, 8, 6, 3}, 9);
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