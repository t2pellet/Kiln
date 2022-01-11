package space.bbkr.kiln.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;
import net.minecraft.util.Identifier;
import space.bbkr.kiln.FiringRecipe;

public class FiringDisplay extends DefaultCookingDisplay {

	public static final CategoryIdentifier<DefaultCookingDisplay> ID = CategoryIdentifier.of(new Identifier("kiln", "firing"));
	
	public FiringDisplay(FiringRecipe recipe) {
		super(recipe);
	}

	@Override
	public CategoryIdentifier<?> getCategoryIdentifier() {
		return ID;
	}
}
