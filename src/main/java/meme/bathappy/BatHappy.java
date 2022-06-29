package meme.bathappy;

import java.nio.file.Path;
import java.util.List;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class BatHappy implements ModInitializer {
	Path configFile = FabricLoader.getInstance().getConfigDir().resolve("bat_happy_config.json");
	BatHappyConfig config = BatHappyConfig.loadConfigFile(configFile.toFile());

	public static boolean isModPartlyLoaded(List<String> modList) {
		for (String s : modList) {
			if (FabricLoader.getInstance().isModLoaded(s)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void onInitialize() {
		if (isModPartlyLoaded(config.bannedMods)) throw new RuntimeException("Mod is not allowed");
	}
}