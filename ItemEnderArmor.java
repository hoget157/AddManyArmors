package mods.enderarmors;
 
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class ItemEnderArmor extends ItemArmor 
{
	public static Item enderHelmet;
	public static int enderHelmetID = 28524;
	public static Item enderChestplate;
	public static int enderChestplateID = 28525;
	public static Item enderLeggings;
	public static int enderLeggingsID = 28526;
	public static Item enderBoots;
	public static int enderBootsID = 28527;
	public static EnumArmorMaterial sampleArmorEnum;
	
	private String texturePath = Main.modid + ":" + "textures/models/armor/";
 
	   public ItemEnderArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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

	    	LanguageRegistry.addName(enderHelmet, "Ender Helmet");
	    	LanguageRegistry.instance().addNameForObject(enderHelmet, "ja_JP", "エンダーヘルメット");
	    	GameRegistry.addRecipe(new ItemStack(enderHelmet), 
	    			new Object[]{ "XXX","X X",
	    			'X',Item.enderPearl});
	    	LanguageRegistry.addName(enderChestplate, "Ender Chestplate");
	    	LanguageRegistry.instance().addNameForObject(enderChestplate, "ja_JP", "エンダーチェストプレート");
	    	GameRegistry.addRecipe(new ItemStack(enderChestplate), 
	    			new Object[]{ "X X","XXX","XXX",
	    			'X',Item.enderPearl});
	    	LanguageRegistry.addName(enderLeggings, "Ender Leggings");
	    	LanguageRegistry.instance().addNameForObject(enderLeggings, "ja_JP", "エンダーレギンス");
	    	GameRegistry.addRecipe(new ItemStack(enderLeggings), 
	    			new Object[]{ "XXX","X X","X X",
	    			'X',Item.enderPearl});
	    	LanguageRegistry.addName(enderBoots, "Ender Boots");
	    	LanguageRegistry.instance().addNameForObject(enderBoots, "ja_JP", "エンダーブーツ");
	    	GameRegistry.addRecipe(new ItemStack(enderBoots), 
	    			new Object[]{ "X X","X X",	
	    			'X',Item.enderPearl});
	    }
	    
	    public static void addInstance(){
	    	enderHelmet = new ItemEnderArmor(enderHelmetID, sampleArmorEnum, 0, 0, "ender").setUnlocalizedName("enderHelmet").setTextureName("enderarmor:ender_helmet");
			GameRegistry.registerItem(enderHelmet, "enderhelmet");
			enderChestplate = new ItemEnderArmor(enderChestplateID, sampleArmorEnum, 0, 1, "ender").setUnlocalizedName("enderChestplate").setTextureName("enderarmor:ender_chestplate");
			GameRegistry.registerItem(enderChestplate, "enderchestplate");
			enderLeggings = new ItemEnderArmor(enderLeggingsID, sampleArmorEnum, 0, 2, "ender").setUnlocalizedName("enderLeggings").setTextureName("enderarmor:ender_leggings");
			GameRegistry.registerItem(enderLeggings, "enderleggings");
			enderBoots = new ItemEnderArmor(enderBootsID, sampleArmorEnum, 0, 3, "ender").setUnlocalizedName("enderBoots").setTextureName("enderarmor:ender_boots");
			GameRegistry.registerItem(enderBoots, "enderboots");
	    }
	    
	    public static void setMaterial(){
	    	sampleArmorEnum = EnumHelper.addArmorMaterial("ENDERARMOR",256, new int[]{3, 8, 6, 3}, 9);
			sampleArmorEnum.customCraftingMaterial = Item.enderPearl;
	    }
	    
	    public static void EnderTick(){
	    	ItemStack itemStack = ForgeEventClass.invent.armorItemInSlot(3);
	        if ((itemStack != null) && (itemStack.itemID == 28524 + 256)) {
	        	if (ForgeEventClass.player.isWet()){
	        		ForgeEventClass.player.attackEntityFrom(DamageSource.drown, 1.0F);
	            }
	        }
	    }
	   
	    public static void PressKey_P(){
	    	ItemStack itemStack = ForgeEventClass.invent.armorItemInSlot(3);
	        if ((itemStack != null) && (itemStack.itemID == 28524 + 256)) {
	        	Vec3 vec = ForgeEventClass.player.getLook(1.0F);
	        	double posX,posY,posZ;
	        	for(int i = 0;i < 64;i++){
	        		posX = ForgeEventClass.player.posX + vec.xCoord * i;
	        		posY = ForgeEventClass.player.posY + vec.yCoord * i;
	        		posZ = ForgeEventClass.player.posZ + vec.zCoord * i;
	        		if(ForgeEventClass.world.getBlockId((int)posX,(int)posY,(int)posZ) != 0){
	        			ForgeEventClass.player.setPositionAndUpdate(posX,posY + 1,posZ);
	        			return;
	        		}
	        	}
	        }	
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