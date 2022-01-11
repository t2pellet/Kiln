package space.bbkr.kiln.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.client.categories.cooking.DefaultCookingCategory;
import space.bbkr.kiln.FiringRecipe;
import space.bbkr.kiln.Kiln;

public class KilnREIPlugin implements REIClientPlugin {

	@Override
	public void registerCategories(CategoryRegistry registry) {
		registry.addWorkstations(FiringDisplay.ID, EntryStacks.of(Kiln.KILN));
		registry.add(new DefaultCookingCategory(FiringDisplay.ID, EntryStacks.of(Kiln.KILN), "category.kiln.firing"));
	}

	@Override
	public void registerDisplays(DisplayRegistry registry) {
		registry.registerFiller(FiringRecipe.class, FiringDisplay::new);
	}
}
