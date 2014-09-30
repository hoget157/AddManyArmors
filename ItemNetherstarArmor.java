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
 
public class ItemNetherstarArmor extends ItemArmor 
{
	public static Item netherstarHelmet;
	public static int netherstarHelmetID = 28536;
	public static Item netherstarChestplate;
	public static int netherstarChestplateID = 28537;
	public static Item netherstarLeggings;
	public static int netherstarLeggingsID = 28538;
	public static Item netherstarBoots;
	public static int netherstarBootsID = 28539;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemNetherstarArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(netherstarHelmet, "NetherStar Helmet");
	    	LanguageRegistry.instance().addNameForObject(netherstarHelmet, "ja_JP", "ネザースターヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(netherstarHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Item.netherStar});
	    	LanguageRegistry.addName(netherstarChestplate, "NetherStar Chestplate");
	    	LanguageRegistry.instance().addNameForObject(netherstarChestplate, "ja_JP", "ネザースターチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(netherstarChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Item.netherStar});
	    	LanguageRegistry.addName(netherstarLeggings, "NetherStar Leggings");
	    	LanguageRegistry.instance().addNameForObject(netherstarLeggings, "ja_JP", "ネザースターレギンス");
	    	GameRegistry.addRecipe(new ItemStack(netherstarLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Item.netherStar});
	    	LanguageRegistry.addName(netherstarBoots, "NetherStar Boots");
	    	LanguageRegistry.instance().addNameForObject(netherstarBoots, "ja_JP", "ネザースターブーツ");
	    	GameRegistry.addRecipe(new ItemStack(netherstarBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Item.netherStar});
	    }
	    
	    public static void addInstance(){
	    	netherstarHelmet = new ItemNetherstarArmor(netherstarHelmetID, sampleArmorEnum, 0, 0, "netherstar").setUnlocalizedName("netherstarHelmet").setTextureName("enderarmor:netherstar_helmet");
			GameRegistry.registerItem(netherstarHelmet, "netherstarhelmet");
			netherstarChestplate = new ItemNetherstarArmor(netherstarChestplateID, sampleArmorEnum, 0, 1, "netherstar").setUnlocalizedName("netherstarChestplate").setTextureName("enderarmor:netherstar_chestplate");
			GameRegistry.registerItem(netherstarChestplate, "netherstarchestplate");
			netherstarLeggings = new ItemNetherstarArmor(netherstarLeggingsID, sampleArmorEnum, 0, 2, "netherstar").setUnlocalizedName("netherstarLeggings").setTextureName("enderarmor:netherstar_leggings");
			GameRegistry.registerItem(netherstarLeggings, "netherstarleggings");
			netherstarBoots = new ItemNetherstarArmor(netherstarBootsID, sampleArmorEnum, 0, 3, "netherstar").setUnlocalizedName("netherstarBoots").setTextureName("enderarmor:netherstar_boots");
			GameRegistry.registerItem(netherstarBoots, "netherstarboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("NETHERSTARARMOR",5250, new int[]{30, 80, 60, 30}, 9);
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