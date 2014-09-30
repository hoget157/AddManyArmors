package mods.enderarmors;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;


public class MyKeyHandler extends KeyHandler
{
    static KeyBinding myBinding = new KeyBinding("MyBind", Keyboard.KEY_P);
 

    public MyKeyHandler()
    {
        //the first value is an array of KeyBindings, the second is whether or not the call 
        //keyDown should repeat as long as the key is down
        super(new KeyBinding[]{myBinding}, new boolean[]{false});
    }
 
    @Override
    public String getLabel()
    {
        return "mykeybindings";
    }
 
    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {
    	if(kb.keyCode == myBinding.keyCode){
    		ItemEnderArmor.PressKey_P();
    	}
    }
 
    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
    {
        //do whatever
    }
 
    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.CLIENT);
        //I am unsure if any different TickTypes have any different effects.
    }
}
     