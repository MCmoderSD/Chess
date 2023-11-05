package de.MCmoderSD.main;

import de.MCmoderSD.core.Game;
import de.MCmoderSD.utilities.Calculate;


public class Main {
    public static boolean isRunning = true;
    private static boolean assetStreaming;

    public static void main(String[] args) {
        assetStreaming = !Calculate.doesFileExist("/config/default.json.json");

        if (assetStreaming) new Game(new Config(args));
        else
            new Game(new Config(args, "https://www.raw.githubusercontent.com/MCmoderSD/Chess/master/src/main/resources"));
    }
}
