package space.bbkr.kiln;

import java.util.Optional;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class Kiln implements ModInitializer {
	public static final String MODID = "kiln";

	public static final Logger logger = LogManager.getLogger();

	public static final Block KILN = Registry.register(Registry.BLOCK, new Identifier(MODID, MODID), new KilnBlock(FabricBlockSettings.copy(Blocks.BRICKS)));
	public static final BlockEntityType<KilnBlockEntity> KILN_BE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, MODID), BlockEntityType.Builder.create(KilnBlockEntity::new, KILN).build(null));
	public static final RecipeType<FiringRecipe> FIRING = Registry.register(Registry.RECIPE_TYPE, new Identifier(MODID, "firing"), new RecipeType<FiringRecipe>() {
		@Override
		public String toString() {
			return "firing";
		}
	});
	public static final RecipeSerializer<FiringRecipe> FIRING_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MODID, "firing"), new CookingRecipeSerializer<>(FiringRecipe::new, 100));
	public static final ScreenHandlerType<KilnScreenHandler> KILN_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(MODID, MODID), new ScreenHandlerType<>(KilnScreenHandler::new));
	public static final Identifier INTERACT_WITH_KILN = new Identifier(MODID, "interact_with_kiln");

	@Override
	public void onInitialize() {
		Registry.register(Registry.CUSTOM_STAT, INTERACT_WITH_KILN, INTERACT_WITH_KILN);
		Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_KILN);
		Registry.register(Registry.ITEM, new Identifier(MODID, MODID), new BlockItem(KILN, new Item.Settings().group(ItemGroup.DECORATIONS)));
	}
}
