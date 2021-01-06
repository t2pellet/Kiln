package space.bbkr.kiln.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import space.bbkr.kiln.Kiln;

public class KilnClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(Kiln.KILN_SCREEN_HANDLER, KilnScreen::new);
	}
}
