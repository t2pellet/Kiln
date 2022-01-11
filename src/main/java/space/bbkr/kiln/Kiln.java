package space.bbkr.kiln;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Kiln implements ModInitializer {
	public static final String MODID = "kiln";

	// Stat
	public static final Identifier INTERACT_WITH_KILN = new Identifier(MODID, "interact_with_kiln");
	// Recipe
	public static final RecipeType<FiringRecipe> FIRING = new RecipeType<>() {
		@Override
		public String toString() {
			return "kiln:firing";
		}
	};
	public static final RecipeSerializer<FiringRecipe> FIRING_SERIALIZER = new CookingRecipeSerializer<>(FiringRecipe::new, 200);
	// Block
	public static final Block KILN = new KilnBlock(FabricBlockSettings.copy(Blocks.BRICKS));
	public static final BlockEntityType<KilnBlockEntity> KILN_BE = FabricBlockEntityTypeBuilder.create(KilnBlockEntity::new, KILN).build(null);
	// GUI
	public static final ScreenHandlerType<KilnScreenHandler> KILN_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, MODID), KilnScreenHandler::new);

	@Override
	public void onInitialize() {
		// Register recipe
		Registry.register(Registry.RECIPE_TYPE, new Identifier(MODID, "firing"), FIRING);
		Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MODID, "firing"), FIRING_SERIALIZER);
		// Register block & BE
		Registry.register(Registry.BLOCK, new Identifier(MODID, MODID), KILN);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, MODID), KILN_BE);
		// Register item
		Registry.register(Registry.ITEM, new Identifier(MODID, MODID), new BlockItem(KILN, new Item.Settings().group(ItemGroup.DECORATIONS)));
		// Register stat
		Registry.register(Registry.CUSTOM_STAT, INTERACT_WITH_KILN, INTERACT_WITH_KILN);
		Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_KILN);
	}
}
