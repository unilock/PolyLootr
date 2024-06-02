package cc.unilock.polylootr;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolyLootr implements ModInitializer {
	public static final String MOD_ID = "polylootr";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from PolyLootr!");
	}
}
