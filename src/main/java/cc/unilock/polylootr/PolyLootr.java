package cc.unilock.polylootr;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.rsm.api.RegistrySyncUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import noobanidus.mods.lootr.common.api.LootrAPI;
import noobanidus.mods.lootr.fabric.init.ModParticles;
import noobanidus.mods.lootr.fabric.init.ModTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolyLootr implements ModInitializer {
	public static final String MOD_ID = "polylootr";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from PolyLootr!");

		PolymerResourcePackUtils.addModAssets("lootr");

		RegistrySyncUtils.setServerEntry(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs.LOOTR_TAB);
		RegistrySyncUtils.setServerEntry(BuiltInRegistries.LOOT_CONDITION_TYPE, LootrAPI.rl("loot_count"));
		RegistrySyncUtils.setServerEntry(BuiltInRegistries.PARTICLE_TYPE, ModParticles.REFRESH_PARTICLE);
		RegistrySyncUtils.setServerEntry(BuiltInRegistries.PARTICLE_TYPE, ModParticles.UNOPENED_PARTICLE);
	}
}
