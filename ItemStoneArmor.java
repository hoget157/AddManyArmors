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
 
public class ItemStoneArmor extends ItemArmor 
{
	public static Item stoneHelmet;
	public static int stoneHelmetID = 28540;
	public static Item stoneChestplate;
	public static int stoneChestplateID = 28541;
	public static Item stoneLeggings;
	public static int stoneLeggingsID = 28542;
	public static Item stoneBoots;
	public static int stoneBootsID = 28543;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemStoneArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(stoneHelmet, "Stone Helmet");
	    	LanguageRegistry.instance().addNameForObject(stoneHelmet, "ja_JP", "石のヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(stoneHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Block.stone});
	    	LanguageRegistry.addName(stoneChestplate, "Stone Chestplate");
	    	LanguageRegistry.instance().addNameForObject(stoneChestplate, "ja_JP", "石のチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(stoneChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Block.stone});
	    	LanguageRegistry.addName(stoneLeggings, "Stone Leggings");
	    	LanguageRegistry.instance().addNameForObject(stoneLeggings, "ja_JP", "石のレギンス");
	    	GameRegistry.addRecipe(new ItemStack(stoneLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Block.stone});
	    	LanguageRegistry.addName(stoneBoots, "Stone Boots");
	    	LanguageRegistry.instance().addNameForObject(stoneBoots, "ja_JP", "石のブーツ");
	    	GameRegistry.addRecipe(new ItemStack(stoneBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Block.stone});
	    }
	    
	    public static void addInstance(){
	    	stoneHelmet = new ItemStoneArmor(stoneHelmetID, sampleArmorEnum, 0, 0, "stone").setUnlocalizedName("stoneHelmet").setTextureName("enderarmor:stone_helmet");
			GameRegistry.registerItem(stoneHelmet, "stonehelmet");
			stoneChestplate = new ItemStoneArmor(stoneChestplateID, sampleArmorEnum, 0, 1, "stone").setUnlocalizedName("stoneChestplate").setTextureName("enderarmor:stone_chestplate");
			GameRegistry.registerItem(stoneChestplate, "stonechestplate");
			stoneLeggings = new ItemStoneArmor(stoneLeggingsID, sampleArmorEnum, 0, 2, "stone").setUnlocalizedName("stoneLeggings").setTextureName("enderarmor:stone_leggings");
			GameRegistry.registerItem(stoneLeggings, "stoneleggings");
			stoneBoots = new ItemStoneArmor(stoneBootsID, sampleArmorEnum, 0, 3, "stone").setUnlocalizedName("stoneBoots").setTextureName("enderarmor:stone_boots");
			GameRegistry.registerItem(stoneBoots, "stoneboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("STONEARMOR",750, new int[]{3, 8, 6, 3}, 9);
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