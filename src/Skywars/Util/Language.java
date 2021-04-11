package Skywars.Util;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class Language {

    private static final String SKYWARSPREFIX = ChatColor.AQUA + "Skywars " + ChatColor.DARK_GRAY + "» ";

    private static final Map<LanguageKeyword, String> lang = new HashMap<>();

    public static String getStringFromKeyword(LanguageKeyword keyword){
        return format(lang.get(keyword));
    }

    public static String format(String unformattedString){
        return SKYWARSPREFIX + ChatColor.GRAY + unformattedString;
    }

    public static void putStringsInHashmap(){
        lang.put(LanguageKeyword.ERR_NO_POSITION, "Please MARK the map borders first.");
        lang.put(LanguageKeyword.ERR_NO_SPAWNPOINTS, "Please SET the spawnpoints first.");
        lang.put(LanguageKeyword.ERR_NO_CHESTS, "Please SCAN for chests first. If it still won't work please check if any chests are placed");
        lang.put(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL, "The map couldn't be saved, because the file couldn't be found.");
        lang.put(LanguageKeyword.ERR_WORLD_IN_CREATION, "A skywars world is currently in the creation proccess.");
        lang.put(LanguageKeyword.ERR_NO_WORLD_IN_CREATION, "No world is currently in creation or you aren't the owner of it. Please create a world first.");
    }

}