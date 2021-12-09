package space.bbkr.kiln.compat.rei;

import org.jetbrains.annotations.NotNull;

import me.shedaniel.rei.plugin.cooking.DefaultCookingDisplay;
import net.minecraft.util.Identifier;
import space.bbkr.kiln.FiringRecipe;

public class FiringDisplay extends DefaultCookingDisplay {

	public static final Identifier ID = new Identifier("kiln", "firing");
	
	public FiringDisplay(FiringRecipe recipe) {
		super(recipe);
	}

	@Override
	public @NotNull Identifier getRecipeCategory() {
		return ID;
	}

}
