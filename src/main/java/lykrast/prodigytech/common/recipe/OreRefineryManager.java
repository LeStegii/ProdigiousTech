package lykrast.prodigytech.common.recipe;

import java.util.HashMap;
import java.util.Map;

import lykrast.prodigytech.common.init.ModItems;
import lykrast.prodigytech.common.util.Configuration;
import lykrast.prodigytech.common.util.RecipeUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class OreRefineryManager extends SimpleRecipeManagerSecondaryOutput {
	public static final OreRefineryManager INSTANCE = new OreRefineryManager();
	
	public SimpleRecipeSecondaryOutput addRecipe(ItemStack in, ItemStack out) {
		return addRecipe(new SimpleRecipeSecondaryOutput(in, out, Configuration.MACHINES.oreRefineryProcessTime));
	}
	
	public SimpleRecipeSecondaryOutput addRecipe(String inOre, ItemStack out) {
		return addRecipe(new SimpleRecipeSecondaryOutput(inOre, out, Configuration.MACHINES.oreRefineryProcessTime));
	}
	
	public SimpleRecipeSecondaryOutput addRecipe(ItemStack in, ItemStack out, ItemStack secondary) {
		return addRecipe(new SimpleRecipeSecondaryOutput(in, out, secondary, Configuration.MACHINES.oreRefineryProcessTime));
	}
	
	public SimpleRecipeSecondaryOutput addRecipe(String inOre, ItemStack out, ItemStack secondary) {
		return addRecipe(new SimpleRecipeSecondaryOutput(inOre, out, secondary, Configuration.MACHINES.oreRefineryProcessTime));
	}
	
	public SimpleRecipeSecondaryOutput addRecipe(ItemStack in, ItemStack out, ItemStack secondary, float secondaryChance) {
		return addRecipe(new SimpleRecipeSecondaryOutput(in, out, secondary, Configuration.MACHINES.oreRefineryProcessTime, secondaryChance));
	}
	
	public SimpleRecipeSecondaryOutput addRecipe(String inOre, ItemStack out, ItemStack secondary, float secondaryChance) {
		return addRecipe(new SimpleRecipeSecondaryOutput(inOre, out, secondary, Configuration.MACHINES.oreRefineryProcessTime, secondaryChance));
	}
	
	//Preferred secondary output for each ore
	private Map<String,String[]> secondaryOres;

	@Override
	public void init() {
		secondaryOres = new HashMap<>();
		
		//Use Thermal Expansion secondary dusts first, then IndustrialCraft 2, then Immersive Engineering
		secondaryOres.put("Iron", new String[] {"dustNickel", "dustGold"});
		secondaryOres.put("Gold", new String[] {"dustCopper", "dustSilver"});
		secondaryOres.put("Copper", new String[] {"dustGold"});
		secondaryOres.put("Tin", new String[] {"dustIron"});
		secondaryOres.put("Silver", new String[] {"dustLead"});
		secondaryOres.put("Lead", new String[] {"dustSilver", "dustCopper"});
		secondaryOres.put("Aluminum", new String[] {"dustIron"});
		secondaryOres.put("Aluminium", new String[] {"dustIron"});
		secondaryOres.put("Nickel", new String[] {"dustPlatinum", "dustIron"});
		secondaryOres.put("Platinum", new String[] {"dustIridium", "dustNickel"});
		secondaryOres.put("Iridium", new String[] {"dustPlatinum"});
		
		ItemStack sulfur = RecipeUtil.oreExists("dustSulfur") ? RecipeUtil.getPreferredOreStack("dustSulfur") : ItemStack.EMPTY;
		
		addRecipe("oreCoal", new ItemStack(ModItems.coalDust, Configuration.MACHINES.oreRefineryOreMultiplier), sulfur, Configuration.MACHINES.oreRefineryChance);
		if (!Configuration.MACHINES.autoOreRecipes) addRecipe("oreIron", new ItemStack(ModItems.ironDust, Configuration.MACHINES.oreRefineryOreMultiplier), new ItemStack(ModItems.goldDust), Configuration.MACHINES.oreRefineryChance);
		if (!Configuration.MACHINES.autoOreRecipes) addRecipe("oreGold", new ItemStack(ModItems.goldDust, Configuration.MACHINES.oreRefineryOreMultiplier));
		addRecipe("oreLapis", new ItemStack(Items.DYE, 6 * Configuration.MACHINES.oreRefineryOreMultiplier, 4), sulfur, Configuration.MACHINES.oreRefineryChance);
		addRecipe("oreRedstone", new ItemStack(Items.REDSTONE, (int)(4.5 * Configuration.MACHINES.oreRefineryOreMultiplier)));
		if (!Configuration.MACHINES.autoOreRecipes) addRecipe("oreDiamond", new ItemStack(ModItems.diamondDust, Configuration.MACHINES.oreRefineryOreMultiplier));
		if (!Configuration.MACHINES.autoOreRecipes) addRecipe("oreEmerald", new ItemStack(ModItems.emeraldDust, Configuration.MACHINES.oreRefineryOreMultiplier));
		addRecipe("oreQuartz", new ItemStack(ModItems.quartzDust, Configuration.MACHINES.oreRefineryOreMultiplier), sulfur, Configuration.MACHINES.oreRefineryChance);
	}
	
	public void addOreRecipe(String ore, String input, String output) {
		ItemStack stackOutput = RecipeUtil.getPreferredOreStack(output);
		stackOutput.setCount(Configuration.MACHINES.oreRefineryOreMultiplier);
		ItemStack stackSecondary = getPreferredSecondary(ore);
		
		addRecipe(input, stackOutput, stackSecondary, Configuration.MACHINES.oreRefineryChance);
	}
	
	private ItemStack getPreferredSecondary(String ore) {
		String[] secondary = secondaryOres.get(ore);
		if (secondary == null) return ItemStack.EMPTY;
		
		for (String s : secondary)
		{
			if (RecipeUtil.oreExists(s)) return RecipeUtil.getPreferredOreStack(s);
		}
		
		return ItemStack.EMPTY;
	}

}
