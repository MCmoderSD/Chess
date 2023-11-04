package de.MCmoderSD.main;

import com.fasterxml.jackson.databind.JsonNode;
import de.MCmoderSD.utilities.ImageReader;
import de.MCmoderSD.utilities.ImageStreamer;
import de.MCmoderSD.utilities.JsonReader;
import de.MCmoderSD.utilities.MySQL;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class Config {

    // Associations;
    private final MySQL mySQL;
    private final ImageReader imageReader;
    private final ImageStreamer imageStreamer;

    // Constants
    private final String[] args;
    private final int width;
    private final int height;
    private final boolean isResizable;
    private final String gameID;
    private final String language;

    // Assets
    private final Dimension dimension;
    private final BufferedImage icon;

    private final BufferedImage[] pawn = new BufferedImage[2];
    private final BufferedImage[] rook = new BufferedImage[2];
    private final BufferedImage[] knight = new BufferedImage[2];
    private final BufferedImage[] bishop = new BufferedImage[2];
    private final BufferedImage[] queen = new BufferedImage[2];
    private final BufferedImage[] king = new BufferedImage[2];

    // Language
    private final String title;

    // Default Constructor
    public Config(String[] args) {
        this.args = args;

        // Language
        if (args.length == 0) language = "en";
        else language = args[0].toLowerCase();

        // GameID
        if (args.length == 2) gameID = args[1];
        else gameID = null;


        // Read Config
        JsonReader jsonReader = new JsonReader();
        JsonNode database = jsonReader.read("/config/database.json");

        // Initialize MySQL Connection
        mySQL = new MySQL(

                database.get("host").asText(),
                database.get("port").asInt(),
                database.get("database").asText(),
                database.get("user").asText(),
                database.get("password").asText(),
                database.get("table").asText(),
                gameID);

        mySQL.connect();

        // Constants
        JsonNode config = jsonReader.read("/config/default.json.json");
        width = config.get("width").asInt();
        height = config.get("height").asInt();
        isResizable = config.get("isResizable").asBoolean();
        dimension = new Dimension(width, height);
        imageReader = new ImageReader();
        imageStreamer = null;

        // Assets
        icon = imageReader.read(config.get("icon").asText());
        pawn[0] = imageReader.read(config.get("whitePawn").asText());
        rook[0] = imageReader.read(config.get("whiteRook").asText());
        knight[0] = imageReader.read(config.get("whiteKnight").asText());
        bishop[0] = imageReader.read(config.get("whiteBishop").asText());
        queen[0] = imageReader.read(config.get("whiteQueen").asText());
        king[0] = imageReader.read(config.get("whiteKing").asText());
        pawn[1] = imageReader.read(config.get("blackPawn").asText());
        rook[1] = imageReader.read(config.get("blackRook").asText());
        knight[1] = imageReader.read(config.get("blackKnight").asText());
        bishop[1] = imageReader.read(config.get("blackBishop").asText());
        queen[1] = imageReader.read(config.get("blackQueen").asText());
        king[1] = imageReader.read(config.get("blackKing").asText());

        // Language
        JsonNode language = jsonReader.read("/language/" + this.language + ".json");
        title = language.get("title").asText();
    }

    // Streaming Constructor
    public Config(String[] args, String url) {
        this.args = args;

        // Language
        if (args.length == 0) language = "en";
        else language = args[0].toLowerCase();

        // GameID
        if (args.length == 2) gameID = args[1];
        else gameID = null;


        // Read Config
        JsonReader jsonReader = new JsonReader();
        JsonNode database = jsonReader.read(url + "/config/database.json");

        // Initialize MySQL Connection
        mySQL = new MySQL(

                database.get("host").asText(),
                database.get("port").asInt(),
                database.get("database").asText(),
                database.get("user").asText(),
                database.get("password").asText(),
                database.get("table").asText(),
                gameID);

        mySQL.connect();

        // Constants
        JsonNode config = jsonReader.read(url + "/config/default.json.json");
        width = config.get("width").asInt();
        height = config.get("height").asInt();
        isResizable = config.get("isResizable").asBoolean();
        dimension = new Dimension(width, height);
        imageReader = new ImageReader();
        imageStreamer = null;

        // Assets
        icon = imageReader.read(config.get("icon").asText());
        pawn[0] = imageReader.read(config.get("whitePawn").asText());
        rook[0] = imageReader.read(config.get("whiteRook").asText());
        knight[0] = imageReader.read(config.get("whiteKnight").asText());
        bishop[0] = imageReader.read(config.get("whiteBishop").asText());
        queen[0] = imageReader.read(config.get("whiteQueen").asText());
        king[0] = imageReader.read(config.get("whiteKing").asText());
        pawn[1] = imageReader.read(config.get("blackPawn").asText());
        rook[1] = imageReader.read(config.get("blackRook").asText());
        knight[1] = imageReader.read(config.get("blackKnight").asText());
        bishop[1] = imageReader.read(config.get("blackBishop").asText());
        queen[1] = imageReader.read(config.get("blackQueen").asText());
        king[1] = imageReader.read(config.get("blackKing").asText());

        // Language
        JsonNode language = jsonReader.read(url + "/language/" + this.language + ".json");
        title = language.get("title").asText();
    }

    // Getters

    // Associations
    public MySQL getMySQL() {
        return mySQL;
    }

    public ImageReader getImageReader() {
        return imageReader;
    }

    public ImageStreamer getImageStreamer() {
        return imageStreamer;
    }

    // Constants
    public String[] getArgs() {
        return args;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isResizable() {
        return isResizable;
    }

    public String getGameID() {
        return gameID;
    }

    public String getLanguage() {
        return language;
    }

    // Assets
    public Dimension getDimension() {
        return dimension;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public BufferedImage[] getPawn() {
        return pawn;
    }

    public BufferedImage[] getRook() {
        return rook;
    }

    public BufferedImage[] getKnight() {
        return knight;
    }

    public BufferedImage[] getBishop() {
        return bishop;
    }

    public BufferedImage[] getQueen() {
        return queen;
    }

    public BufferedImage[] getKing() {
        return king;
    }

    // Language
    public String getTitle() {
        return title;
    }

}
