package org.redfrog404.mods.magicalness;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "Magicalness";
	public static final String VERSION = "1.0";

	// Materials

	public static Item PowerPellet;
	public static Item SparklingDust;
	public static Item TransmutationCatalyst;

	// Staves

	public static Item StaffEntropicDestruction;

	// Wands

	public static CreativeTabs MagicalnessTab = new MagicalnessTab(
			CreativeTabs.getNextID(), "MagicalnessTab");

	@EventHandler
	public void init(FMLInitializationEvent event) {
		RenderItem render = Minecraft.getMinecraft().getRenderItem();

		PowerPellet = new PowerPellet();
		GameRegistry.registerItem(PowerPellet, "PowerPellet");
		ModelResourceLocation PowerPelletModel = new ModelResourceLocation(
				"magicalness:PowerPellet", "inventory");
		render.getItemModelMesher().register(PowerPellet, 0, PowerPelletModel);

		GameRegistry.addRecipe(new ItemStack(PowerPellet, 4), "grg", "rer",
				"grg", 'e', Items.emerald, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 4), "rgr", "geg",
				"rgr", 'e', Items.emerald, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 2), "grg", "rdr",
				"grg", 'd', Items.diamond, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 2), "rgr", "gdg",
				"rgr", 'd', Items.diamond, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 2), "grg", "rer",
				"grg", 'e', Items.ender_eye, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 2), "rgr", "geg",
				"rgr", 'e', Items.ender_eye, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 1), "grg", "rer",
				"grg", 'e', Items.ender_pearl, 'r', Items.redstone, 'g',
				Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(PowerPellet, 1), "rgr", "geg",
				"rgr", 'e', Items.ender_pearl, 'r', Items.redstone, 'g',
				Items.glowstone_dust);

		SparklingDust = new SparklingDust();
		GameRegistry.registerItem(SparklingDust, "SparklingDust");
		ModelResourceLocation SparklingDustModel = new ModelResourceLocation(
				"magicalness:SparklingDust", "inventory");
		render.getItemModelMesher().register(SparklingDust, 0,
				SparklingDustModel);

		ItemStack glowstone = new ItemStack(Items.glowstone_dust);

		GameRegistry.addShapelessRecipe(new ItemStack(SparklingDust, 8),
				new ItemStack(PowerPellet), glowstone, glowstone, glowstone,
				new ItemStack(Items.iron_ingot), new ItemStack(Items.diamond),
				new ItemStack(Blocks.redstone_block), new ItemStack(
						Items.gold_nugget));

		StaffEntropicDestruction = new StaffEntropicDestruction();
		GameRegistry.registerItem(StaffEntropicDestruction,
				"StaffEntropicDestruction");
		ModelResourceLocation StaffEntropicDestructionLocation = new ModelResourceLocation(
				"magicalness:StaffEntropicDestruction", "inventory");
		render.getItemModelMesher().register(StaffEntropicDestruction, 0,
				StaffEntropicDestructionLocation);

		GameRegistry.addRecipe(new ItemStack(StaffEntropicDestruction, 1),
				"Dtd", "pst", "spD", 'd', Items.diamond, 't', Blocks.tnt, 's',
				Items.stick, 'p', PowerPellet, 'D', SparklingDust);

		GameRegistry.addShapelessRecipe(new ItemStack(StaffEntropicDestruction,
				1), new ItemStack(StaffEntropicDestruction), new ItemStack(
				Blocks.tnt), new ItemStack(SparklingDust));

		TransmutationCatalyst = new TransmutationCatalyst();
		GameRegistry.registerItem(TransmutationCatalyst,
				"TransmutationCatalyst");
		ModelResourceLocation TransmutationCatalystModel = new ModelResourceLocation(
				"magicalness:TransmutationCatalyst", "inventory");
		render.getItemModelMesher().register(TransmutationCatalyst, 0,
				TransmutationCatalystModel);

		// GameRegistry.addRecipe(new ItemStack(TransmutationCatalyst, 2),
		// "DcD", "cpc",
		// "bfb", 'b', Blocks.brewing_stand, 'f', Blocks.furnace, 'c',
		// Blocks.crafting_table, 'p', PowerPellet, 'D', SparklingDust);

		GameRegistry.addRecipe(new ItemStack(TransmutationCatalyst, 2), "dcd",
				"cpc", "bfb", 'd', SparklingDust, 'c', Blocks.crafting_table,
				'p', PowerPellet, 'f', Blocks.furnace, 'b', Items.blaze_powder);
	}
}