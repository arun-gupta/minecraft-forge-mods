package org.redfrog404.mods.magicalness;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class MagicalnessTab extends CreativeTabs
{
    public MagicalnessTab(int id, String name)
    {
        super(id, name);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Main.PowerPellet;
    }
}