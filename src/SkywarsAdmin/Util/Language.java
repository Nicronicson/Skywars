package SkywarsAdmin.Util;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class Language {

    private static final String SKYWARSPREFIX = ChatColor.AQUA + "SkywarsAdmin " + ChatColor.DARK_GRAY + "» ";

    private static final Map<LanguageKeyword, String> lang = new HashMap<>();

    public static String getStringFromKeyword(LanguageKeyword keyword){
        return lang.get(keyword);
    }

    public static String format(String unformattedString){
        return SKYWARSPREFIX + ChatColor.GRAY + unformattedString;
    }

    static {
        lang.put(LanguageKeyword.ERR_NO_POSITION, "Please MARK the map borders first.");
        lang.put(LanguageKeyword.ERR_NO_MIDDLE, "Please MARK the middle of the map first.");
        lang.put(LanguageKeyword.ERR_NO_SPAWNPOINTS, "Please SET the spawnpoints first.");
        lang.put(LanguageKeyword.ERR_NO_CHESTS, "Please SCAN for chests first. If it still won't work please check if any chests are placed.");
        lang.put(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL, "The map/kit couldn't be saved, because the file couldn't be found or something went wrong like a banana which fell in a vulcano.");
        lang.put(LanguageKeyword.ERR_WORLD_IN_CREATION, "A skywars world is currently in the creation proccess.");
        lang.put(LanguageKeyword.ERR_NO_WORLD_IN_CREATION, "No world is currently in creation or you aren't the owner of it. Please create a world first.");
        lang.put(LanguageKeyword.ERR_MAP_EXISTING, "The Map/Kit already exists. Repeat command to override.");
        lang.put(LanguageKeyword.CMD_MAP_TRASHED, "Skywarsmap was TRASHED successfully.");
        lang.put(LanguageKeyword.CMD_MAP_CREATED, "Skywarsmap was CREATED successfully.");
        lang.put(LanguageKeyword.CMD_MAP_SAVED, "Skywarsmap was SAVED successfully.");
        lang.put(LanguageKeyword.CMD_ADD_SPAWNPOINT, "Spawnpoint was ADDED successfully.");
        lang.put(LanguageKeyword.CMD_RESET_SPAWNPOINTS, "Spawnpoints were DELETED successfully.");
        lang.put(LanguageKeyword.CMD_SCAN_CHESTS, "Chest-Scan was DONE successfully.");
        lang.put(LanguageKeyword.CMD_SET_POS1, "Pos1 was SET successfully.");
        lang.put(LanguageKeyword.CMD_SET_POS2, "Pos2 was SET successfully.");
        lang.put(LanguageKeyword.CMD_SET_MIDDLE, "Middle was SET successfully.");
    }
}