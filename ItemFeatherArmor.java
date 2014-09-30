package mods.enderarmors;
 
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class ItemFeatherArmor extends ItemArmor 
{
	public static Item featherHelmet;
	public static int featherHelmetID = 28548;
	public static Item featherChestplate;
	public static int featherChestplateID = 28549;
	public static Item featherLeggings;
	public static int featherLeggingsID = 28550;
	public static Item featherBoots;
	public static int featherBootsID = 28551;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemFeatherArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(featherHelmet, "feather Helmet");
	    	LanguageRegistry.instance().addNameForObject(featherHelmet, "ja_JP", "羽のヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(featherHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Item.feather});
	    	LanguageRegistry.addName(featherChestplate, "feather Chestplate");
	    	LanguageRegistry.instance().addNameForObject(featherChestplate, "ja_JP", "羽のチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(featherChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Item.feather});
	    	LanguageRegistry.addName(featherLeggings, "feather Leggings");
	    	LanguageRegistry.instance().addNameForObject(featherLeggings, "ja_JP", "羽のレギンス");
	    	GameRegistry.addRecipe(new ItemStack(featherLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Item.feather});
	    	LanguageRegistry.addName(featherBoots, "feather Boots");
	    	LanguageRegistry.instance().addNameForObject(featherBoots, "ja_JP", "羽のブーツ");
	    	GameRegistry.addRecipe(new ItemStack(featherBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Item.feather});
	    }
	    
	    public static void addInstance(){
	    	featherHelmet = new ItemFeatherArmor(featherHelmetID, sampleArmorEnum, 0, 0, "feather").setUnlocalizedName("featherHelmet").setTextureName("enderarmor:feather_helmet");
			GameRegistry.registerItem(featherHelmet, "featherhelmet");
			featherChestplate = new ItemFeatherArmor(featherChestplateID, sampleArmorEnum, 0, 1, "feather").setUnlocalizedName("featherChestplate").setTextureName("enderarmor:feather_chestplate");
			GameRegistry.registerItem(featherChestplate, "featherchestplate");
			featherLeggings = new ItemFeatherArmor(featherLeggingsID, sampleArmorEnum, 0, 2, "feather").setUnlocalizedName("featherLeggings").setTextureName("enderarmor:feather_leggings");
			GameRegistry.registerItem(featherLeggings, "featherleggings");
			featherBoots = new ItemFeatherArmor(featherBootsID, sampleArmorEnum, 0, 3, "feather").setUnlocalizedName("featherBoots").setTextureName("enderarmor:feather_boots");
			GameRegistry.registerItem(featherBoots, "featherboots");
	    }
	    
	    public static void FeatherTick(){
	    	int ArmorCount = 0;
	        for(int i = 0;i < 4;i++){
	        	ItemStack itemStack = ForgeEventClass.invent.armorItemInSlot(i);
	        	if ((itemStack != null) && (itemStack.itemID == 28548 + 256 + (3 - i))) {
	        		ArmorCount++;
		        }
	        }
	        if(ArmorCount != 0) ForgeEventClass.player.addPotionEffect(new PotionEffect(8, 1 * 20, 0));
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("FEATHERARMOR",750, new int[]{3, 8, 6, 3}, 9);
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