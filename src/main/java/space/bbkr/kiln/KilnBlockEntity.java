package space.bbkr.kiln;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import space.bbkr.kiln.mixin.AbstractFurnaceBlockEntityAccessor;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
	protected KilnBlockEntity() {
		super(Kiln.KILN_BE, Kiln.FIRING);
	}

	@Override
	protected Text getContainerName() {
		return new TranslatableText("container.kiln.kiln");
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new KilnScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}

	@Override
	protected int getFuelTime(ItemStack fuel) {
		return super.getFuelTime(fuel) / 2;
	}

	@Override
	public void tick() {
		if (this.world != null && this.world.getDimension().isUltrawarm()) {
			((AbstractFurnaceBlockEntityAccessor)this).setBurnTime(4);
			((AbstractFurnaceBlockEntityAccessor)this).setFuelTime(4);
			//just in case it somehow becomes non-lit (which shouldn't happen but who knows)
			if (!getCachedState().get(AbstractFurnaceBlock.LIT)) {
				world.setBlockState(pos, world.getBlockState(pos).with(AbstractFurnaceBlock.LIT, true), 3);
			}
		}
		super.tick();
	}
}