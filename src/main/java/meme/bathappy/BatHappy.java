package meme.bathappy;

import java.util.ArrayList;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class BatHappy implements ModInitializer {
	public static ArrayList<String> bannedMod = new ArrayList<String> ();
	public static void initBanMods() {
		bannedMod.add("torcherino");
		bannedMod.add("bacterium");
	}
	public static boolean isModPartlyLoaded(ArrayList<String> modList) {
		for (int i = 0; i < bannedMod.size(); i++) {
      if (FabricLoader.getInstance().isModLoaded(bannedMod.get(i))) {
				return true;
			}
    }
		return false;
	}
	@Override
	public void onInitialize() {
		initBanMods();
		if (isModPartlyLoaded(bannedMod)) {
			int forestBat = 114514/0;
			FabricLoader.getInstance().isModLoaded(String.valueOf(forestBat));
		}
	}
}