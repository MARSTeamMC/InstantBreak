package net.mars.instantbreak_mt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantBreak implements ModInitializer {
	public static final String MOD_ID = "instantbreak_mt";
	public static final double MDECILLION = Math.pow(10, 256);

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModContainer mod = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
		String version = mod.getMetadata().getVersion().getFriendlyString();

		LOGGER.info("[{}] v{} initialized by MARS Team.", MOD_ID, version);
	}
}