package space.bbkr.kiln.compat.rei;

import me.shedaniel.rei.api.EntryStack;
import me.shedaniel.rei.api.RecipeHelper;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import me.shedaniel.rei.plugin.cooking.DefaultCookingCategory;
import net.minecraft.util.Identifier;
import space.bbkr.kiln.FiringRecipe;
import space.bbkr.kiln.Kiln;

public class KilnREIPlugin implements REIPluginV0 {

	public static final Identifier ID = new Identifier("kiln", "main");

	@Override
	public Identifier getPluginIdentifier() {
		return ID;
	}
	
	@Override
	public void registerPluginCategories(RecipeHelper recipeHelper) {
		recipeHelper.registerCategory(new DefaultCookingCategory(FiringDisplay.ID, EntryStack.create(Kiln.KILN), "category.kiln.firing"));
	}
	
	@Override
	public void registerRecipeDisplays(RecipeHelper recipeHelper) {
		recipeHelper.registerRecipes(FiringDisplay.ID, FiringRecipe.class, FiringDisplay::new);
	}
	
	@Override
	public void registerOthers(RecipeHelper recipeHelper) {
		recipeHelper.registerWorkingStations(FiringDisplay.ID, EntryStack.create(Kiln.KILN));
	}
	
	
}
