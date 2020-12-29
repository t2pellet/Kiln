package space.bbkr.kiln;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class KilnScreenHandler extends AbstractFurnaceScreenHandler {
	//why is it an enum aaaaaaaaaaaaaaaaaaaaaaaaaa
	public KilnScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(Kiln.KILN_SCREEN_HANDLER, Kiln.FIRING, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory);
	}

	public KilnScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(Kiln.KILN_SCREEN_HANDLER, Kiln.FIRING, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory, inventory, propertyDelegate);
	}
}
