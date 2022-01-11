package space.bbkr.kiln;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {

	public KilnBlockEntity(BlockPos pos, BlockState state) {
		super(Kiln.KILN_BE, pos, state, Kiln.FIRING);
	}

	@Override
	protected Text getContainerName() {
		return new TranslatableText("container.kiln.kiln");
	}

	@Override
	protected int getFuelTime(ItemStack fuel) {
		return super.getFuelTime(fuel) / 2;
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new KilnScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}

	@Override
	public boolean isValid(int slot, ItemStack stack) {
		return super.isValid(slot, stack);
	}

	@Override
	public void setStack(int slot, ItemStack stack) {
		super.setStack(slot, stack);
	}
}