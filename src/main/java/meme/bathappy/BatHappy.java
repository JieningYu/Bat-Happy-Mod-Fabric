package meme.bathappy;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class BatHappy implements ModInitializer {
	Path configFile = FabricLoader.getInstance().getConfigDir().resolve("mysterious_meme.json");
	BatHappyConfig config = BatHappyConfig.loadConfigFile(configFile.toFile());

	public static Boolean isModPartlyLoaded(List<String> modList) {
		ArrayList<String> list = (ArrayList<String>) modList;
		list.add("torcherino");	//torcherino must be banned from using because it's vicious
		for (String mod : list) {
			if (FabricLoader.getInstance().isModLoaded(mod)) return true;
		}
		return false;
	}

	public static String outputMemeWord() {
		Random random = new Random();
		ArrayList<String> memes = new ArrayList<String>();
		memes.add("新人请说出你的常用模组");
		memes.add("快护好自己的PY吧，朋友。");
		memes.add("在？PY又痒了？");
		memes.add("谢谢你，但是请不要对任何人说我掉到了厕所里。");
		memes.add("《MC开发可以有多愚蠢》");

		return memes.get(random.nextInt(memes.size())-1);
	}

	@Override
	public void onInitialize() {
		if (isModPartlyLoaded(config.bannedMods)) throw new RuntimeException(outputMemeWord());
	}
}