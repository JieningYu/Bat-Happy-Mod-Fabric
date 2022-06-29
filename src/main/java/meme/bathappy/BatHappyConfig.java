package meme.bathappy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatHappyConfig {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .disableHtmlEscaping()
            .create();

    public List<String> bannedMods = new ArrayList<String>(Arrays.asList(
            "bacterium"
    ));

    public static BatHappyConfig loadConfigFile(File file) {
        BatHappyConfig config = null;

        if (file.exists()) {
            try (BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)
            )) {
                config = gson.fromJson(fileReader, BatHappyConfig.class);
            } catch (IOException e) {
                throw new RuntimeException("[BatHappy] Problem occurred when trying to load config: ", e);
            }
        }
        if (config == null) {
            config = new BatHappyConfig();
        }

        config.saveConfigFile(file);
        return config;
    }

    public void saveConfigFile(File file) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
