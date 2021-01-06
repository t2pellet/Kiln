package space.bbkr.kiln;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class KilnBlock extends AbstractFurnaceBlock {
	protected KilnBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof KilnBlockEntity) {
			player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
			player.incrementStat(Kiln.INTERACT_WITH_KILN);
		}
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new KilnBlockEntity();
	}
}
